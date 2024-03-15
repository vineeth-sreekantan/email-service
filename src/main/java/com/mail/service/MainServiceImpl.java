package com.mail.service;

import com.mail.util.MailServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * Mail Service Interface Implementation
 *
 * @author Vineeth S
 * @since 15-03-2024
 */
@Service
public class MainServiceImpl implements MainService{

    @Autowired
    MailServiceUtil mailServiceUtil;

    @Override
    public String sendEmail() {
        String status = mailServiceUtil.sendEmail();
        return status;
    }

    @Override
    public String sendEmailWithAttachment() throws MessagingException {
        String status = mailServiceUtil.sendEmailWithAttachment();
        return status;
    }
}
