// B"H
package shmulik.coupons_manager.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;

import java.util.List;


@RestController
@RequestMapping("/rest/api/company")
public class CompanyControllerOld {

    @Autowired
    private CompanyService companyService;


    @GetMapping
    public List<Company> findAllItems() {
        return companyService.findAll();
    }

    @GetMapping("{id}")
    public Company findItemById(@PathVariable("id") int id){
        return companyService.findById(id);
    }

    @PostMapping("/createcompany")
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);

    }

    @PostMapping("/updatecompany")
    public Company updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    @DeleteMapping("{id}")
    public boolean deleteCompanyById(@PathVariable("id") int id) {
        return companyService.deleteCompanyById(id);
    }

//    @PostMapping("/createNewCoupon")
//    public Coupon createNewCoupon (@RequestBody Coupon coupon, @RequestParam("companyID") long companyID){
//       return companyService.createNewCoupon(coupon, companyID );
//    }
}
