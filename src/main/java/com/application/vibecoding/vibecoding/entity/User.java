package com.application.vibecoding.vibecoding.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class  User implements UserDetails { // User is predefined keyword in postgres

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

     String name;
     String username;
     String password;

     @Column(unique = true)
     String stripeCustomerId;

    /*private String avatarUrl;*/

    @CreationTimestamp
    Instant createdAt;
    @UpdateTimestamp
    Instant updatedAt;
    Instant deletedAt; //soft deleted

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
