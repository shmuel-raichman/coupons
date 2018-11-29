package shmulik.coupons_manager.final_project.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer" )
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    //TODO fix name not created.
    @Column(name = "cust_name" , unique=true)
    private String comp_name;

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

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
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
}

