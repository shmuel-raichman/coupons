// B"H
package shmulik.coupons_manager.final_project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.repositories.CouponsRepoImpl;

@Service
public class CouponServiceImpl implements CouponsService{
	
	@Autowired
	private CouponsRepoImpl couponsRepoImpl;
	
	@Override
	public List<Coupon> getAllCoupons(Long id) throws EntityNotFoundException {
		return new ArrayList<Coupon>(companyDao.getById(companyId).getCoupons());
	}
}