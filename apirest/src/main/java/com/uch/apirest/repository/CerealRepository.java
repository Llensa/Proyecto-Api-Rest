package com.uch.apirest.repository;


import com.uch.apirest.model.Cereal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CerealRepository extends JpaRepository<Cereal, Long> {
}
