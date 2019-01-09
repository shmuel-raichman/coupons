// B"H
package shmulik.coupons_manager.final_project.controllers.rolls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.messages.Exeptions.CouponAlreadytExsitException;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.CompanyFacade;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/rest/api/company")
public class CompanyController {

    @Autowired
    private CompanyFacade companyFacade;

    @PostMapping("/createNewCoupon")
    public Coupon createNewCoupon (@RequestBody Coupon coupon, @RequestParam("companyID") long companyID){
        try {
            return companyFacade.createNewCoupon(coupon, companyID );
        } catch (DataIntegrityViolationException e) {
            String str = e.getMostSpecificCause().getMessage().split("'")[1];
            throw new CouponAlreadytExsitException("Coupon title '" + str + "' is not unique.");
        }
    }

    @DeleteMapping("/deleteCoupon/{id}")
    public boolean deleteCoupon(@PathVariable("id") long couponID){
        return companyFacade.deleteCoupon(couponID);
    }

    @PostMapping("/updateCouponExpireDate")
    public Coupon updateCouponExpireDate(@RequestBody Coupon coupon)  {
        return companyFacade.updateCouponExpireDate(coupon.getId(), coupon.getEndDate());
    }

    @PostMapping("/updateCouponPrice")
    public Coupon updateCouponPriceDate(@RequestBody Coupon coupon)  {
        return companyFacade.updateCouponPrice(coupon.getId(), coupon.getPrice());
    }

    @GetMapping("/getAllCouponsForCompany/{companyID}")
    public Set<Coupon> getAllCouponsForCompany(@PathVariable("companyID") long companyID){
        return companyFacade.getAllCouponsForCompany(companyID);
    }

    @PostMapping("/getCouponsForCompanyByPrice")
    public Set<Coupon> getCouponsForCompanyByPrice(@RequestParam("companyID") long companyID, @RequestParam("price") double price){
        return  companyFacade.getCouponsForCompanyByPrice(companyID, price);
    }

    @GetMapping("/getCouponsForCompanyByType")
    public Set<Coupon> getCouponsForCompanyByType(@RequestParam("companyID") long companyID, @RequestParam("category") String category){
        return  companyFacade.getCouponsForCompanyByType(companyID, category);
    }

    @PostMapping("/getCouponsForCompanyByEndDate")
    public Set<Coupon> getCouponsForCompanyByEndDate(@RequestBody Coupon coupon){
        return  companyFacade.getCouponsForCompanyByEndDate(coupon.getId(), coupon.getEndDate());
    }

    @GetMapping("/getMyCompany/{companyID}")
    public Company getMyCompany(@PathVariable("companyID") long companyID){
        // ----------  To not return company coupons jest details --------
        Company company = new Company();
        Company myCompany = companyFacade.getMyCompany(companyID);

        company.setPassword(myCompany.getPassword());
        company.setId(myCompany.getId());
        company.setEmail(myCompany.getEmail());
        company.setCompName(myCompany.getCompName());
        // ----------------------------------------------------------------
        return company;
    }
}
