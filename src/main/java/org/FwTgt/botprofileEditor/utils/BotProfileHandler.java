package org.FwTgt.botprofileEditor.utils;

import org.FwTgt.botprofileEditor.config.DefaultConfig;
import org.FwTgt.botprofileEditor.domain.*;
import org.FwTgt.botprofileEditor.domain.exceptions.FileIllegalException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.ContextLoader;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BotProfileHandler {

    private static final int POSITION_NAME=9;

    /**
     * 标准化读取内容
     * @param input 读取的内容
     * @return 把原来字符串去掉前后的空格,并去掉注释内容的新字符串
     */
    private static String fit(String input){
        int noteIndex = input.indexOf("//");
        if(noteIndex!=-1){
            return input.substring(0,noteIndex).trim();
        }
        return input.trim();
    }

    /**
     * 给定一个botprofile文件的输入流，读取它的全部内容并且封装成BorProfile对象
     * @param profileStream bot配置文件的输入流
     * @return 封装好的配置文件
     * @throws FileIllegalException 需要读取的配置文件存在不合理的内容
     */
    public static BotProfile getData(InputStream profileStream) throws FileIllegalException {

        BotProfile botProfile = new BotProfile();   //用于接收文件的全部信息
        Scanner scanner=new Scanner(profileStream);

        String cur;                         //用来接受scanner的返回值

        try{
            readDefaultINF(botProfile,scanner);     //读取Default字段内容
        }catch (NoSuchElementException e){
            FileIllegalException fileIllegalException = new FileIllegalException();
            fileIllegalException.initCause(e);
            throw fileIllegalException;
        }

        while(scanner.hasNextLine()){
            cur=fit(scanner.nextLine());

            if(isNothing(cur)){
                doNothing();
            }
            else if(isTemplateStart(cur)){
                boolean isAttribute;
                Template template=new Template(getTemplateName(cur));
                try{
                    isAttribute = readTemplate(template,scanner);
                }catch (NoSuchElementException e){
                    FileIllegalException fileIllegalException = new FileIllegalException();
                    fileIllegalException.initCause(e);
                    throw fileIllegalException;
                }
                //根据isAttribute选择插入属性集合还是武器选择集合
                if(isAttribute){
                    botProfile.insertAttribute(template.toBotAttribute());
                } else{
                    botProfile.insertWeaponScheme(template.toBotWeaponScheme());
                }
            }
            else {
                try{
                    readBot(cur,botProfile,scanner);
                }catch (NoSuchElementException e){
                    FileIllegalException fileIllegalException = new FileIllegalException();
                    fileIllegalException.initCause(e);
                    throw fileIllegalException;
                }

            }
        }
        return botProfile;
    }

    /**
     * 读取bot配置文件中default字段中有意义的内容，并把scanner设置到Default段的End处
     * @param botProfile 文件对应的存储对象
     * @param scanner 文件的输入流
     * @throws NoSuchElementException 如果存在不存或不规范在default的定义则抛出异常
     */
    private static void readDefaultINF(BotProfile botProfile ,Scanner scanner) throws NoSuchElementException {
        String cur = scanner.nextLine();
        while(!cur.trim().startsWith("Default")){
            cur = scanner.nextLine();
        }
        cur = fit(scanner.nextLine()).replace('=',' ');
        String propertyName;
        float value;
        while(!cur.startsWith("End")){
            if(isNothing(cur)){
                continue;
            }
            Scanner reader = new Scanner(cur);
            propertyName = reader.next();
            if(!propertyName.equals("WeaponPreference")&&!propertyName.equals("Difficulty")){
                value = reader.nextFloat();
                botProfile.setProperty(propertyName,value);
            }
            cur = fit(scanner.nextLine()).replace('=',' ');
        }
    }

    /**
     * 读取bot配置文件中的模板信息封装到模板对象中，并判断模板是属性还是武器模式，并把scanner设置到模板定义结束的位置
     * @param template 要封装的模板对象
     * @param scanner 当前的输入流
     * @return 如果是属性返回true，如果是武器模板则返回false
     * @throws NoSuchElementException 如果模板被不规范定义则抛出异常
     */
    private static boolean readTemplate(Template template ,Scanner scanner) throws NoSuchElementException {

        boolean isAttribute = true;

        while(scanner.hasNextLine()){
            String cur = fit(scanner.nextLine()).replace('=',' ');
            if(cur.equals("")){
                continue;
            }
            if(cur.equals("End")){
                break;
            }
            Scanner reader = new Scanner(cur);      //用来读取每一条属性
            //System.out.println(cur);
            String attributeName = reader.next();
            //根据属性名称判断template类型
            if(attributeName.equals("WeaponPreference")||attributeName.equals("Difficulty")){
                String value=reader.next();
                if(!value.equals("none")){
                    template.setProperty(attributeName,value);
                    if(attributeName.equals("WeaponPreference")){
                        isAttribute=false;
                    }
                }
            }
            else{
                template.setProperty(attributeName,reader.nextFloat());
            }
        }
        return isAttribute;
    }

    /**
     * 读取bot配置文件中的bot信息封装到配置文件对象中，并把scanner设置到bot定义结束的位置
     * @param cur bot的定义起始信息
     * @param botProfile 要封装的配置文件对象
     * @param scanner 当前的输入流
     * @exception NoSuchElementException 如果bot被不规范定义则抛出异常
     */
    private static void readBot(String cur,BotProfile botProfile,Scanner scanner) throws NoSuchElementException{
        Bot bot = new Bot();
        cur = cur.replace('+',' ');
        Scanner reader = new Scanner(cur);
        String attributeName = reader.next();
        String weaponSchemeName = reader.next();
        String botName;
        //官方有的bot定义缺省武器模板,所以应可以支持无武器模板
        botName = reader.hasNext() ? reader.next() : weaponSchemeName;

        bot.setName(botName);
        //筛掉没有被定义过的属性和武器模板
        bot.setAttribute(botProfile.getAttributeByName(attributeName));
        bot.setWeaponScheme(botProfile.getWeaponSchemeByName(weaponSchemeName));
        //如果bot的属性被定义过，则加入bot
        if(bot.getAttribute()!=null){
            botProfile.insertBot(bot);
        }
        while(!cur.startsWith("End")){
            cur = scanner.nextLine().trim();
        }
    }

    /**
     * 判断是否是模板定义的起始处
     * @param cur 当前的读取流的内容，需要是已经fit()过的
     * @return 是返回true，否则返回false
     */
    private static boolean isTemplateStart(String cur) {
        return cur.startsWith("Template ");
    }

    /**
     * 获取模板的名字
     * @param cur 当前读取的模板定义行，需要是已经fit()过的
     * @return 模板的名字
     */
    private static String getTemplateName(String cur){
        return cur.substring(POSITION_NAME);
    }

    /**
     * 如果是无意义内容返回true
     * @param content 输入内容，需要是已经fit()过的
     * @return 无意义返回true，否则返回false
     */
    private static boolean isNothing(String content){
        return content.equals("");
    }
    private static void doNothing(){}


    /**
     * 通过一个BotProfile对象生成一个完整的botprofile内容
     * @param botProfile 生成内容的数据来源
     * @return botprofile完整的内容
     */
    public static StringBuilder packageBotprofile(BotProfile botProfile){
       // ContextLoader.getCurrentWebApplicationContext().getBean()
        DefaultConfig defaultINF= (DefaultConfig) ContextWrapper.getContext().getBean("defaultINF");
        StringBuilder builder=defaultINF.compose(botProfile);
        for(BotAttribute a:botProfile.getAttributes().values()){
            builder.append("Template ").append(a.getName());
            builder.append("\n\tSkill = ").append(a.getSkill());
            builder.append("\n\tAggression = ").append(a.getAggression());
            builder.append("\n\tReactionTime = ").append(String.format("%f",a.getReactionTime()));
            builder.append("\n\tAttackDelay = ").append(String.format("%f",a.getAttackDelay()));
            builder.append("\n\tDifficulty = ").append(a.getDifficulty());
            builder.append("\n\tAimFocusInitial = ").append(String.format("%f",a.getAimFocusInitial()));
            builder.append("\n\tAimFocusDecay = ").append(String.format("%f",a.getAimFocusDecay()));
            builder.append("\n\tAimFocusOffsetScale = ").append(String.format("%f",a.getAimFocusOffsetScale()));
            builder.append("\n\tAimfocusInterval = ").append(String.format("%f",a.getAimfocusInterval()));
            builder.append("\nEnd\n\n");
        }
        for(BotWeaponScheme w:botProfile.getWeaponSchemes().values()){
            builder.append("Template ").append(w.getName());
            Scanner weapons = new Scanner(w.getWeaponPreferences());
            while(weapons.hasNext()){
                builder.append("\n\tWeaponPreference = ").append(weapons.next());
            }
            builder.append("\nEnd\n\n");
        }
        for (Bot b:botProfile.getBots()){
            builder.append(b.getAttribute().getName());
            if(b.hasWeaponScheme()){
                builder.append("+").append(b.getWeaponScheme().getName());
            }
            builder.append(" ").append(b.getName()).append("\nEnd\n\n");
        }
        return builder;
    }
}
