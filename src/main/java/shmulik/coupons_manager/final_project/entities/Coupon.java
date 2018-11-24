/**
 * 
 */
package shmulik.coupons_manager.final_project.entities;

import javax.persistence.*;
import java.util.Date;

//import org.springframework.data.annotation.Id;

/**
 * @author Android
 *
 */
@Entity
@Table(name = "coupons" ,uniqueConstraints={@UniqueConstraint(columnNames={"title"})})
public class Coupon {

//	TYPE � ENUM (STRING) ( category - food,electrecity, vication , fun ) ----------------------

	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	// TO DO add annotations to make it auto generate table.
	//private long id;
	@Column(name = "title" , unique=true)
	private String title;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "start_date", insertable=false, updatable=false)
	private Date endDate;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "price", precision = 2)
	private double price;
	
	@Column(name = "image_link")
	private String imageLink;
	
	
	
	public Coupon () {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	
}
