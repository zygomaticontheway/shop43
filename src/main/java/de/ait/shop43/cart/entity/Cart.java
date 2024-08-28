package de.ait.shop43.cart.entity;

import de.ait.shop43.customer.entity.Customer;
import de.ait.shop43.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table (name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "customer_id")
    @OneToOne
//    @Column(name = "customer")
    private Customer customer;

    //описываем таблицу, которая хранит связь
    @ManyToMany
    @JoinTable(
            name = "cart_product", //имя таблицы
            joinColumns = @JoinColumn(name = "cart_id"), //столбец данной таблицы, который попадет в ведомую
            inverseJoinColumns = @JoinColumn(name = "product_id") //столбец ведомой таблицы для связи с продуктом
    )
    @Column(name = "products")
    private List<Product> products;

//    products = new ArrayList<P>();

    public boolean addProduct(Product product){
        if (products == null){
            products = new ArrayList<>();
        }
        products.add(product);
        return true;
    }
    public boolean removeProduct(Product product){

        return products.remove(product); //проверять на наличие нет смысла ибо remove exception не выбрасывает, вернет и так false
    }

}
