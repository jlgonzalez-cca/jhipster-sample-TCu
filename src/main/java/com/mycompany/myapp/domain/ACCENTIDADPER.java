package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ACCENTIDADPER.
 */
@Entity
@Table(name = "accentidadper")
public class ACCENTIDADPER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "n_if")
    private String nIF;

    @Column(name = "n_ombre")
    private String nOMBRE;

    @Column(name = "a_pellido_1")
    private String aPELLIDO1;

    @Column(name = "a_pellido_2")
    private String aPELLIDO2;

    @Column(name = "e_mail")
    private String eMAIL;

    @ManyToOne
    @JsonIgnoreProperties("aCCENTIDADPERS")
    private ACCENTIDADDF iDENTIDADFK2;

    @ManyToOne
    @JsonIgnoreProperties("aCCENTIDADPERS")
    private DCCCARGOENT iDCARGOFK3;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnIF() {
        return nIF;
    }

    public ACCENTIDADPER nIF(String nIF) {
        this.nIF = nIF;
        return this;
    }

    public void setnIF(String nIF) {
        this.nIF = nIF;
    }

    public String getnOMBRE() {
        return nOMBRE;
    }

    public ACCENTIDADPER nOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
        return this;
    }

    public void setnOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
    }

    public String getaPELLIDO1() {
        return aPELLIDO1;
    }

    public ACCENTIDADPER aPELLIDO1(String aPELLIDO1) {
        this.aPELLIDO1 = aPELLIDO1;
        return this;
    }

    public void setaPELLIDO1(String aPELLIDO1) {
        this.aPELLIDO1 = aPELLIDO1;
    }

    public String getaPELLIDO2() {
        return aPELLIDO2;
    }

    public ACCENTIDADPER aPELLIDO2(String aPELLIDO2) {
        this.aPELLIDO2 = aPELLIDO2;
        return this;
    }

    public void setaPELLIDO2(String aPELLIDO2) {
        this.aPELLIDO2 = aPELLIDO2;
    }

    public String geteMAIL() {
        return eMAIL;
    }

    public ACCENTIDADPER eMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
        return this;
    }

    public void seteMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public ACCENTIDADDF getIDENTIDADFK2() {
        return iDENTIDADFK2;
    }

    public ACCENTIDADPER iDENTIDADFK2(ACCENTIDADDF aCCENTIDADDF) {
        this.iDENTIDADFK2 = aCCENTIDADDF;
        return this;
    }

    public void setIDENTIDADFK2(ACCENTIDADDF aCCENTIDADDF) {
        this.iDENTIDADFK2 = aCCENTIDADDF;
    }

    public DCCCARGOENT getIDCARGOFK3() {
        return iDCARGOFK3;
    }

    public ACCENTIDADPER iDCARGOFK3(DCCCARGOENT dCCCARGOENT) {
        this.iDCARGOFK3 = dCCCARGOENT;
        return this;
    }

    public void setIDCARGOFK3(DCCCARGOENT dCCCARGOENT) {
        this.iDCARGOFK3 = dCCCARGOENT;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ACCENTIDADPER)) {
            return false;
        }
        return id != null && id.equals(((ACCENTIDADPER) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ACCENTIDADPER{" +
            "id=" + getId() +
            ", nIF='" + getnIF() + "'" +
            ", nOMBRE='" + getnOMBRE() + "'" +
            ", aPELLIDO1='" + getaPELLIDO1() + "'" +
            ", aPELLIDO2='" + getaPELLIDO2() + "'" +
            ", eMAIL='" + geteMAIL() + "'" +
            "}";
    }
}
