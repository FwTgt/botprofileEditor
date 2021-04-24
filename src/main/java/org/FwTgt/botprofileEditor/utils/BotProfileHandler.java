package org.FwTgt.botprofileEditor.utils;

import javafx.beans.property.Property;
import org.FwTgt.botprofileEditor.domain.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

public class BotProfileHandler {

    private static String fit(String input){
        int noteIndex = input.indexOf('/');
        if(noteIndex!=-1){
            return input.substring(0,noteIndex).trim();
        }
        return input.trim();
    }

    public static BotProfile getData(InputStream profileStream) throws Exception {

        BotProfile botProfile = new BotProfile();
        Scanner scanner=new Scanner(profileStream);

        //读取文件中的有用信息到dataBuffer
        String cur;                         //用来接受scanner的返回值
        boolean isAttribute;         //判断是属性还是武器优先级
        while(scanner.hasNextLine()){

            cur=fit(scanner.nextLine());  //读取并去除首位的空格

            //去注释
            if(cur.equals("")){continue;}
            //跳过default的定义
            if(cur.startsWith("Default")){
                while(scanner.hasNextLine()){
                    cur = fit(scanner.nextLine());
                    if(cur.equals("End")){
                       break;
                    }
                }
            }
            //模板定义的读取
            else if(cur.startsWith("Template ")){
                isAttribute = true; //标识属性还是优先级
                Template template = new Template(cur.substring(9)); //创建模板,9~末尾为name属性
                //读取Template定义的内容
                while(scanner.hasNextLine()){
                    cur = fit(scanner.nextLine()).replace('=',' ').toLowerCase();
                    if(cur.equals("")){
                        continue;
                    }
                    if(cur.equals("end")){
                        break;
                    }
                    Scanner reader = new Scanner(cur);      //用来读取每一条属性
                    //System.out.println(cur);
                    String attributeName = reader.next();
                    //根据属性名称判断template类型
                    if(attributeName.equals("weaponpreference")||attributeName.equals("difficulty")){
                        String value=reader.next();
                        if(!value.equals("none")){
                            template.setAttribute(attributeName,value);
                            if(attributeName.equals("weaponpreference")){
                                isAttribute=false;
                            }
                        }
                    }
                    else{
                        template.setAttribute(attributeName,reader.nextFloat());
                    }
                }
                //根据isAttribute选择插入属性集合还是武器选择集合
                if(isAttribute){
                    botProfile.insertAttribute(template.toBotAttribute());
                }
                else{
                    botProfile.insertWeaponScheme(template.toBotWeaponScheme());
                }
            }
            //bot定义的读取
            else {
                //System.out.println(cur);
                Bot bot = new Bot();
                cur = cur.replace('+',' ');
                Scanner reader = new Scanner(cur);
                String attributeName = reader.next();
                String weaponSchemeName = reader.next();
                String botName;
                //官方有的bot定义缺省武器模板
                if(reader.hasNext()){
                    botName= reader.next();
                }
                else{
                    botName = weaponSchemeName;
                }
                bot.setName(botName);
                //筛掉没有被定义过的属性和武器模板
                bot.setBotAttribute(botProfile.getAttributeByName(attributeName));
                bot.setBotWeaponScheme(botProfile.getWeaponSchemeByName(weaponSchemeName));
                //如果bot的属性被定义过，则加入bot
                if(bot.getBotAttribute()!=null){
                    botProfile.insertBot(bot);
                }
                while(!cur.startsWith("End")){
                    cur = scanner.nextLine().trim();
                }
            }
        }
        return botProfile;
    }


    public static String outputFile(byte[] defaultINF, BotProfile botProfile) throws IOException {
        ClassPathResource pathData=new ClassPathResource("dataPath.properties");
        Scanner scanner = new Scanner(pathData.getInputStream());
        File file = new File(scanner.nextLine()+"/botprofile",String.valueOf(botProfile.getId())+".db");

        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if(!file.exists()){
            try {
                //生成文件
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileOutputStream out = new FileOutputStream(file,true);
        out.write(defaultINF);
        StringBuilder cur=new StringBuilder("\n\n\n");
        for(BotAttribute a:botProfile.getAttributes()){
            cur.append("Template "+a.getName());
            cur.append("\n\tSkill = "+String.valueOf(a.getSkill()));
            cur.append("\n\tAggression = "+String.valueOf(a.getAggression()));
            cur.append("\n\tReactionTime = "+String.valueOf(a.getReactionTime()));
            cur.append("\n\tAttackDelay = "+String.valueOf(a.getAttackDelay()));
            cur.append("\n\tDifficulty = "+String.valueOf(a.getDifficulty().name()));
            cur.append("\n\tAimFocusInitial = "+String.valueOf(a.getAimFocusInitial()));
            cur.append("\n\tAimFocusDecay = "+String.valueOf(a.getAimFocusDecay()));
            cur.append("\n\tAimFocusOffsetScale = "+String.valueOf(a.getAimFocusOffsetScale()));
            cur.append("\n\tAimfocusInterval = "+String.valueOf(a.getAimfocusInterval()));
            cur.append("\n\tLookAngleMaxAccelNormal = "+String.valueOf(a.getLookAngleMaxAccelNormal()));
            cur.append("\n\tLookAngleStiffnessNormal = "+String.valueOf(a.getLookAngleStiffnessNormal()));
            cur.append("\n\tLookAngleDampingNormal = "+String.valueOf(a.getLookAngleDampingNormal()));
            cur.append("\n\tLookAngleMaxAccelAttacking = "+String.valueOf(a.getLookAngleMaxAccelAttacking()));
            cur.append("\n\tLookAngleStiffnessAttacking = "+String.valueOf(a.getLookAngleStiffnessAttacking()));
            cur.append("\n\tLookAngleDampingAttacking = "+String.valueOf(a.getLookAngleDampingAttacking()));
            cur.append("\nEnd\n\n");
            out.write(cur.toString().getBytes(StandardCharsets.UTF_8));
            cur=new StringBuilder();
        }

        Set<BotWeaponScheme>weaponSchemes = botProfile.getWeaponSchemes();

        for(BotWeaponScheme w:botProfile.getWeaponSchemes()){
            cur.append("Template "+w.getName());
            Scanner weapons = new Scanner(w.getWeaponPreferencesStr());
            while(weapons.hasNext()){
                cur.append("\n\tWeaponPreference = "+weapons.next());
            }
            cur.append("\nEnd\n\n");
            out.write(cur.toString().getBytes(StandardCharsets.UTF_8));
            cur=new StringBuilder();
        }
        for (Bot b:botProfile.getBots()){
            cur.append(b.getBotAttribute().getName());
            if(b.getBotWeaponScheme()!=null){
                cur.append("+"+b.getBotWeaponScheme().getName());
            }
            cur.append(" "+b.getName()+"\nEnd\n\n");
            out.write(cur.toString().getBytes(StandardCharsets.UTF_8));
            cur = new StringBuilder();
        }
        out.close();
        return file.getAbsolutePath();
    }
}
