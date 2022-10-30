package com.example.nbp.repositories;

import com.example.nbp.entities.Nbp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NbpRepository extends JpaRepository<Nbp, Integer> {
}
