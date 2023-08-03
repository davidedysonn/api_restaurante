package com.imperial.imperial_restaurante.repository;

import com.imperial.imperial_restaurante.entidades.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
