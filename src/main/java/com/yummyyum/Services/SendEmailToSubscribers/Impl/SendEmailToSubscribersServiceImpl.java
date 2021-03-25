package com.yummyyum.Services.SendEmailToSubscribers.Impl;

import com.yummyyum.Model.DTO.SendEmailDTO;
import com.yummyyum.Model.SendEmail;
import com.yummyyum.Repositories.SendEmailRepository;
import com.yummyyum.Services.SendEmailService.SendEmailService;
import com.yummyyum.Services.SendEmailToSubscribers.SendEmailToSubscribersService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SendEmailToSubscribersServiceImpl implements SendEmailToSubscribersService {

    private final SendEmailRepository sendEmailRepository;
    private final SendEmailService sendEmailService;

    public SendEmailToSubscribersServiceImpl(SendEmailRepository sendEmailRepository, SendEmailService sendEmailService) {
        this.sendEmailRepository = sendEmailRepository;
        this.sendEmailService = sendEmailService;
    }

    @Override
    public List<SendEmail> getAllSendEmails() {
        return sendEmailRepository.findAll();
    }

    @Override
    public Optional<SendEmail> getSendEmailByEmail(String recipient) {
        return sendEmailRepository.getSendEmailByRecipient(recipient);
    }


    @Override
    public SendEmailDTO createNewSendEmail(String subject, String text, List<String> recipients) throws Exception {

        SendEmailDTO sendEmailDTO = new SendEmailDTO();
        Date date = new Date();
        if (recipients.size() != 0) {
            sendEmailDTO.setSentDate(date);
            sendEmailDTO.setSubject(subject);
            sendEmailDTO.setText(text);
            sendEmailDTO.setRecipients(recipients);
            for (String recipient : recipients) {
                SendEmail sendEmail = new SendEmail();
                sendEmail.setSentDate(date);
                sendEmail.setSubject(subject);
                sendEmail.setText(text);
                sendEmail.setRecipient(recipient);
                sendEmailRepository.save(sendEmail);
            }
            sendEmailService.sendMimeMailToSubscribers(subject, text, recipients);
        }

        return sendEmailDTO;
    }

}
