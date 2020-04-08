package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterSampleTCuApp;
import com.mycompany.myapp.domain.ACCENTIDADDVT;
import com.mycompany.myapp.repository.ACCENTIDADDVTRepository;

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
 * Integration tests for the {@link ACCENTIDADDVTResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleTCuApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class ACCENTIDADDVTResourceIT {

    private static final Long DEFAULT_N_UMEROVERSION = 1L;
    private static final Long UPDATED_N_UMEROVERSION = 2L;

    private static final Long DEFAULT_F_ECHAVERSION = 1L;
    private static final Long UPDATED_F_ECHAVERSION = 2L;

    private static final String DEFAULT_N_IF = "AAAAAAAAAA";
    private static final String UPDATED_N_IF = "BBBBBBBBBB";

    private static final Long DEFAULT_E_JERCICIO = 1L;
    private static final Long UPDATED_E_JERCICIO = 2L;

    private static final String DEFAULT_I_DTIPO = "AAAAAAAAAA";
    private static final String UPDATED_I_DTIPO = "BBBBBBBBBB";

    private static final String DEFAULT_I_DTIPOREND = "AAAAAAAAAA";
    private static final String UPDATED_I_DTIPOREND = "BBBBBBBBBB";

    private static final Long DEFAULT_I_DUNIP = 1L;
    private static final Long UPDATED_I_DUNIP = 2L;

    private static final Long DEFAULT_I_DMUNICIPIO = 1L;
    private static final Long UPDATED_I_DMUNICIPIO = 2L;

    private static final Long DEFAULT_I_DPROVINCIA = 1L;
    private static final Long UPDATED_I_DPROVINCIA = 2L;

    private static final Long DEFAULT_I_DISLA = 1L;
    private static final Long UPDATED_I_DISLA = 2L;

    private static final String DEFAULT_L_OCAL = "AAAAAAAAAA";
    private static final String UPDATED_L_OCAL = "BBBBBBBBBB";

    private static final Long DEFAULT_I_DESTADOACTIVIDAD = 1L;
    private static final Long UPDATED_I_DESTADOACTIVIDAD = 2L;

    private static final String DEFAULT_C_NAE = "AAAAAAAAAA";
    private static final String UPDATED_C_NAE = "BBBBBBBBBB";

    private static final String DEFAULT_C_ODIGOMAP = "AAAAAAAAAA";
    private static final String UPDATED_C_ODIGOMAP = "BBBBBBBBBB";

    private static final String DEFAULT_C_ODIGOMEH = "AAAAAAAAAA";
    private static final String UPDATED_C_ODIGOMEH = "BBBBBBBBBB";

    @Autowired
    private ACCENTIDADDVTRepository aCCENTIDADDVTRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restACCENTIDADDVTMockMvc;

    private ACCENTIDADDVT aCCENTIDADDVT;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ACCENTIDADDVT createEntity(EntityManager em) {
        ACCENTIDADDVT aCCENTIDADDVT = new ACCENTIDADDVT()
            .nUMEROVERSION(DEFAULT_N_UMEROVERSION)
            .fECHAVERSION(DEFAULT_F_ECHAVERSION)
            .nIF(DEFAULT_N_IF)
            .eJERCICIO(DEFAULT_E_JERCICIO)
            .iDTIPO(DEFAULT_I_DTIPO)
            .iDTIPOREND(DEFAULT_I_DTIPOREND)
            .iDUNIP(DEFAULT_I_DUNIP)
            .iDMUNICIPIO(DEFAULT_I_DMUNICIPIO)
            .iDPROVINCIA(DEFAULT_I_DPROVINCIA)
            .iDISLA(DEFAULT_I_DISLA)
            .lOCAL(DEFAULT_L_OCAL)
            .iDESTADOACTIVIDAD(DEFAULT_I_DESTADOACTIVIDAD)
            .cNAE(DEFAULT_C_NAE)
            .cODIGOMAP(DEFAULT_C_ODIGOMAP)
            .cODIGOMEH(DEFAULT_C_ODIGOMEH);
        return aCCENTIDADDVT;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ACCENTIDADDVT createUpdatedEntity(EntityManager em) {
        ACCENTIDADDVT aCCENTIDADDVT = new ACCENTIDADDVT()
            .nUMEROVERSION(UPDATED_N_UMEROVERSION)
            .fECHAVERSION(UPDATED_F_ECHAVERSION)
            .nIF(UPDATED_N_IF)
            .eJERCICIO(UPDATED_E_JERCICIO)
            .iDTIPO(UPDATED_I_DTIPO)
            .iDTIPOREND(UPDATED_I_DTIPOREND)
            .iDUNIP(UPDATED_I_DUNIP)
            .iDMUNICIPIO(UPDATED_I_DMUNICIPIO)
            .iDPROVINCIA(UPDATED_I_DPROVINCIA)
            .iDISLA(UPDATED_I_DISLA)
            .lOCAL(UPDATED_L_OCAL)
            .iDESTADOACTIVIDAD(UPDATED_I_DESTADOACTIVIDAD)
            .cNAE(UPDATED_C_NAE)
            .cODIGOMAP(UPDATED_C_ODIGOMAP)
            .cODIGOMEH(UPDATED_C_ODIGOMEH);
        return aCCENTIDADDVT;
    }

    @BeforeEach
    public void initTest() {
        aCCENTIDADDVT = createEntity(em);
    }

    @Test
    @Transactional
    public void createACCENTIDADDVT() throws Exception {
        int databaseSizeBeforeCreate = aCCENTIDADDVTRepository.findAll().size();

        // Create the ACCENTIDADDVT
        restACCENTIDADDVTMockMvc.perform(post("/api/accentidaddvts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aCCENTIDADDVT)))
            .andExpect(status().isCreated());

        // Validate the ACCENTIDADDVT in the database
        List<ACCENTIDADDVT> aCCENTIDADDVTList = aCCENTIDADDVTRepository.findAll();
        assertThat(aCCENTIDADDVTList).hasSize(databaseSizeBeforeCreate + 1);
        ACCENTIDADDVT testACCENTIDADDVT = aCCENTIDADDVTList.get(aCCENTIDADDVTList.size() - 1);
        assertThat(testACCENTIDADDVT.getnUMEROVERSION()).isEqualTo(DEFAULT_N_UMEROVERSION);
        assertThat(testACCENTIDADDVT.getfECHAVERSION()).isEqualTo(DEFAULT_F_ECHAVERSION);
        assertThat(testACCENTIDADDVT.getnIF()).isEqualTo(DEFAULT_N_IF);
        assertThat(testACCENTIDADDVT.geteJERCICIO()).isEqualTo(DEFAULT_E_JERCICIO);
        assertThat(testACCENTIDADDVT.getiDTIPO()).isEqualTo(DEFAULT_I_DTIPO);
        assertThat(testACCENTIDADDVT.getiDTIPOREND()).isEqualTo(DEFAULT_I_DTIPOREND);
        assertThat(testACCENTIDADDVT.getiDUNIP()).isEqualTo(DEFAULT_I_DUNIP);
        assertThat(testACCENTIDADDVT.getiDMUNICIPIO()).isEqualTo(DEFAULT_I_DMUNICIPIO);
        assertThat(testACCENTIDADDVT.getiDPROVINCIA()).isEqualTo(DEFAULT_I_DPROVINCIA);
        assertThat(testACCENTIDADDVT.getiDISLA()).isEqualTo(DEFAULT_I_DISLA);
        assertThat(testACCENTIDADDVT.getlOCAL()).isEqualTo(DEFAULT_L_OCAL);
        assertThat(testACCENTIDADDVT.getiDESTADOACTIVIDAD()).isEqualTo(DEFAULT_I_DESTADOACTIVIDAD);
        assertThat(testACCENTIDADDVT.getcNAE()).isEqualTo(DEFAULT_C_NAE);
        assertThat(testACCENTIDADDVT.getcODIGOMAP()).isEqualTo(DEFAULT_C_ODIGOMAP);
        assertThat(testACCENTIDADDVT.getcODIGOMEH()).isEqualTo(DEFAULT_C_ODIGOMEH);
    }

    @Test
    @Transactional
    public void createACCENTIDADDVTWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = aCCENTIDADDVTRepository.findAll().size();

        // Create the ACCENTIDADDVT with an existing ID
        aCCENTIDADDVT.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restACCENTIDADDVTMockMvc.perform(post("/api/accentidaddvts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aCCENTIDADDVT)))
            .andExpect(status().isBadRequest());

        // Validate the ACCENTIDADDVT in the database
        List<ACCENTIDADDVT> aCCENTIDADDVTList = aCCENTIDADDVTRepository.findAll();
        assertThat(aCCENTIDADDVTList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllACCENTIDADDVTS() throws Exception {
        // Initialize the database
        aCCENTIDADDVTRepository.saveAndFlush(aCCENTIDADDVT);

        // Get all the aCCENTIDADDVTList
        restACCENTIDADDVTMockMvc.perform(get("/api/accentidaddvts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(aCCENTIDADDVT.getId().intValue())))
            .andExpect(jsonPath("$.[*].nUMEROVERSION").value(hasItem(DEFAULT_N_UMEROVERSION.intValue())))
            .andExpect(jsonPath("$.[*].fECHAVERSION").value(hasItem(DEFAULT_F_ECHAVERSION.intValue())))
            .andExpect(jsonPath("$.[*].nIF").value(hasItem(DEFAULT_N_IF)))
            .andExpect(jsonPath("$.[*].eJERCICIO").value(hasItem(DEFAULT_E_JERCICIO.intValue())))
            .andExpect(jsonPath("$.[*].iDTIPO").value(hasItem(DEFAULT_I_DTIPO)))
            .andExpect(jsonPath("$.[*].iDTIPOREND").value(hasItem(DEFAULT_I_DTIPOREND)))
            .andExpect(jsonPath("$.[*].iDUNIP").value(hasItem(DEFAULT_I_DUNIP.intValue())))
            .andExpect(jsonPath("$.[*].iDMUNICIPIO").value(hasItem(DEFAULT_I_DMUNICIPIO.intValue())))
            .andExpect(jsonPath("$.[*].iDPROVINCIA").value(hasItem(DEFAULT_I_DPROVINCIA.intValue())))
            .andExpect(jsonPath("$.[*].iDISLA").value(hasItem(DEFAULT_I_DISLA.intValue())))
            .andExpect(jsonPath("$.[*].lOCAL").value(hasItem(DEFAULT_L_OCAL)))
            .andExpect(jsonPath("$.[*].iDESTADOACTIVIDAD").value(hasItem(DEFAULT_I_DESTADOACTIVIDAD.intValue())))
            .andExpect(jsonPath("$.[*].cNAE").value(hasItem(DEFAULT_C_NAE)))
            .andExpect(jsonPath("$.[*].cODIGOMAP").value(hasItem(DEFAULT_C_ODIGOMAP)))
            .andExpect(jsonPath("$.[*].cODIGOMEH").value(hasItem(DEFAULT_C_ODIGOMEH)));
    }
    
    @Test
    @Transactional
    public void getACCENTIDADDVT() throws Exception {
        // Initialize the database
        aCCENTIDADDVTRepository.saveAndFlush(aCCENTIDADDVT);

        // Get the aCCENTIDADDVT
        restACCENTIDADDVTMockMvc.perform(get("/api/accentidaddvts/{id}", aCCENTIDADDVT.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(aCCENTIDADDVT.getId().intValue()))
            .andExpect(jsonPath("$.nUMEROVERSION").value(DEFAULT_N_UMEROVERSION.intValue()))
            .andExpect(jsonPath("$.fECHAVERSION").value(DEFAULT_F_ECHAVERSION.intValue()))
            .andExpect(jsonPath("$.nIF").value(DEFAULT_N_IF))
            .andExpect(jsonPath("$.eJERCICIO").value(DEFAULT_E_JERCICIO.intValue()))
            .andExpect(jsonPath("$.iDTIPO").value(DEFAULT_I_DTIPO))
            .andExpect(jsonPath("$.iDTIPOREND").value(DEFAULT_I_DTIPOREND))
            .andExpect(jsonPath("$.iDUNIP").value(DEFAULT_I_DUNIP.intValue()))
            .andExpect(jsonPath("$.iDMUNICIPIO").value(DEFAULT_I_DMUNICIPIO.intValue()))
            .andExpect(jsonPath("$.iDPROVINCIA").value(DEFAULT_I_DPROVINCIA.intValue()))
            .andExpect(jsonPath("$.iDISLA").value(DEFAULT_I_DISLA.intValue()))
            .andExpect(jsonPath("$.lOCAL").value(DEFAULT_L_OCAL))
            .andExpect(jsonPath("$.iDESTADOACTIVIDAD").value(DEFAULT_I_DESTADOACTIVIDAD.intValue()))
            .andExpect(jsonPath("$.cNAE").value(DEFAULT_C_NAE))
            .andExpect(jsonPath("$.cODIGOMAP").value(DEFAULT_C_ODIGOMAP))
            .andExpect(jsonPath("$.cODIGOMEH").value(DEFAULT_C_ODIGOMEH));
    }

    @Test
    @Transactional
    public void getNonExistingACCENTIDADDVT() throws Exception {
        // Get the aCCENTIDADDVT
        restACCENTIDADDVTMockMvc.perform(get("/api/accentidaddvts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateACCENTIDADDVT() throws Exception {
        // Initialize the database
        aCCENTIDADDVTRepository.saveAndFlush(aCCENTIDADDVT);

        int databaseSizeBeforeUpdate = aCCENTIDADDVTRepository.findAll().size();

        // Update the aCCENTIDADDVT
        ACCENTIDADDVT updatedACCENTIDADDVT = aCCENTIDADDVTRepository.findById(aCCENTIDADDVT.getId()).get();
        // Disconnect from session so that the updates on updatedACCENTIDADDVT are not directly saved in db
        em.detach(updatedACCENTIDADDVT);
        updatedACCENTIDADDVT
            .nUMEROVERSION(UPDATED_N_UMEROVERSION)
            .fECHAVERSION(UPDATED_F_ECHAVERSION)
            .nIF(UPDATED_N_IF)
            .eJERCICIO(UPDATED_E_JERCICIO)
            .iDTIPO(UPDATED_I_DTIPO)
            .iDTIPOREND(UPDATED_I_DTIPOREND)
            .iDUNIP(UPDATED_I_DUNIP)
            .iDMUNICIPIO(UPDATED_I_DMUNICIPIO)
            .iDPROVINCIA(UPDATED_I_DPROVINCIA)
            .iDISLA(UPDATED_I_DISLA)
            .lOCAL(UPDATED_L_OCAL)
            .iDESTADOACTIVIDAD(UPDATED_I_DESTADOACTIVIDAD)
            .cNAE(UPDATED_C_NAE)
            .cODIGOMAP(UPDATED_C_ODIGOMAP)
            .cODIGOMEH(UPDATED_C_ODIGOMEH);

        restACCENTIDADDVTMockMvc.perform(put("/api/accentidaddvts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedACCENTIDADDVT)))
            .andExpect(status().isOk());

        // Validate the ACCENTIDADDVT in the database
        List<ACCENTIDADDVT> aCCENTIDADDVTList = aCCENTIDADDVTRepository.findAll();
        assertThat(aCCENTIDADDVTList).hasSize(databaseSizeBeforeUpdate);
        ACCENTIDADDVT testACCENTIDADDVT = aCCENTIDADDVTList.get(aCCENTIDADDVTList.size() - 1);
        assertThat(testACCENTIDADDVT.getnUMEROVERSION()).isEqualTo(UPDATED_N_UMEROVERSION);
        assertThat(testACCENTIDADDVT.getfECHAVERSION()).isEqualTo(UPDATED_F_ECHAVERSION);
        assertThat(testACCENTIDADDVT.getnIF()).isEqualTo(UPDATED_N_IF);
        assertThat(testACCENTIDADDVT.geteJERCICIO()).isEqualTo(UPDATED_E_JERCICIO);
        assertThat(testACCENTIDADDVT.getiDTIPO()).isEqualTo(UPDATED_I_DTIPO);
        assertThat(testACCENTIDADDVT.getiDTIPOREND()).isEqualTo(UPDATED_I_DTIPOREND);
        assertThat(testACCENTIDADDVT.getiDUNIP()).isEqualTo(UPDATED_I_DUNIP);
        assertThat(testACCENTIDADDVT.getiDMUNICIPIO()).isEqualTo(UPDATED_I_DMUNICIPIO);
        assertThat(testACCENTIDADDVT.getiDPROVINCIA()).isEqualTo(UPDATED_I_DPROVINCIA);
        assertThat(testACCENTIDADDVT.getiDISLA()).isEqualTo(UPDATED_I_DISLA);
        assertThat(testACCENTIDADDVT.getlOCAL()).isEqualTo(UPDATED_L_OCAL);
        assertThat(testACCENTIDADDVT.getiDESTADOACTIVIDAD()).isEqualTo(UPDATED_I_DESTADOACTIVIDAD);
        assertThat(testACCENTIDADDVT.getcNAE()).isEqualTo(UPDATED_C_NAE);
        assertThat(testACCENTIDADDVT.getcODIGOMAP()).isEqualTo(UPDATED_C_ODIGOMAP);
        assertThat(testACCENTIDADDVT.getcODIGOMEH()).isEqualTo(UPDATED_C_ODIGOMEH);
    }

    @Test
    @Transactional
    public void updateNonExistingACCENTIDADDVT() throws Exception {
        int databaseSizeBeforeUpdate = aCCENTIDADDVTRepository.findAll().size();

        // Create the ACCENTIDADDVT

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restACCENTIDADDVTMockMvc.perform(put("/api/accentidaddvts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aCCENTIDADDVT)))
            .andExpect(status().isBadRequest());

        // Validate the ACCENTIDADDVT in the database
        List<ACCENTIDADDVT> aCCENTIDADDVTList = aCCENTIDADDVTRepository.findAll();
        assertThat(aCCENTIDADDVTList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteACCENTIDADDVT() throws Exception {
        // Initialize the database
        aCCENTIDADDVTRepository.saveAndFlush(aCCENTIDADDVT);

        int databaseSizeBeforeDelete = aCCENTIDADDVTRepository.findAll().size();

        // Delete the aCCENTIDADDVT
        restACCENTIDADDVTMockMvc.perform(delete("/api/accentidaddvts/{id}", aCCENTIDADDVT.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ACCENTIDADDVT> aCCENTIDADDVTList = aCCENTIDADDVTRepository.findAll();
        assertThat(aCCENTIDADDVTList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
