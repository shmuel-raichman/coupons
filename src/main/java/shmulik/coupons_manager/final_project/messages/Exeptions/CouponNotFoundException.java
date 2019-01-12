// B"H
package shmulik.coupons_manager.final_project.messages.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CouponNotFoundException extends MainCouponsExeption{

    public CouponNotFoundException(String msg) {
        super(msg);
    }

}
