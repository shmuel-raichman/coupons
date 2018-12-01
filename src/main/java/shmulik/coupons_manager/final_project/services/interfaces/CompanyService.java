package shmulik.coupons_manager.final_project.services.interfaces;

import shmulik.coupons_manager.final_project.entities.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company findById(long id);

    Company createCompany(Company company);

    Company updateCompany(Company company);

    boolean deleteCompanyById(long id);
}
