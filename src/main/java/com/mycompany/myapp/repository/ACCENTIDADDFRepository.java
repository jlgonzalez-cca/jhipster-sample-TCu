package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ACCENTIDADDF;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ACCENTIDADDF entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ACCENTIDADDFRepository extends JpaRepository<ACCENTIDADDF, Long> {
}
