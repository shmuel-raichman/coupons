package shmulik.coupons_manager.final_project.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.entities.Customer;
import shmulik.coupons_manager.final_project.repositories.CustomerRepo;
import shmulik.coupons_manager.final_project.services.interfaces.CustomerService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerService;

    @Override
    public List<Customer> findAll() {
        return customerService.findAll();
    }


    @Override
    public Customer findById(long id) {
        Optional<Customer> optinal = customerService.findById(id);
        return optinal.orElse(null);
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
//        if(customer.getId() == 0) {
            customerService.save(customer);
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
            customerService.save(customer);
            return customer;
//        }
    }


    @Override
    @Transactional
    public boolean deleteCustomerById(long id) {
        if(customerService.findById(id) == null) {
            return false;
        }
        else {
            customerService.deleteById(id);
            return true;
        }
    }
}
