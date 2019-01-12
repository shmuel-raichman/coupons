// B"H
package shmulik.coupons_manager.final_project.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Customer;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.AdminFacade;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServices {

    @Autowired
    private AdminFacade adminFacade;

    String comp = "comp-";
    private String cust = "cust-";

    private int num = (int)(Math.random() * 10000);;

    @Test
    public void createCustomer(){
        Customer customer = new Customer();



        System.out.println(num);

        customer.setCustName(cust + num);
        customer.setEmail(cust + num);
        customer.setPassword(cust + num);
        long custID = adminFacade.addNewCustomer(customer).getId();

        System.out.println("New customer added.\n" + adminFacade.getCustomerByid((int)custID).toString());
    }

    @Test
    public void createCompany(){
        Company company = new Company();
        company.setCompName(comp + num);
        company.setEmail(comp + num);
        company.setPassword(comp + num);

        long compID = adminFacade.createNewCompany(company).getId();

        System.out.println("New company added.\n" + adminFacade.getCompanyByid((int)compID).toString());
    }
}
