package org.FwTgt.botprofileEditor.controller;

import org.FwTgt.botprofileEditor.service.BotProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/botProfile")
public class BotProfileController {
    @Autowired
    private BotProfileService botProfileService;

    @Autowired
    private byte[] defaultINF;

    @PostMapping("/readFile")
    public String readFile(MultipartFile file){
        try{
            botProfileService.loadProfile(file.getOriginalFilename(),file.getInputStream());
            return "{\"code\":\"0\",\"msg\":\"文件上传成功\"}";
        }catch (Exception e){
            return "{\"code\":\"-1\",\"msg\":\"文件上传失败\"}";
        }
    }

    @GetMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request) throws Exception {
        byte[] body;
        HttpHeaders headers=new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        String resourcePath = botProfileService.outputProfile(1);
        File file = new File(resourcePath);
        InputStream stream = new FileInputStream(file);
        body = new byte[stream.available()];

        stream.read(body);
        stream.close();

        file.delete();

        headers.add("Content-Disposition", "attchement;filename=" + "botprofile.db");

        return new ResponseEntity<byte[]>(body,headers,status);
    }
}
