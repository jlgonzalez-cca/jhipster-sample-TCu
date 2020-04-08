package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ACCENTIDADDVT;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ACCENTIDADDVT entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ACCENTIDADDVTRepository extends JpaRepository<ACCENTIDADDVT, Long> {
}
