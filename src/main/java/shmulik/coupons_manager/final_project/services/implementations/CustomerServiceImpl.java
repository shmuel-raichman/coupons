package shmulik.coupons_manager.final_project.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.messages.Exeptions.CouponAlreadytExsitForCustomerException;
import shmulik.coupons_manager.final_project.messages.Exeptions.CustomerNotFoundException;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.entities.Customer;
import shmulik.coupons_manager.final_project.repositories.CouponRepo;
import shmulik.coupons_manager.final_project.repositories.CustomerRepo;
import shmulik.coupons_manager.final_project.services.interfaces.CouponService;
import shmulik.coupons_manager.final_project.services.interfaces.CustomerService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CouponRepo couponRepo;

    @Autowired
    private  CustomerService customerService;

    @Autowired
    private CouponService couponService;

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }


    @Override
    public Customer findById(long id) {
        Optional<Customer> optinal = customerRepo.findById(id);
        return optinal.orElse(null);
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
//        if(customer.getId() == 0) {
            customerRepo.save(customer);
            return customer;
//        }
//        else {
//            return new Customer("customer already exist: can't update using this method try updateCoupon.");
//        }
    }

    @Override
    @Transactional
    public Customer updateCustomer(Customer customer) {
//        if(customerService.findById(customer.getId()) == null) {
//            Customer error = new Customer("customer not exist exist : can't create coupon using this method try createCustomer.");
//            //error.setAmount((Integer)null);
//            return error;
//
//        }
//        else if(customer.getId() == 0){
//            Customer error = new Customer("no id to update: can't update unknown customer please supply ID.");
//            //error.setAmount((Integer)null);
//            return error;
//        } else {
            customerRepo.save(customer);
            return customer;
//        }
    }

    @Override
    public Coupon addCouponToCustomer(long couponId, long customerId){
        Customer customer = findById(customerId);
        Coupon coupon = couponService.findById(couponId);

        if(!customer.getCoupons().contains(coupon)){
            customer.getCoupons().add(coupon);
            coupon.setAmount(coupon.getAmount()-1);
            customerRepo.save(customer);
            couponRepo.save(coupon);
        } else {
            throw new CouponAlreadytExsitForCustomerException("Coupon already exist for this customer.");
        }
        return coupon;
    }

    @Override
    @Transactional
    public boolean deleteCustomerById(long id) {
        if(customerRepo.findById(id) == null) {
            return false;
        }
        else {
            customerRepo.deleteById(id);
            return true;
        }
    }

    @Override
    public Customer findByEmail(String email) {

            Optional<Customer> optinal = Optional.ofNullable(customerRepo.findByEmail(email));
        if(!optinal.isPresent())
            throw new CustomerNotFoundException("Customer with the email address '" + email + "'  not found. ");
            return optinal.orElse(null);

    }

    @Override
    public boolean login(String customerEmail, String customerPassword){
        try {
            return findByEmail(customerEmail).getPassword().equals(customerPassword);
        } catch (NullPointerException e) {
            throw new CustomerNotFoundException("Customer with the email address '" + customerEmail + "'  not found. ");
        }
    }
}
