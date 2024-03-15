package com.mail.service;

import javax.mail.MessagingException;

/**
 * Mail Service Interface
 *
 * @author Vineeth S
 * @since 15-03-2024
 */
public interface MainService {
    public String sendEmail();

    String sendEmailWithAttachment() throws MessagingException;
}
