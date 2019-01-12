/**
 * 
 */
package shmulik.coupons_manager.final_project.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//import org.springframework.data.annotation.Id;

/**
 * @author Android
 *
 */
@Entity
@Table(name = "coupons")
public class Coupon {

//	TYPE � ENUM (STRING) ( category - food,electrecity, vication , fun ) ----------------------

	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
  	@Column(name = "title" , unique=true)
	private String title;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "image_link")
	private String imageLink;

	@Column(name="couponCategory", nullable=false)
	private CouponCategory couponCategory;

	@ManyToMany(mappedBy = "coupons")
	private Set<Customer> customers = new HashSet<>();




//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")
//	private Company company;


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

	public CouponCategory getCouponCategory() {
		return couponCategory;
	}

	public void setCouponCategory(CouponCategory couponCategory) {
		this.couponCategory = couponCategory;
	}
//	public Company getCompany() {
//		return company;
//	}

	//	public Set<Customer> getCustomers() {
//		return customers;
//	}

	@Override
	public String toString() {
		return "Coupon{" +
				"id=" + id +
				", title='" + title + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", amount=" + amount +
				", message='" + message + '\'' +
				", price=" + price +
				", imageLink='" + imageLink + '\'' +
				", couponCategory=" + couponCategory +
				'}';
	}
}
