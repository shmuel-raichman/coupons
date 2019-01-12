package shmulik.coupons_manager.final_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shmulik.coupons_manager.final_project.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
