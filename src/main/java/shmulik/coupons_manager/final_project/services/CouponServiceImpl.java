package shmulik.coupons_manager.final_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.repositories.CouponRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepo couponRepo;

    @Override
    public List<Coupon> findAllItems() {
        return couponRepo.findAll();
    }


    @Override
    public Coupon findItemById(long itemId) {
        Optional<Coupon> optinal =   couponRepo.findById(itemId);
        return optinal.orElse(null);
    }

    @Override
    @Transactional
    public Coupon createCoupon(Coupon coupon) {
        couponRepo.save(coupon);
        return coupon;
    }
}
