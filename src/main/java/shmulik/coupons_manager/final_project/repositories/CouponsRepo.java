// B"H
/**
 * 
 */
package shmulik.coupons_manager.final_project.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import shmulik.coupons_manager.final_project.entities.Coupon;

/**
 * @author sem
 *
 */

public class CouponsRepo  {
	
	@Autowired
	private CouponsRepoImpl couponsRepoImpl;
	
	public List<Coupon> getAll() {
		return couponsRepoImpl.findAll().stream()
				// TODO check another way for this method.
				.filter(c -> c.getAmount() > 0).collect(Collectors.toList());
	}
}
