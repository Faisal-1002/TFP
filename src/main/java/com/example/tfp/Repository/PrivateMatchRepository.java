package com.example.tfp.Repository;

import com.example.tfp.Model.PrivateMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateMatchRepository extends JpaRepository<PrivateMatch, Integer> {
    PrivateMatch findPrivateMatchById(Integer id);
}
