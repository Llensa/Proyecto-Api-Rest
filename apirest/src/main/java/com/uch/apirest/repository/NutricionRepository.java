package com.uch.apirest.repository;


import com.uch.apirest.model.Nutricion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NutricionRepository extends JpaRepository<Nutricion, Long> {
}
