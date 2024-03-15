package com.mail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.ParseException;
import java.util.List;

/**
 * Mail Service Util
 *
 * @author Vineeth S
 * @since 15-03-2024
 */
@Repository
public class MailServiceUtil {

    private final String FROM_EMAIL_ADDRESS = "<FROM_EMAIL_ADDRESS>";
    private final String TO_EMAIL_ADDRESS = "<TO_EMAIL_ADDRESS>";
    private final String EMAIL_SUBJECT = "Subject";
    private final String EMAIL_BODY = "Body";
    private final String EMAIL_BODY_HTML = "<html>Body</html>";
    private final String MAIL_UNSUCCESSFUL = "Exception while sending Email!";
    private final String MAIL_SUCCESSFUL = "Mail Sent Successfully!";
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    /**
     * To Send Email using SimpleMailMessage
     *
     * @return status
     */
    public String sendEmail() {
        String status = null;
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(TO_EMAIL_ADDRESS);
        simpleMailMessage.setSubject(EMAIL_SUBJECT);
        simpleMailMessage.setSubject(EMAIL_BODY);
        try{
            javaMailSender.send(simpleMailMessage);
            status = MAIL_SUCCESSFUL;
        } catch (Exception e){
            e.printStackTrace();
            return MAIL_UNSUCCESSFUL;
        }
        return status;
    }

    /**
     * To Send Email Using Mime Message
     * @return
     * @throws MessagingException
     */
    public String sendEmailWithAttachment() throws MessagingException {
        String status;
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(TO_EMAIL_ADDRESS);
            helper.setFrom(FROM_EMAIL_ADDRESS);
            helper.setSubject(EMAIL_SUBJECT);
            helper.setText(EMAIL_BODY_HTML, true);
            javaMailSender.send(mimeMessage);
            status = MAIL_SUCCESSFUL;
        } catch (Exception e){
            e.printStackTrace();
            return MAIL_UNSUCCESSFUL;
        }
        return status;
    }
}
