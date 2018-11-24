/**
 * 
 */
package shmulik.coupons_manager.final_project.entities;

import javax.persistence.*;

/**
 * @author Android
 *
 */
@Entity
@Table(name = "coupons" )
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "comp_name" , unique=true)
    private String comp_name;

    @Column(name = "password")
    private String password;

    @Column(name = "email" , unique=true)
    private String email;

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
