// B"H
package shmulik.coupons_manager.final_project.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class CustomerAlreadyExistException extends MainCouponsExeption{

    public CustomerAlreadyExistException(String msg) {
        super(msg);
    }
}
