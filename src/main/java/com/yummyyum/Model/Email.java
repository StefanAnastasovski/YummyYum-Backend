package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "email")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email", "is_user"}))
@Getter
@Setter
@AllArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;

    @Column(name = "is_user")
    private Boolean isUser;

    @JsonIgnore
    @OneToOne(mappedBy = "email")
    private SubscribeEmail subscribeEmail;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "email")
    private Set<Login> logins;

    @JsonIgnore
    @OneToOne(mappedBy = "email")
    private User user;

    public Email() {
    }

    public Email(String email, Boolean isUser) {
        this.email = email;
        this.isUser = isUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        return id != null ? id.equals(email.id) : email.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

