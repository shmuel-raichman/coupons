package shmulik.coupons_manager.final_project.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer" )
public class Customer {
    // strategy=GenerationType.IDENTITY
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    //TODO fix name not created.
    @Column(name = "custName" , unique=true)
    private String custName;

    @Column(name = "password")
    private String password;

    @Column(name = "email" , unique=true)
    private String email;

    // TODO change colmun names upper or lower case letters .
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CUSTOMER_COUPON",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COUPON_ID"))
    private Set<Coupon> coupons = new HashSet<>();


    private String error;


    public Customer() {
    }

    public Customer (String errorMsg) {
        this.error = errorMsg;
    }

    public String getError() {
        return error;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Coupon> getCoupons() {
        return coupons;
    }


}

