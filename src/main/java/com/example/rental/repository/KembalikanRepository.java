package com.example.rental.repository;

import com.example.rental.entity.Kembalikan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KembalikanRepository extends JpaRepository<Kembalikan, Long> {
}
