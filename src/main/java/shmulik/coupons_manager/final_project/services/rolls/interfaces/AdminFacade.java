// B"H
package shmulik.coupons_manager.final_project.services.rolls.interfaces;

import shmulik.coupons_manager.final_project.entities.Company;

import java.util.List;

public interface AdminFacade {

    Company createNewCompany(Company company);

    Company updateCompanyEmail(long companyId, String email);

    Company updateCompanyPassword(long companyId, String email);

    List<Company> getAllCompanies ();

    Company getCompanyByid(int id);
}
