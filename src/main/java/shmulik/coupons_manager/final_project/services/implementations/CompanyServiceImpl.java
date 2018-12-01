package shmulik.coupons_manager.final_project.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.repositories.CompanyRepo;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

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
}
