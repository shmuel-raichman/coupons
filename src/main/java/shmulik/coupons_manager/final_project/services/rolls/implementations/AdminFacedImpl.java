// B"H
package shmulik.coupons_manager.final_project.services.rolls.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.AdminFacade;

import java.util.List;

@Service
public class AdminFacedImpl implements AdminFacade {

//    @Autowired
//    private CouponRepo couponRepo;

    @Autowired
    private CompanyService companyService;

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

    @Override
    public Company getCompanyByid(int id) {
        return companyService.findById(id);
    }
}