// B"H
package shmulik.coupons_manager.final_project.controllers.rolls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.messages.Exeptions.CustomerAlreadyExistException;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Customer;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.AdminFacade;

import java.util.List;

@RestController
@RequestMapping("/rest/api/admin")
public class AdminController {

    @Autowired
    private AdminFacade adminFacade;

    @PostMapping("/createcompany")
    public Company createCompany(@RequestBody Company company) {
        if(company.getId() == 0)
            return adminFacade.createNewCompany(company);
        return null;
    }

    @PostMapping("/updatecompanyemail")
    public Company updateCompanyEmail(@RequestBody Company company) {
        return adminFacade.updateCompanyEmail(company.getId(), company.getEmail());
    }

    @PostMapping("/updatecompanypassword")
    public Company updateCompanyPassword(@RequestBody Company company) {
        return adminFacade.updateCompanyPassword(company.getId(), company.getPassword());
    }

    @GetMapping("/getAllCompanies")
    public List<Company> getAllCompanies() {
        return adminFacade.getAllCompanies();
    }

    @GetMapping("/getCompanyById/{id}")
    public Company getCompanyByid(@PathVariable("id") int id){
        return adminFacade.getCompanyByid(id);
    }

    @PostMapping("/addNewCustomer")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        if(customer.getId() == 0)
            try {
                return adminFacade.addNewCustomer(customer);
            }catch (DataIntegrityViolationException e){
                String property = e.getMostSpecificCause().getMessage().split("'")[1];
                property = property.contains("@") ? "Customer with this email " + property + " already exist." : "Customer with the name " + property + " already exist.";
                throw new CustomerAlreadyExistException(property);
            }
        return null;
    }

    @GetMapping("/getCustomerByid/{id}")
    public Customer getCustomerByid(@PathVariable("id") int id){
        return adminFacade.getCustomerByid(id);
    }

    @PostMapping("/updatecustomeremail")
    public Customer updateCustomerEmail(@RequestBody Customer customer) {
        return adminFacade.updateCustomerEmail(customer.getId(), customer.getEmail());
    }

    @PostMapping("/updatecustomerpassword")
    public Customer updateCustomerPassword(@RequestBody Customer customer) {
        return adminFacade.updateCustomerPassword(customer.getId(), customer.getPassword());
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return adminFacade.getAllCustomers();
    }

    @DeleteMapping("/deleteCustomerById/{id}")
    public boolean deleteCustomerById(@PathVariable("id") int id) {
        return adminFacade.deleteCustomerById(id);
    }

    @DeleteMapping("/deleteCompanyById/{id}")
    public boolean deleteCompanyById(@PathVariable("id") int id) {
        return adminFacade.deleteCompanyById(id);
    }


}
