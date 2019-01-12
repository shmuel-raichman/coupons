// B"H
package shmulik.coupons_manager.final_project.services.rolls.interfaces;

import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Customer;

import java.util.List;

public interface AdminFacade {

    Company createNewCompany(Company company);

    Company updateCompanyEmail(long companyId, String email);

    Company updateCompanyPassword(long companyId, String email);

    List<Company> getAllCompanies ();

    Company getCompanyByid(int id);

    Customer addNewCustomer(Customer customer);

    Customer getCustomerByid(int id);

    Customer updateCustomerEmail(long customerId, String email);

    Customer updateCustomerPassword(long customerId, String email);

    List<Customer> getAllCustomers ();

    boolean deleteCustomerById(int id);

    boolean deleteCompanyById(int id);

//    Coupon addCouponToCustomer(long couponId, long customerId);
}
