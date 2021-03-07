package com.yummyyum.Services.SendEmailService;



import javax.mail.Session;

import javax.mail.*;

public interface SendEmailService {

    void sendMimeMail(String recipient, String fullName, String code) throws Exception;

    Message prepareMessage(Session session, String myAccountEmail, String recipient, String userName, String code);


}
