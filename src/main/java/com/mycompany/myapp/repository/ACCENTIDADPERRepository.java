package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ACCENTIDADPER;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ACCENTIDADPER entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ACCENTIDADPERRepository extends JpaRepository<ACCENTIDADPER, Long> {
}
