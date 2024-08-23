package de.ait.shop43.product.repository;

import de.ait.shop43.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// подключаем Spring Data JPA:
// extends JpaRepository<Product,Long> => Product - тип сущности, Long - тип идентификатора(ключа ID)
public interface IProductRepository extends JpaRepository<Product,Long> {
}
