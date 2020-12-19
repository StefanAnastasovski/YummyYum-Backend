package com.yummyyum.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name="subscribe_email")
@Getter
@Setter
@AllArgsConstructor
public class SubscribeEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="subscribe_date")
    private Timestamp subscribeDate;

    public SubscribeEmail() {
    }

    public SubscribeEmail(String email, Timestamp subscribeDate) {
        this.email = email;
        this.subscribeDate = subscribeDate;
    }

    @Override
    public String toString() {
        return "SubscribeEmail{" +
                "email='" + email + '\'' +
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
