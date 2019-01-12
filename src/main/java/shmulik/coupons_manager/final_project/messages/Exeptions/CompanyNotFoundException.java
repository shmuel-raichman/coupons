// B"H
package shmulik.coupons_manager.final_project.messages.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shmulik.coupons_manager.final_project.messages.logs.Logs;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends MainCouponsExeption{

    public CompanyNotFoundException(String msg) {
        super(msg);
        Logs.logMessage("error", msg);
    }

}
