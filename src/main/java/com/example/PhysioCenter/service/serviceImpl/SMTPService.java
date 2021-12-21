package com.example.PhysioCenter.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SMTPService {
    @Autowired
    private JavaMailSender mailSender;
    private final String TEST_EMAIL_FROM = "";
    private final String TEST_EMAIL_TO = "";
    private final boolean SEND_MESSAGE = false;

    private void sendEmail(String subject, String HTMLtext) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setSubject(subject);
        helper.setFrom(TEST_EMAIL_FROM);
        helper.setTo(TEST_EMAIL_TO);
        helper.setText(HTMLtext, true);

        if (SEND_MESSAGE) {
            mailSender.send(message);
        }
    }

    public void sendEmailAboutCancelVisit(String date, String timeStart, String timeStop) throws MessagingException {
        String title = "Visit cancelled";
        String msg = "Your visit in " + date + " at " + timeStart + " to " + timeStop + "has been cancelled.";
        sendEmail(title, msg);
    }

    public void sendEmailAboutRegisterVisit(String date, String timeStart, String timeStop) throws MessagingException {
        String title = "Visit registered";
        String msg = "Your visit in " + date + " at " + timeStart + " to " + timeStop + "has been registered.";
        sendEmail(title, msg);
    }
}
