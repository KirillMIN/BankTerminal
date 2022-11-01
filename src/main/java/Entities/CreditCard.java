package Entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "creditcard")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String firstName;
    String lastName;

    Date dates;
    int CVV;

    BigDecimal AmountMoney;

    @ManyToOne
    @JoinColumn(name = "Userid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "BankId")
    private Bank bank;

}
