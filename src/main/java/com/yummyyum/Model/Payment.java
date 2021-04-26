package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity(name = "payment")
@Getter
@Setter
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "payment_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date paymentDate;

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

    public Payment() {
    }

    public Payment(Date paymentDate, String nameOnCard, String cardNumber,
                   String expirationDateMonth, String expirationDateYear,
                   String securityCode) {
        this.paymentDate = paymentDate;
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.expirationDateMonth = expirationDateMonth;
        this.expirationDateYear = expirationDateYear;
        this.securityCode = securityCode;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentDate=" + paymentDate +
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

        Payment payment = (Payment) o;

        return id != null ? id.equals(payment.id) : payment.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

