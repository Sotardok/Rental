package com.example.rental.repository;

import com.example.rental.entity.Mobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobilRepository extends JpaRepository<Mobil, Long> {
    List<Mobil> findAllById(Long id);
}
