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
@Table(name = "coupons" ,uniqueConstraints={@UniqueConstraint(columnNames={"title"})})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // TO DO add annotations to make it auto generate table.
    @Column(name = "comp_name" , unique=true)
    private String title;

    @Column(name = "password")
    private String password;

    @Column(name = "email" , unique=true)
    private String email;
	
	
}
