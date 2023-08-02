package com.imperial.imperial_restaurante.repository;

import com.imperial.imperial_restaurante.entidades.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

    Optional<Cardapio>findById(Long id);

}
