// B"H
package shmulik.coupons_manager.final_project.controllers.rolls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.AdminFacade;

@RestController
@RequestMapping("/rest/api/admin")
public class AdminController {

    @Autowired
    private AdminFacade adminFacade;

    @PostMapping("/createcompany")
    public Company createCompany(@RequestBody Company company) {
        return adminFacade.createNewCompany(company);
    }
}
