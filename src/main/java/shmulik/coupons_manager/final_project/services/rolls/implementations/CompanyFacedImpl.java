// B"H
package shmulik.coupons_manager.final_project.services.rolls.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.CompanyFacade;

@Service
public class CompanyFacedImpl implements CompanyFacade {

    @Autowired
    private CompanyService companyService;



}