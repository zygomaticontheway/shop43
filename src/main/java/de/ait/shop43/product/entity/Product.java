package de.ait.shop43.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter //создаем геттеры
@AllArgsConstructor //создаем конструктор со всеми параметрами
@NoArgsConstructor //создаем пустой конструктор для mapper'a
@Builder // !!! create pattern Builder

@Entity //говорим что это будет сущност репо
@Table(name="product") //указываем таблицу, где будут лежать в репо сущности
public class Product {

    @Setter
    @Id//говорим, что это ID в нашей Entity
    @GeneratedValue //генерируется автоматически
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "isActive")
    private boolean isActive;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", isActive=" + isActive +
                '}';
    }
}
