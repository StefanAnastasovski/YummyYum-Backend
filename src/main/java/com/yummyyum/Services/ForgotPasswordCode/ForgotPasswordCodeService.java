package com.yummyyum.Services.ForgotPasswordCode;


import com.yummyyum.Model.ForgotPasswordCode;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ForgotPasswordCodeService {

    List<ForgotPasswordCode> getAllCodes();

    Optional<ForgotPasswordCode> getCodeByEmail(String email);

    ForgotPasswordCode createNewForgotPasswordCode(String email, Timestamp codeSentDate, Boolean isExist) throws Exception;


}
