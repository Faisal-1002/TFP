package com.example.tfp.Repository;

import com.example.tfp.Model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer> {
    Field findFieldById(Integer id);
}
