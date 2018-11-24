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
@Table(name = "company" )
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
