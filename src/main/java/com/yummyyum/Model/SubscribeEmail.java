package com.yummyyum.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "subscribe_email")
@Getter
@Setter
@AllArgsConstructor
public class SubscribeEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subscribe_date")
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subscribeDate;

    @OneToOne
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Email email;

    public SubscribeEmail() {
    }

    public SubscribeEmail(Date subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    @Override
    public String toString() {
        return "SubscribeEmail{" +
                ", subscribeDate=" + subscribeDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscribeEmail subscribeEmail = (SubscribeEmail) o;

        return id != null ? id.equals(subscribeEmail.id) : subscribeEmail.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
