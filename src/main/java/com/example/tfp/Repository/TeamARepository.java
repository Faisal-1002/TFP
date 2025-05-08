package com.example.tfp.Repository;

import com.example.tfp.Model.TeamA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamARepository extends JpaRepository<TeamA, Integer> {

    TeamA findTeamAById(Integer id);
}
