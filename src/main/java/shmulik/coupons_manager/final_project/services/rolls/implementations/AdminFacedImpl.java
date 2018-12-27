// B"H
package shmulik.coupons_manager.final_project.services.rolls.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.AdminFacade;

@Service
public class AdminFacedImpl implements AdminFacade {

//    @Autowired
//    private CouponRepo couponRepo;

    @Autowired
    private CompanyService companyService;

    public Company createNewCompany(Company company) {
        return companyService.createCompany(company);
    }
}