package com.yummyyum.Model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SendEmailDTO {

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
    private List<String> recipients;

    public SendEmailDTO() {
    }

    public SendEmailDTO(Date sentDate, String subject, String text, List<String> recipients) {
        this.sentDate = sentDate;
        this.subject = subject;
        this.text = text;
        this.recipients = recipients;
    }

}
