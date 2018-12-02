package shmulik.coupons_manager.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.entities.Customer;
import shmulik.coupons_manager.final_project.repositories.CustomerRepo;
import shmulik.coupons_manager.final_project.services.interfaces.CouponService;
import shmulik.coupons_manager.final_project.services.interfaces.CustomerService;

@RestController
@RequestMapping("/rest/api/test")
public class Login {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CouponService couponService;

    @GetMapping("{id}")
    public void addCouponToCustomer(@PathVariable("id") long id){
        long couponId = 1;

//        Coupon coupon = new Coupon();
//        Customer customer = customerService.findById(id);
//        customer.getCoupons().add(couponService.findById(couponId));
//        customerRepo.save(customer);
//        return false;
        //return couponService.findById(id).getCustomers().add(customerService.findById(couponId));

        // =======================================

        // Create a Post
        Customer customer1= new Customer("hvjkfkj");

        // Create two tags
        Coupon tag1 = new Coupon("Spring Boot");
        //Coupon tag2 = new Coupon("Hibernate");


        // Add tag references in the post
        customer1.getCoupons().add(tag1);
        //customer1.getCoupons().add(tag2);

        // Add post reference in the tags
        //tag1.getCustomers().add(customer1);
        //tag2.getCustomers().add(customer1);

        customerRepo.save(customer1);

        // =======================================
    }

}
