package org.FwTgt.botprofileEditor.utils;

import org.FwTgt.botprofileEditor.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ContextWrapper {
    private static ApplicationContext context;
    @Autowired
    public ContextWrapper(ApplicationContext ac){
        context = ac;
    }
    public static ApplicationContext getContext(){
        return context;
    }

}
