package com.yummyyum.Model.History;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yummyyum.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "credit_card_history")
@Getter
@Setter
@AllArgsConstructor
public class CreditCardHistory {

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

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "inactive_date")
    private Date inactiveDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public CreditCardHistory() {
    }

    public CreditCardHistory(String nameOnCard, String cardNumber, String expirationDateMonth,
                             String expirationDateYear, Boolean isActive, Date inactiveDate) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.expirationDateMonth = expirationDateMonth;
        this.expirationDateYear = expirationDateYear;
        this.isActive = isActive;
        this.inactiveDate = inactiveDate;
    }

}
