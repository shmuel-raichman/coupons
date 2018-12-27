// B"H
package shmulik.coupons_manager.final_project.controllers.rolls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.AdminFacade;

import java.util.List;

@RestController
@RequestMapping("/rest/api/admin")
public class AdminController {

    @Autowired
    private AdminFacade adminFacade;

    @PostMapping("/createcompany")
    public Company createCompany(@RequestBody Company company) {
        return adminFacade.createNewCompany(company);
    }

    @PostMapping("/updatecompanyemail")
    public Company updateCompany(@RequestBody Company company) {
        return adminFacade.updateCompanyEmail(company.getId(), company.getEmail());
    }

    @PostMapping("/updatecompanypassword")
    public Company updateCompanyPassword(@RequestBody Company company) {
        return adminFacade.updateCompanyPassword(company.getId(), company.getPassword());
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return adminFacade.getAllCompanies();
    }

    @GetMapping("/getCompanyById/{id}")
    public Company getCompanyByid(@PathVariable("id") int id){
        return adminFacade.getCompanyByid(id);
    }
}
