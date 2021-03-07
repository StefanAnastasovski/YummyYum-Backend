package com.yummyyum.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "forgot_password_code")
@Getter
@Setter
public class ForgotPasswordCode {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;

    @Column
    private String code;

    @Column(name = "code_sent_date")
    private Timestamp codeSentDate;

    public ForgotPasswordCode() {
    }

    public ForgotPasswordCode(String email, String code, Timestamp codeSentDate) {
        this.email = email;
        this.code = code;
        this.codeSentDate = codeSentDate;
    }
}
