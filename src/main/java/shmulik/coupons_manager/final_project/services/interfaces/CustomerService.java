package shmulik.coupons_manager.final_project.services.interfaces;

import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    boolean deleteCustomerById(long id);

    Coupon addCouponToCustomer(long couponId, long customerId);

    Customer findByEmail(String email);

    boolean login(String customerEmail, String customerPassword);
}
