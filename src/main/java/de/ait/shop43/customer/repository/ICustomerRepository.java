package de.ait.shop43.customer.repository;

import de.ait.shop43.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
