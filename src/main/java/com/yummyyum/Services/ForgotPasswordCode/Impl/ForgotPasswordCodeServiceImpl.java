package com.yummyyum.Services.ForgotPasswordCode.Impl;


import com.yummyyum.Model.ForgotPasswordCode;
import com.yummyyum.Repositories.ForgotPasswordCodeRepository;
import com.yummyyum.Services.ForgotPasswordCode.ForgotPasswordCodeService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class ForgotPasswordCodeServiceImpl implements ForgotPasswordCodeService {

    private final ForgotPasswordCodeRepository forgotPasswordCodeRepository;

    public ForgotPasswordCodeServiceImpl(ForgotPasswordCodeRepository forgotPasswordCodeRepository) {
        this.forgotPasswordCodeRepository = forgotPasswordCodeRepository;
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
    public ForgotPasswordCode createNewForgotPasswordCode(String email, Timestamp codeSentDate, Boolean isExist) {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        String num = String.format("%06d", number);
        ForgotPasswordCode forgotPasswordCode = new ForgotPasswordCode(email, num, codeSentDate);

        if (!isExist) {
            return forgotPasswordCodeRepository.save(forgotPasswordCode);
        } else {
            Optional<ForgotPasswordCode> forgotPasswordCode1 =
                    forgotPasswordCodeRepository.getForgotPasswordCodeByEmail(email);
            forgotPasswordCode.setId(forgotPasswordCode1.get().getId());
            return forgotPasswordCodeRepository.saveAndFlush(forgotPasswordCode);
        }


    }

}
