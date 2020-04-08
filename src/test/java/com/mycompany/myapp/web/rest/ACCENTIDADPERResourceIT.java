package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterSampleTCuApp;
import com.mycompany.myapp.domain.ACCENTIDADPER;
import com.mycompany.myapp.repository.ACCENTIDADPERRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ACCENTIDADPERResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleTCuApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class ACCENTIDADPERResourceIT {

    private static final String DEFAULT_N_IF = "AAAAAAAAAA";
    private static final String UPDATED_N_IF = "BBBBBBBBBB";

    private static final String DEFAULT_N_OMBRE = "AAAAAAAAAA";
    private static final String UPDATED_N_OMBRE = "BBBBBBBBBB";

    private static final String DEFAULT_A_PELLIDO_1 = "AAAAAAAAAA";
    private static final String UPDATED_A_PELLIDO_1 = "BBBBBBBBBB";

    private static final String DEFAULT_A_PELLIDO_2 = "AAAAAAAAAA";
    private static final String UPDATED_A_PELLIDO_2 = "BBBBBBBBBB";

    private static final String DEFAULT_E_MAIL = "AAAAAAAAAA";
    private static final String UPDATED_E_MAIL = "BBBBBBBBBB";

    @Autowired
    private ACCENTIDADPERRepository aCCENTIDADPERRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restACCENTIDADPERMockMvc;

    private ACCENTIDADPER aCCENTIDADPER;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ACCENTIDADPER createEntity(EntityManager em) {
        ACCENTIDADPER aCCENTIDADPER = new ACCENTIDADPER()
            .nIF(DEFAULT_N_IF)
            .nOMBRE(DEFAULT_N_OMBRE)
            .aPELLIDO1(DEFAULT_A_PELLIDO_1)
            .aPELLIDO2(DEFAULT_A_PELLIDO_2)
            .eMAIL(DEFAULT_E_MAIL);
        return aCCENTIDADPER;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ACCENTIDADPER createUpdatedEntity(EntityManager em) {
        ACCENTIDADPER aCCENTIDADPER = new ACCENTIDADPER()
            .nIF(UPDATED_N_IF)
            .nOMBRE(UPDATED_N_OMBRE)
            .aPELLIDO1(UPDATED_A_PELLIDO_1)
            .aPELLIDO2(UPDATED_A_PELLIDO_2)
            .eMAIL(UPDATED_E_MAIL);
        return aCCENTIDADPER;
    }

    @BeforeEach
    public void initTest() {
        aCCENTIDADPER = createEntity(em);
    }

    @Test
    @Transactional
    public void createACCENTIDADPER() throws Exception {
        int databaseSizeBeforeCreate = aCCENTIDADPERRepository.findAll().size();

        // Create the ACCENTIDADPER
        restACCENTIDADPERMockMvc.perform(post("/api/accentidadpers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aCCENTIDADPER)))
            .andExpect(status().isCreated());

        // Validate the ACCENTIDADPER in the database
        List<ACCENTIDADPER> aCCENTIDADPERList = aCCENTIDADPERRepository.findAll();
        assertThat(aCCENTIDADPERList).hasSize(databaseSizeBeforeCreate + 1);
        ACCENTIDADPER testACCENTIDADPER = aCCENTIDADPERList.get(aCCENTIDADPERList.size() - 1);
        assertThat(testACCENTIDADPER.getnIF()).isEqualTo(DEFAULT_N_IF);
        assertThat(testACCENTIDADPER.getnOMBRE()).isEqualTo(DEFAULT_N_OMBRE);
        assertThat(testACCENTIDADPER.getaPELLIDO1()).isEqualTo(DEFAULT_A_PELLIDO_1);
        assertThat(testACCENTIDADPER.getaPELLIDO2()).isEqualTo(DEFAULT_A_PELLIDO_2);
        assertThat(testACCENTIDADPER.geteMAIL()).isEqualTo(DEFAULT_E_MAIL);
    }

    @Test
    @Transactional
    public void createACCENTIDADPERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = aCCENTIDADPERRepository.findAll().size();

        // Create the ACCENTIDADPER with an existing ID
        aCCENTIDADPER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restACCENTIDADPERMockMvc.perform(post("/api/accentidadpers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aCCENTIDADPER)))
            .andExpect(status().isBadRequest());

        // Validate the ACCENTIDADPER in the database
        List<ACCENTIDADPER> aCCENTIDADPERList = aCCENTIDADPERRepository.findAll();
        assertThat(aCCENTIDADPERList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllACCENTIDADPERS() throws Exception {
        // Initialize the database
        aCCENTIDADPERRepository.saveAndFlush(aCCENTIDADPER);

        // Get all the aCCENTIDADPERList
        restACCENTIDADPERMockMvc.perform(get("/api/accentidadpers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(aCCENTIDADPER.getId().intValue())))
            .andExpect(jsonPath("$.[*].nIF").value(hasItem(DEFAULT_N_IF)))
            .andExpect(jsonPath("$.[*].nOMBRE").value(hasItem(DEFAULT_N_OMBRE)))
            .andExpect(jsonPath("$.[*].aPELLIDO1").value(hasItem(DEFAULT_A_PELLIDO_1)))
            .andExpect(jsonPath("$.[*].aPELLIDO2").value(hasItem(DEFAULT_A_PELLIDO_2)))
            .andExpect(jsonPath("$.[*].eMAIL").value(hasItem(DEFAULT_E_MAIL)));
    }
    
    @Test
    @Transactional
    public void getACCENTIDADPER() throws Exception {
        // Initialize the database
        aCCENTIDADPERRepository.saveAndFlush(aCCENTIDADPER);

        // Get the aCCENTIDADPER
        restACCENTIDADPERMockMvc.perform(get("/api/accentidadpers/{id}", aCCENTIDADPER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(aCCENTIDADPER.getId().intValue()))
            .andExpect(jsonPath("$.nIF").value(DEFAULT_N_IF))
            .andExpect(jsonPath("$.nOMBRE").value(DEFAULT_N_OMBRE))
            .andExpect(jsonPath("$.aPELLIDO1").value(DEFAULT_A_PELLIDO_1))
            .andExpect(jsonPath("$.aPELLIDO2").value(DEFAULT_A_PELLIDO_2))
            .andExpect(jsonPath("$.eMAIL").value(DEFAULT_E_MAIL));
    }

    @Test
    @Transactional
    public void getNonExistingACCENTIDADPER() throws Exception {
        // Get the aCCENTIDADPER
        restACCENTIDADPERMockMvc.perform(get("/api/accentidadpers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateACCENTIDADPER() throws Exception {
        // Initialize the database
        aCCENTIDADPERRepository.saveAndFlush(aCCENTIDADPER);

        int databaseSizeBeforeUpdate = aCCENTIDADPERRepository.findAll().size();

        // Update the aCCENTIDADPER
        ACCENTIDADPER updatedACCENTIDADPER = aCCENTIDADPERRepository.findById(aCCENTIDADPER.getId()).get();
        // Disconnect from session so that the updates on updatedACCENTIDADPER are not directly saved in db
        em.detach(updatedACCENTIDADPER);
        updatedACCENTIDADPER
            .nIF(UPDATED_N_IF)
            .nOMBRE(UPDATED_N_OMBRE)
            .aPELLIDO1(UPDATED_A_PELLIDO_1)
            .aPELLIDO2(UPDATED_A_PELLIDO_2)
            .eMAIL(UPDATED_E_MAIL);

        restACCENTIDADPERMockMvc.perform(put("/api/accentidadpers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedACCENTIDADPER)))
            .andExpect(status().isOk());

        // Validate the ACCENTIDADPER in the database
        List<ACCENTIDADPER> aCCENTIDADPERList = aCCENTIDADPERRepository.findAll();
        assertThat(aCCENTIDADPERList).hasSize(databaseSizeBeforeUpdate);
        ACCENTIDADPER testACCENTIDADPER = aCCENTIDADPERList.get(aCCENTIDADPERList.size() - 1);
        assertThat(testACCENTIDADPER.getnIF()).isEqualTo(UPDATED_N_IF);
        assertThat(testACCENTIDADPER.getnOMBRE()).isEqualTo(UPDATED_N_OMBRE);
        assertThat(testACCENTIDADPER.getaPELLIDO1()).isEqualTo(UPDATED_A_PELLIDO_1);
        assertThat(testACCENTIDADPER.getaPELLIDO2()).isEqualTo(UPDATED_A_PELLIDO_2);
        assertThat(testACCENTIDADPER.geteMAIL()).isEqualTo(UPDATED_E_MAIL);
    }

    @Test
    @Transactional
    public void updateNonExistingACCENTIDADPER() throws Exception {
        int databaseSizeBeforeUpdate = aCCENTIDADPERRepository.findAll().size();

        // Create the ACCENTIDADPER

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restACCENTIDADPERMockMvc.perform(put("/api/accentidadpers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aCCENTIDADPER)))
            .andExpect(status().isBadRequest());

        // Validate the ACCENTIDADPER in the database
        List<ACCENTIDADPER> aCCENTIDADPERList = aCCENTIDADPERRepository.findAll();
        assertThat(aCCENTIDADPERList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteACCENTIDADPER() throws Exception {
        // Initialize the database
        aCCENTIDADPERRepository.saveAndFlush(aCCENTIDADPER);

        int databaseSizeBeforeDelete = aCCENTIDADPERRepository.findAll().size();

        // Delete the aCCENTIDADPER
        restACCENTIDADPERMockMvc.perform(delete("/api/accentidadpers/{id}", aCCENTIDADPER.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ACCENTIDADPER> aCCENTIDADPERList = aCCENTIDADPERRepository.findAll();
        assertThat(aCCENTIDADPERList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
