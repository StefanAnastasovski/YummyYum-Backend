package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="signup")
@Getter
@Setter
@AllArgsConstructor
public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String username;

    private String password;

    private String email;

    @Column(name="signup_date")
    private String signUpDate;

//    @JsonIgnore
//    @OneToOne(mappedBy = "signUp")
//    private Account account;

    public SignUp() {
    }

    public SignUp(String firstName, String lastName, String username,
                  String password, String email, String signUpDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.signUpDate = signUpDate;
    }

    @Override
    public String toString() {
        return "SignUp{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", signUpDate='" + signUpDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SignUp signUp = (SignUp) o;

        return id != null ? id.equals(signUp.id) : signUp.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

