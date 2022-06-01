package com.example.rental.repository;

import com.example.rental.entity.Pinjam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinjamRepository extends JpaRepository<Pinjam, Long> {
}
