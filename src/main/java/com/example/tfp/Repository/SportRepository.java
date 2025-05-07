package com.example.tfp.Repository;

import com.example.tfp.Model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {
    Sport findSportById(Integer id);
}
