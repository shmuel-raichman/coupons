package shmulik.coupons_manager.final_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shmulik.coupons_manager.final_project.entities.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
