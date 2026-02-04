package com.example.starwars.repository;

import com.example.starwars.entity.PlanetaFavoritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository de planetas favoritos.
 */
@Repository
public interface PlanetaFavoritoRepository extends JpaRepository<PlanetaFavoritoEntity, Long> {
}
