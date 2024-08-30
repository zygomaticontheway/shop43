package de.ait.shop43;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptDemo {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "qwerty";

        String securePassword = encoder.encode(password);

        System.out.println(securePassword);
        //$2a$10$j0rM1tbos4cAjGIkN60MW.CaWbmKM45hIOxq2mw0VFOdkdka6TDhy
        //$2a$10$KidPLsm7fA6s3AA31gNi4uhG3GWm6KU.IgBf6UNnKCORtPnMg2X1u

        boolean matches1 = encoder.matches(password, "$2a$10$j0rM1tbos4cAjGIkN60MW.CaWbmKM45hIOxq2mw0VFOdkdka6TDhy");
        boolean matches2 = encoder.matches(password, "$2a$10$KidPLsm7fA6s3AA31gNi4uhG3GWm6KU.IgBf6UNnKCORtPnMg2X1u");

        System.out.println(matches1);
        System.out.println(matches2);
    }
}
