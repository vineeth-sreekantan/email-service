package com.mail.controller;

import com.mail.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.MessagingException;

/**
 * Main Controller
 *
 * @author Vineeth S
 * @since 15-03-2024
 */
@RestController
@RequestMapping("/main")
public class EmailController {

    @Autowired
    private MainService mainService;

    @GetMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(){
        String status = mainService.sendEmail();
        return ResponseEntity.ok()
                .body(status);
    }

    @GetMapping("/sendEmailWithAttachment")
    public ResponseEntity<String> sendEmailWithAttachment() throws MessagingException {
        String status = mainService.sendEmailWithAttachment();
        return ResponseEntity.ok()
                .body(status);
    }


}
