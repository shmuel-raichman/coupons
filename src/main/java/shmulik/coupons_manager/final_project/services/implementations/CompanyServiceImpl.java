package shmulik.coupons_manager.final_project.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.repositories.CompanyRepo;
import shmulik.coupons_manager.final_project.repositories.CouponRepo;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;
import shmulik.coupons_manager.final_project.services.interfaces.CouponService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private CouponRepo couponRepo;

    @Autowired
    private CouponService couponService;

    @Autowired
    private CompanyService companyService;

    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }


    @Override
    public Company findById(long id) {
        Optional<Company> optinal = companyRepo.findById(id);
        return optinal.orElse(null);
    }

    @Override
    @Transactional
    public Company createCompany(Company company) {
//        if(company.getId() == 0) {
            companyRepo.save(company);
            return company;
//        }
//        else {
//            return new Company("customer already exist: can't update using this method try updateCoupon.");
//        }
    }

    @Override
    @Transactional
    public Company updateCompany(Company company) {

//        if(companyRepo.findById(company.getId()) == null) {
//            Company error = new Company("customer not exist exist : can't create coupon using this method try createCustomer.");
//            //error.setAmount((Integer)null);
//            return error;
//
//        }
//        else if(company.getId() == 0){
//            Company error = new Company("no id to update: can't update unknown customer please supply ID.");
//            //error.setAmount((Integer)null);
//            return error;
//        } else {
            companyRepo.save(company);
            return company;
//        }
    }

//    public Coupon addCouponToCompany(long couponId, long companyId){
//        Company company = findById(companyId);
//        Coupon coupon = couponService.findById(couponId);
//
//        company.getCoupons().add(coupon);
//        companyRepo.save(company);
//
//        return coupon;
//    }

    @Override
    @Transactional
    public boolean deleteCompanyById(long id) {
        if(companyRepo.findById(id) == null) {
            return false;
        }
        else {
            companyRepo.deleteById(id);
            return true;
        }
    }

    @Override
    public Coupon createNewCoupon(Coupon coupon, long companyID){
        Company company = companyService.findById(companyID);
        couponService.createCoupon(coupon);
//        if(!customer.getCoupons().contains(coupon)){
            long newCouponId = couponService.findById(coupon.getId()).getId();
            Coupon newCoupon = couponService.findById(coupon.getId());
            company.getCoupons().add(newCoupon);
//            company.setCoupons(Arrays.asList(newCoupon));
            companyRepo.save(company);
//            couponRepo.save(newCoupon);
//            couponRepo.save(coupon);
//        } else {
//            throw new CouponAlreadytExsitForCustomerException("Coupon already exist for this customer.");
//        }
        return coupon;
    }
}
