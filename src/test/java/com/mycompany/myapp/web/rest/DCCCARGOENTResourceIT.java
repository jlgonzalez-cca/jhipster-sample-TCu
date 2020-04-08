package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterSampleTCuApp;
import com.mycompany.myapp.domain.DCCCARGOENT;
import com.mycompany.myapp.repository.DCCCARGOENTRepository;

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
 * Integration tests for the {@link DCCCARGOENTResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleTCuApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class DCCCARGOENTResourceIT {

    private static final Long DEFAULT_I_DCARGO = 1L;
    private static final Long UPDATED_I_DCARGO = 2L;

    private static final String DEFAULT_N_OMBRE = "AAAAAAAAAA";
    private static final String UPDATED_N_OMBRE = "BBBBBBBBBB";

    @Autowired
    private DCCCARGOENTRepository dCCCARGOENTRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDCCCARGOENTMockMvc;

    private DCCCARGOENT dCCCARGOENT;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DCCCARGOENT createEntity(EntityManager em) {
        DCCCARGOENT dCCCARGOENT = new DCCCARGOENT()
            .iDCARGO(DEFAULT_I_DCARGO)
            .nOMBRE(DEFAULT_N_OMBRE);
        return dCCCARGOENT;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DCCCARGOENT createUpdatedEntity(EntityManager em) {
        DCCCARGOENT dCCCARGOENT = new DCCCARGOENT()
            .iDCARGO(UPDATED_I_DCARGO)
            .nOMBRE(UPDATED_N_OMBRE);
        return dCCCARGOENT;
    }

    @BeforeEach
    public void initTest() {
        dCCCARGOENT = createEntity(em);
    }

    @Test
    @Transactional
    public void createDCCCARGOENT() throws Exception {
        int databaseSizeBeforeCreate = dCCCARGOENTRepository.findAll().size();

        // Create the DCCCARGOENT
        restDCCCARGOENTMockMvc.perform(post("/api/dcccargoents")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dCCCARGOENT)))
            .andExpect(status().isCreated());

        // Validate the DCCCARGOENT in the database
        List<DCCCARGOENT> dCCCARGOENTList = dCCCARGOENTRepository.findAll();
        assertThat(dCCCARGOENTList).hasSize(databaseSizeBeforeCreate + 1);
        DCCCARGOENT testDCCCARGOENT = dCCCARGOENTList.get(dCCCARGOENTList.size() - 1);
        assertThat(testDCCCARGOENT.getiDCARGO()).isEqualTo(DEFAULT_I_DCARGO);
        assertThat(testDCCCARGOENT.getnOMBRE()).isEqualTo(DEFAULT_N_OMBRE);
    }

    @Test
    @Transactional
    public void createDCCCARGOENTWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dCCCARGOENTRepository.findAll().size();

        // Create the DCCCARGOENT with an existing ID
        dCCCARGOENT.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDCCCARGOENTMockMvc.perform(post("/api/dcccargoents")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dCCCARGOENT)))
            .andExpect(status().isBadRequest());

        // Validate the DCCCARGOENT in the database
        List<DCCCARGOENT> dCCCARGOENTList = dCCCARGOENTRepository.findAll();
        assertThat(dCCCARGOENTList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDCCCARGOENTS() throws Exception {
        // Initialize the database
        dCCCARGOENTRepository.saveAndFlush(dCCCARGOENT);

        // Get all the dCCCARGOENTList
        restDCCCARGOENTMockMvc.perform(get("/api/dcccargoents?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dCCCARGOENT.getId().intValue())))
            .andExpect(jsonPath("$.[*].iDCARGO").value(hasItem(DEFAULT_I_DCARGO.intValue())))
            .andExpect(jsonPath("$.[*].nOMBRE").value(hasItem(DEFAULT_N_OMBRE)));
    }
    
    @Test
    @Transactional
    public void getDCCCARGOENT() throws Exception {
        // Initialize the database
        dCCCARGOENTRepository.saveAndFlush(dCCCARGOENT);

        // Get the dCCCARGOENT
        restDCCCARGOENTMockMvc.perform(get("/api/dcccargoents/{id}", dCCCARGOENT.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dCCCARGOENT.getId().intValue()))
            .andExpect(jsonPath("$.iDCARGO").value(DEFAULT_I_DCARGO.intValue()))
            .andExpect(jsonPath("$.nOMBRE").value(DEFAULT_N_OMBRE));
    }

    @Test
    @Transactional
    public void getNonExistingDCCCARGOENT() throws Exception {
        // Get the dCCCARGOENT
        restDCCCARGOENTMockMvc.perform(get("/api/dcccargoents/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDCCCARGOENT() throws Exception {
        // Initialize the database
        dCCCARGOENTRepository.saveAndFlush(dCCCARGOENT);

        int databaseSizeBeforeUpdate = dCCCARGOENTRepository.findAll().size();

        // Update the dCCCARGOENT
        DCCCARGOENT updatedDCCCARGOENT = dCCCARGOENTRepository.findById(dCCCARGOENT.getId()).get();
        // Disconnect from session so that the updates on updatedDCCCARGOENT are not directly saved in db
        em.detach(updatedDCCCARGOENT);
        updatedDCCCARGOENT
            .iDCARGO(UPDATED_I_DCARGO)
            .nOMBRE(UPDATED_N_OMBRE);

        restDCCCARGOENTMockMvc.perform(put("/api/dcccargoents")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedDCCCARGOENT)))
            .andExpect(status().isOk());

        // Validate the DCCCARGOENT in the database
        List<DCCCARGOENT> dCCCARGOENTList = dCCCARGOENTRepository.findAll();
        assertThat(dCCCARGOENTList).hasSize(databaseSizeBeforeUpdate);
        DCCCARGOENT testDCCCARGOENT = dCCCARGOENTList.get(dCCCARGOENTList.size() - 1);
        assertThat(testDCCCARGOENT.getiDCARGO()).isEqualTo(UPDATED_I_DCARGO);
        assertThat(testDCCCARGOENT.getnOMBRE()).isEqualTo(UPDATED_N_OMBRE);
    }

    @Test
    @Transactional
    public void updateNonExistingDCCCARGOENT() throws Exception {
        int databaseSizeBeforeUpdate = dCCCARGOENTRepository.findAll().size();

        // Create the DCCCARGOENT

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDCCCARGOENTMockMvc.perform(put("/api/dcccargoents")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dCCCARGOENT)))
            .andExpect(status().isBadRequest());

        // Validate the DCCCARGOENT in the database
        List<DCCCARGOENT> dCCCARGOENTList = dCCCARGOENTRepository.findAll();
        assertThat(dCCCARGOENTList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDCCCARGOENT() throws Exception {
        // Initialize the database
        dCCCARGOENTRepository.saveAndFlush(dCCCARGOENT);

        int databaseSizeBeforeDelete = dCCCARGOENTRepository.findAll().size();

        // Delete the dCCCARGOENT
        restDCCCARGOENTMockMvc.perform(delete("/api/dcccargoents/{id}", dCCCARGOENT.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DCCCARGOENT> dCCCARGOENTList = dCCCARGOENTRepository.findAll();
        assertThat(dCCCARGOENTList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
