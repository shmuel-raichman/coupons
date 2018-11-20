// B"H
package shmulik.coupons_manager.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.services.CouponService;


import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/api/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public List<Coupon> FindAllItems() {
        return couponService.findAllItems();
    }

    @GetMapping("{id}")
    public Coupon FindItemById(@PathVariable("id") int itemId){
        return couponService.findItemById(itemId);
    }

    @PostMapping
    public Coupon createOrder(@RequestBody Coupon coupon) {
        return couponService.createOrder(coupon);
    }
}
