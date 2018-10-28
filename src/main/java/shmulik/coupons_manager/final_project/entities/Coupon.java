/**
 * 
 */
package shmulik.coupons_manager.final_project.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

/**
 * @author Android
 *
 */
@Entity
@Table(name = "coupons")
public class Coupon {
	
//	ID – LONG, PK
//	TITLE - STRING ( short description )
//	START_DATE – DATE (creation date in the system )
//	END_DATE – DATE (Expiration date )
//	AMOUNT – INTEGER (amount of coupons in stock)
//	TYPE – ENUM (STRING) ( category - food,electrecity, vication , fun ) ----------------------
//	MESSAGE – STRING (coupon describe text )
//	PRICE – DOUBLE (coupon price )
//	IMAGE – STRING (link)
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	// TO DO add annotations to make it auto generate table.
	//private long id;
	private String title;
	private Date startDate;
	private Date endDate;
	private int amount;
	private String message;
	private double price;
	private String imageLink;
}
