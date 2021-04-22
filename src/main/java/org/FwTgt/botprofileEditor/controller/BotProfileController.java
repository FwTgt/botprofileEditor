package org.FwTgt.botprofileEditor.controller;

import org.FwTgt.botprofileEditor.service.BotProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class BotProfileController {
    @Autowired
    private BotProfileService botProfileService;

    @GetMapping("/readFromFile")
    public void readFromFile(){

    }
}
