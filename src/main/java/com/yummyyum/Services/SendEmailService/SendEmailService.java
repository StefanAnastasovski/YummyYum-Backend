package com.yummyyum.Services.SendEmailService;


import javax.mail.Session;

import javax.mail.*;
import java.util.List;

public interface SendEmailService {

    void sendMimeMail(String recipient, String fullName, String code) throws Exception;

    void sendMimeMailToSubscribers(String subject, String text, List<String> recipients) throws Exception;

    Message prepareMessage(Session session, String myAccountEmail, String recipient, String userName, String code);

    Message prepareSubscribeMessage(Session session, String myAccountEmail, String subject,
                                    String text, List<String> recipients);


}
