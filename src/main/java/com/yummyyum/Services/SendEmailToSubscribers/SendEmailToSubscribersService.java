package com.yummyyum.Services.SendEmailToSubscribers;

import com.yummyyum.Model.DTO.SendEmailDTO;
import com.yummyyum.Model.SendEmail;

import java.util.List;
import java.util.Optional;

public interface SendEmailToSubscribersService {

    List<SendEmail> getAllSendEmails();

    Optional<SendEmail> getSendEmailByEmail(String email);

    SendEmailDTO createNewSendEmail(String subject, String text, List<String> recipients) throws Exception;


}