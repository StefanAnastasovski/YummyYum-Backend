package com.yummyyum.Services.ForgotPasswordCode.Impl;


import com.yummyyum.Services.SendEmailService.SendEmailService;
import com.yummyyum.Model.ForgotPasswordCode;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.ForgotPasswordCodeRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.ForgotPasswordCode.ForgotPasswordCodeService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class ForgotPasswordCodeServiceImpl implements ForgotPasswordCodeService {

    private final ForgotPasswordCodeRepository forgotPasswordCodeRepository;
    private final UserRepository userRepository;
    private final SendEmailService sendEmailService;

    public ForgotPasswordCodeServiceImpl(ForgotPasswordCodeRepository forgotPasswordCodeRepository,
                                         UserRepository userRepository, SendEmailService sendEmailService) {
        this.forgotPasswordCodeRepository = forgotPasswordCodeRepository;
        this.userRepository = userRepository;
        this.sendEmailService = sendEmailService;
    }

    @Override
    public List<ForgotPasswordCode> getAllCodes() {
        return forgotPasswordCodeRepository.findAll();
    }

    @Override
    public Optional<ForgotPasswordCode> getCodeByEmail(String email) {
        return forgotPasswordCodeRepository.getForgotPasswordCodeByEmail(email);
    }

    @Override
    public ForgotPasswordCode createNewForgotPasswordCode(String email, Timestamp codeSentDate, Boolean isExist) throws Exception {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        String code = String.format("%06d", number);

        ForgotPasswordCode forgotPasswordCode = new ForgotPasswordCode(email, code, codeSentDate);
        ForgotPasswordCode result;

        Optional<User> user = userRepository.findUserByEmail(email);

        if (!isExist) {
            result = forgotPasswordCodeRepository.save(forgotPasswordCode);
        } else {
            Optional<ForgotPasswordCode> forgotPasswordCode1 =
                    forgotPasswordCodeRepository.getForgotPasswordCodeByEmail(email);
            forgotPasswordCode.setId(forgotPasswordCode1.get().getId());
            result = forgotPasswordCodeRepository.saveAndFlush(forgotPasswordCode);
        }

        String fullName = user.get().getFirstName() + " " + user.get().getLastName();
        sendEmailService.sendMimeMail(email, fullName, code);

        return result;


    }

}
