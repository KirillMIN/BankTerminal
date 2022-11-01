package Entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String bankName;

    @OneToMany(mappedBy = "bank", cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<CreditCard> creditCards = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "creditcard",
            joinColumns = @JoinColumn(name = "bankId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users = new HashSet<User>();

    //Getters/Setters for Relations

    public void setCreditCards(CreditCard creditCard){
        creditCards.add(creditCard);
    }

    public Set<CreditCard> getCreditCards(){
        return  creditCards;
    }

    public void  setUser(User user){
        users.add(user);
    }

    public Set<User> getUsers(){
        return users;
    }



    //Getters/Setters for Entity

    public void setId(Long id) {
        this.id = id;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }
}
