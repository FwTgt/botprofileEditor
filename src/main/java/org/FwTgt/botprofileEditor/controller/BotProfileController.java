package org.FwTgt.botprofileEditor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class BotProfileController {
    @Autowired
    private DataSource dataSource;
    @GetMapping("test")
    public String viewTest(){
        System.out.println(dataSource);
        return "this is a test";
    }
}
