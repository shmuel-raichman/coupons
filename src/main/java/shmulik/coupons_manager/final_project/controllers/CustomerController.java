// B"H
package shmulik.coupons_manager.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.entities.Customer;
import shmulik.coupons_manager.final_project.services.interfaces.CustomerService;

import java.util.List;


@RestController
@RequestMapping("/rest/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public List<Customer> findAllItems() {
        return customerService.findAll();
    }

    @GetMapping("{id}")
    public Customer findItemById(@PathVariable("id") int id){
        return customerService.findById(id);
    }

    @PostMapping("/createcustomer")
    public Customer createCoupon(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);

    }

    @PostMapping("/updatecustomer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("{id}")
    public boolean deleteCouponById(@PathVariable("id") int id) {
        return customerService.deleteCustomerById(id);
    }

}
