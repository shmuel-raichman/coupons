// B"H
package shmulik.coupons_manager.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Customer;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;
import shmulik.coupons_manager.final_project.services.interfaces.CustomerService;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.AdminFacade;

@RestController
@CrossOrigin
@RequestMapping("/rest/api/test")
public class TestController {

    @Autowired
    private AdminFacade adminFacade;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CompanyService companyService;

//    @Autowired
//    ScheduledTasks scheduledTasks;

//    @PostMapping("/createcompany")
//    public Company createCompany(@RequestBody Company company) {
//        if(company.getId() == 0)
//            return adminFacade.createNewCompany(company);
//        return null;
//    }
//
//    @PostMapping("/updatecompanyemail")
//    public Company updateCompanyEmail(@RequestBody Company company) {
//        return adminFacade.updateCompanyEmail(company.getId(), company.getEmail());
//    }
//
//    @PostMapping("/updatecompanypassword")
//    public Company updateCompanyPassword(@RequestBody Company company) {
//        return adminFacade.updateCompanyPassword(company.getId(), company.getPassword());
//    }
//
//    @GetMapping("/getAllCompanies")
//    public List<Company> getAllCompanies() {
//        return adminFacade.getAllCompanies();
//    }
//
//    @GetMapping("/getCompanyById/{id}")
//    public Company getCompanyByid(@PathVariable("id") int id){
//        return adminFacade.getCompanyByid(id);
//    }
//
//    @PostMapping("/addNewCustomer")
//    public Customer addNewCustomer(@RequestBody Customer customer) {
//        if(customer.getId() == 0)
//            try {
//                return adminFacade.addNewCustomer(customer);
//            }catch (DataIntegrityViolationException e){
//                String property = e.getMostSpecificCause().getMessage().split("'")[1];
//                property = property.contains("@") ? "Customer with this email " + property + " already exist." : "Customer with the name " + property + " already exist.";
//                throw new CustomerAlreadyExistException(property);
//            }
////        MySQLIntegrityConstraintViolationException
//        return null;
//    }
//
//    @GetMapping("/getCustomerByid/{id}")
//    public Customer getCustomerByid(@PathVariable("id") int id){
//        return adminFacade.getCustomerByid(id);
//    }
//
//    @PostMapping("/updatecustomeremail")
//    public Customer updateCustomerEmail(@RequestBody Customer customer) {
//        return adminFacade.updateCustomerEmail(customer.getId(), customer.getEmail());
//    }
//
//    @PostMapping("/updatecustomerpassword")
//    public Customer updateCustomerPassword(@RequestBody Customer customer) {
//        return adminFacade.updateCustomerPassword(customer.getId(), customer.getPassword());
//    }
//
//    @GetMapping("/getAllCustomers")
//    public List<Customer> getAllCustomers() {
//        return adminFacade.getAllCustomers();
//    }
//
//    @DeleteMapping("/deleteCustomerById/{id}")
//    public boolean deleteCustomerById(@PathVariable("id") int id) {
//        return adminFacade.deleteCustomerById(id);
//    }
//
//    @DeleteMapping("/deleteCompanyById/{id}")
//    public boolean deleteCompanyById(@PathVariable("id") int id) {
//        return adminFacade.deleteCompanyById(id);
//    }

//    @PostMapping("/addCouponToCustomer")
//    public Coupon addCouponToCustomer(@RequestParam("couponID") long couponID, @RequestParam("customerID") long customerID) {
//        //long couponID = (long)body.get("couponID");
//        //long customerID = (long)body.get("customerID");
//        return adminFacade.addCouponToCustomer(couponID,customerID);
//
//    }

    @GetMapping("/loginAsCustomer/{email}/{password}")
    public boolean getCustomerByEmail(@PathVariable("email") String email, @PathVariable("password") String password){
        return customerService.login(email, password);
    }

    @GetMapping("/getCustomerByEmail/{email}")
    public Customer getCustomerByEmail(@PathVariable("email") String email){
        return customerService.findByEmail(email);
    }

    @GetMapping("/loginAsCompany/{email}/{password}")
    public boolean loginAsCompany(@PathVariable("email") String email, @PathVariable("password") String password){
        return companyService.login(email, password);
    }

    @GetMapping("/getCompanyByEmail/{email}")
    public Company getCompanyByEmail(@PathVariable("email") String email){

        return companyService.findByEmail(email);
    }



}
