// B"H
/**
 * 
 */
package shmulik.coupons_manager.final_project.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shmulik.coupons_manager.final_project.entities.Coupon;

/**
 * @author sem
 *
 */
@Repository
public interface CouponsRepoImpl extends JpaRepository<Coupon, Long>{
	
	List<Coupon> findAll();
	
	@Query("SELECT c from Coupon c where c.endDate < :date")
	List<Coupon> getExpiredFrom(@Param("date") LocalDate date);
	
}
