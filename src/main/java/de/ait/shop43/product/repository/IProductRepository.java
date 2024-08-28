package de.ait.shop43.product.repository;

import de.ait.shop43.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

// подключаем Spring Data JPA:
// extends JpaRepository<Product,Long> => Product - тип сущности, Long - тип идентификатора(ключа ID)
public interface IProductRepository extends JpaRepository<Product,Long> {
    //hibernate сам автоматом сгенерировал этот метод, подсказочки по ключевым словам работают
    List<Product> findByTitleIsContainingIgnoreCase(String title);

    List<Product> findByTitleOrIsActive(String title, boolean active); //where product.title=title and product.active=true

    Product findFirstByTitleOrderById(String title);

    List<Product> findAllByTitleIn(List<String> titles);
    List<Product> findAllByPriceGreaterThanEqual(BigDecimal price);
}