// B"H
package shmulik.coupons_manager.final_project.messages.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class CouponAlreadytExsitException extends MainCouponsExeption{


    public CouponAlreadytExsitException(String msg) {
        super(msg);
    }

}
