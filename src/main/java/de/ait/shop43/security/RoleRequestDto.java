package de.ait.shop43.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class RoleRequestDto { //имплементирует интерфейс с правами доступа

//    private Long id;
    private String title;


}
