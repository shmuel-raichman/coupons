// B"H
package shmulik.coupons_manager.final_project.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CouponOrCustomerNotExistException extends MainCouponsExeption{

    public CouponOrCustomerNotExistException(String msg) {
        super(msg);
    }

}
