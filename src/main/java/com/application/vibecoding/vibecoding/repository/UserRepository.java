package com.application.vibecoding.vibecoding.repository;

import com.application.vibecoding.vibecoding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
