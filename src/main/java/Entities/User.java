package Entities;



import Entities.ValidAnnotations.Email;
import Entities.ValidAnnotations.Phone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotNull
    @Column(name = "age")
    int age;
    @NotNull
    @Column(name = "firstName")
    String firstName;
    @NotNull
    @Column(name = "lastName")
    String lastName;
    @NotNull
    @Email
    @Column(name = "email")
     String email;

    @Phone
    @Column(name = "phone")
    String phone;

    transient String password;

    @OneToMany(mappedBy = "user", cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<CreditCard> creditCards = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "creditcard",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "bankId"))
    private Set<Bank> banks = new HashSet<>();




    //Getters/Setters for Relations

    public void setCreditCard(CreditCard creditCard){
        creditCards.add(creditCard);
    }

    public Set<CreditCard> getCreditCards(){
        return creditCards;
    }

    public void setBanks(Bank bank){
        banks.add(bank);
    }

    public Set<Bank> getBanks(){
        return banks;
    }


    //Getters/Setters for Entities


    public void setId(Long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
