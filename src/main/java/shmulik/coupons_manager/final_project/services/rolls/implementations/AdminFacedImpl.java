// B"H
package shmulik.coupons_manager.final_project.services.rolls.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Customer;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;
import shmulik.coupons_manager.final_project.services.interfaces.CustomerService;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.AdminFacade;

import java.util.List;

@Service
public class AdminFacedImpl implements AdminFacade {

//    @Autowired
//    private CouponRepo couponRepo;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CustomerService customerService;

    public Company createNewCompany(Company company) {
        return companyService.createCompany(company);
    }

//    public Company updateCompany(Company company) {
//        return companyService.updateCompany(company);
//    }

    public Company updateCompanyEmail(long companyId, String email) {
        Company company = companyService.findById(companyId);
        company.setEmail(email);
        return companyService.updateCompany(company);
    }

    public Company updateCompanyPassword(long companyId, String password) {
        Company company = companyService.findById(companyId);
        company.setPassword(password);
        return companyService.updateCompany(company);
    }

    public List<Company> getAllCompanies () {
        return companyService.findAll();
    }

    //@Override
    public Company getCompanyByid(int id) {
        return companyService.findById(id);
    }

    public Customer addNewCustomer(Customer customer) {
        return customerService.createCustomer(customer);
    }

    public Customer getCustomerByid(int id) {
        return customerService.findById(id);
    }

    public Customer updateCustomerEmail(long customerId, String email) {
        Customer customer = customerService.findById(customerId);
        customer.setEmail(email);
        return customerService.updateCustomer(customer);
    }

    public Customer updateCustomerPassword(long customerId, String password) {
        Customer customer = customerService.findById(customerId);
        customer.setPassword(password);
        return customerService.updateCustomer(customer);
    }

    public List<Customer> getAllCustomers () {
        return customerService.findAll();
    }

    public boolean deleteCustomerById(int id) {
        return customerService.deleteCustomerById(id);
    }

//    public Coupon addCouponToCustomer(long couponId, long customerId){
//        return customerService.addCouponToCustomer(couponId, customerId);
//    }
}