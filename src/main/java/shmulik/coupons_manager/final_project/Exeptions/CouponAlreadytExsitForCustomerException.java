// B"H
package shmulik.coupons_manager.final_project.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class CouponAlreadytExsitForCustomerException extends MainCouponsExeption{

    String test;

    public CouponAlreadytExsitForCustomerException(String msg) {
        super(msg);
    }

    public CouponAlreadytExsitForCustomerException(String msg, String test) {
        super(msg);
        this.test = test;
    }
}
