package de.ait.shop43.customer.entity;

import de.ait.shop43.cart.entity.Cart;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table (name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//способ генерации ID по порядку
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "isActive")
    private boolean isActive;

    @OneToOne(
            mappedBy = "customer", //сообщаем spring'у что эта таблица ведомая, параметр = название поля
            cascade = CascadeType.ALL // ALL - каскадное удаление связанных сущностей, если изменить/удалит customer, то cart также синхронизируется
    )
//    @Column(name = "cart")
    private Cart cart;
}
