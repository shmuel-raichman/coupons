package shmulik.coupons_manager.final_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shmulik.coupons_manager.final_project.entities.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {
}
