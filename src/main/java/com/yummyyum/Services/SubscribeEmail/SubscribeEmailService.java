package com.yummyyum.Services.SubscribeEmail;

import com.yummyyum.Model.Email;
import com.yummyyum.Model.SubscribeEmail;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface SubscribeEmailService {

    List<SubscribeEmail> getAllSubscribeEmails();

    Optional<SubscribeEmail> getSubscribeEmailByEmail(String email);

    SubscribeEmail createNewSubscribeEmail(Timestamp subscribeDate, Email email);

}
