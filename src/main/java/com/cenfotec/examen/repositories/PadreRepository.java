package com.cenfotec.examen.repositories;

import com.cenfotec.examen.entities.Padre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadreRepository extends JpaRepository<Padre, Integer> {
}
