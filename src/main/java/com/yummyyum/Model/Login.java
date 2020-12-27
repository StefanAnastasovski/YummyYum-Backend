package com.yummyyum.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "login")
@Getter
@Setter
@AllArgsConstructor
public class Login {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login_date")
    private Timestamp loginDate;

    @ManyToOne
    private Email email;

    public Login() {

    }

    public Login(Timestamp loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "Login{" +
                ", loginDate='" + loginDate + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login = (Login) o;

        return id != null ? id.equals(login.id) : login.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


}
