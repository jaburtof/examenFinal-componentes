package com.cenfotec.examen.repositories;

import com.cenfotec.examen.entities.Hijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HijoRepository extends JpaRepository<Hijo, Integer> {
}
