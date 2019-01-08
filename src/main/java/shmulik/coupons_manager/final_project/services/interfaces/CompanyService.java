package shmulik.coupons_manager.final_project.services.interfaces;

import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Coupon;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company findById(long id);

    Company createCompany(Company company);

    Company updateCompany(Company company);

    boolean deleteCompanyById(long id);

    Coupon createNewCoupon(Coupon coupon, long companyID);

    Company findByEmail(String email);

    boolean login(String companyEmail, String companyPassword);
}
