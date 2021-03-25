package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity(name = "send_email")
@Getter
@Setter
@AllArgsConstructor
public class SendEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sent_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date sentDate;

    @Column(name = "subject")
    private String subject;

    @Column(name = "email_text")
    @Lob
    private String text;

    @Column(name = "recipient")
    @Lob
    private String recipient;

    public SendEmail() {
    }

    public SendEmail(Date sentDate, String subject, String text, String recipient) {
        this.sentDate = sentDate;
        this.subject = subject;
        this.text = text;
        this.recipient = recipient;
    }

}

