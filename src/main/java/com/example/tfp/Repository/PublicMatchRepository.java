package com.example.tfp.Repository;

import com.example.tfp.Model.PublicMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicMatchRepository extends JpaRepository<PublicMatch, Integer> {
    PublicMatch findPublicMatchById(Integer id);
}
