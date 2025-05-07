package com.example.tfp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Check;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "role = 'PLAYER' OR role = 'ORGANIZER' OR role = 'ADMIN'")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username must not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "Password must be at least 8 characters and include uppercase, lowercase, number, and special character"
    )
    @Column(columnDefinition = "varchar(255) not null")
    private String password;

    @NotEmpty(message = "Role must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String role;

    @NotEmpty(message = "Name must not be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @NotEmpty(message = "Phone number must not be empty")
    @Pattern(regexp = "^(05)[0-9]{8}$", message = "Phone number must start with 05 and be 10 digits")
    @Column(columnDefinition = "varchar(10) not null")
    private String phone;

    @NotEmpty(message = "City must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String city;

    @Email(message = "Email must be valid")
    @NotEmpty(message = "Email must not be empty")
    @Column(columnDefinition = "varchar(100) not null unique")
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Player player;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Organizer organizer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
