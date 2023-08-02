package com.imperial.imperial_restaurante.repository;

import com.imperial.imperial_restaurante.entidades.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {

}
