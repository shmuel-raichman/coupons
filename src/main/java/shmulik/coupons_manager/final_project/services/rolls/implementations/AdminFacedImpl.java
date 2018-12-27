// B"H
package shmulik.coupons_manager.final_project.services.rolls.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.repositories.CouponRepo;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.AdminFacade;

@Service
public class AdminFacedImpl implements AdminFacade {

    @Autowired
    private CouponRepo couponRepo;
}

