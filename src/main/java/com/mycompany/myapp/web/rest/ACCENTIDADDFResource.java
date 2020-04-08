package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.ACCENTIDADDF;
import com.mycompany.myapp.repository.ACCENTIDADDFRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.ACCENTIDADDF}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ACCENTIDADDFResource {

    private final Logger log = LoggerFactory.getLogger(ACCENTIDADDFResource.class);

    private static final String ENTITY_NAME = "aCCENTIDADDF";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ACCENTIDADDFRepository aCCENTIDADDFRepository;

    public ACCENTIDADDFResource(ACCENTIDADDFRepository aCCENTIDADDFRepository) {
        this.aCCENTIDADDFRepository = aCCENTIDADDFRepository;
    }

    /**
     * {@code POST  /accentidaddfs} : Create a new aCCENTIDADDF.
     *
     * @param aCCENTIDADDF the aCCENTIDADDF to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new aCCENTIDADDF, or with status {@code 400 (Bad Request)} if the aCCENTIDADDF has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/accentidaddfs")
    public ResponseEntity<ACCENTIDADDF> createACCENTIDADDF(@RequestBody ACCENTIDADDF aCCENTIDADDF) throws URISyntaxException {
        log.debug("REST request to save ACCENTIDADDF : {}", aCCENTIDADDF);
        if (aCCENTIDADDF.getId() != null) {
            throw new BadRequestAlertException("A new aCCENTIDADDF cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ACCENTIDADDF result = aCCENTIDADDFRepository.save(aCCENTIDADDF);
        return ResponseEntity.created(new URI("/api/accentidaddfs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /accentidaddfs} : Updates an existing aCCENTIDADDF.
     *
     * @param aCCENTIDADDF the aCCENTIDADDF to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated aCCENTIDADDF,
     * or with status {@code 400 (Bad Request)} if the aCCENTIDADDF is not valid,
     * or with status {@code 500 (Internal Server Error)} if the aCCENTIDADDF couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/accentidaddfs")
    public ResponseEntity<ACCENTIDADDF> updateACCENTIDADDF(@RequestBody ACCENTIDADDF aCCENTIDADDF) throws URISyntaxException {
        log.debug("REST request to update ACCENTIDADDF : {}", aCCENTIDADDF);
        if (aCCENTIDADDF.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ACCENTIDADDF result = aCCENTIDADDFRepository.save(aCCENTIDADDF);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, aCCENTIDADDF.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /accentidaddfs} : get all the aCCENTIDADDFS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of aCCENTIDADDFS in body.
     */
    @GetMapping("/accentidaddfs")
    public ResponseEntity<List<ACCENTIDADDF>> getAllACCENTIDADDFS(Pageable pageable) {
        log.debug("REST request to get a page of ACCENTIDADDFS");
        Page<ACCENTIDADDF> page = aCCENTIDADDFRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /accentidaddfs/:id} : get the "id" aCCENTIDADDF.
     *
     * @param id the id of the aCCENTIDADDF to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the aCCENTIDADDF, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/accentidaddfs/{id}")
    public ResponseEntity<ACCENTIDADDF> getACCENTIDADDF(@PathVariable Long id) {
        log.debug("REST request to get ACCENTIDADDF : {}", id);
        Optional<ACCENTIDADDF> aCCENTIDADDF = aCCENTIDADDFRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(aCCENTIDADDF);
    }

    /**
     * {@code DELETE  /accentidaddfs/:id} : delete the "id" aCCENTIDADDF.
     *
     * @param id the id of the aCCENTIDADDF to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/accentidaddfs/{id}")
    public ResponseEntity<Void> deleteACCENTIDADDF(@PathVariable Long id) {
        log.debug("REST request to delete ACCENTIDADDF : {}", id);
        aCCENTIDADDFRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
