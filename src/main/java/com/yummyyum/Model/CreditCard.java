package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "credit_card")
@Getter
@Setter
@AllArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_on_card")
    private String nameOnCard;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date_month")
    private String expirationDateMonth;

    @Column(name = "expiration_date_year")
    private String expirationDateYear;

    @Column(name = "security_code")
    private String securityCode;

    @Column
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public CreditCard() {
    }

    public CreditCard(String nameOnCard, String cardNumber,
                      String expirationDateMonth, String expirationDateYear,
                      String securityCode, Boolean isActive) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.expirationDateMonth = expirationDateMonth;
        this.expirationDateYear = expirationDateYear;
        this.securityCode = securityCode;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Payment{" +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDateMonth='" + expirationDateMonth + '\'' +
                ", expirationDateYear='" + expirationDateYear + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard creditCard = (CreditCard) o;

        return id != null ? id.equals(creditCard.id) : creditCard.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

