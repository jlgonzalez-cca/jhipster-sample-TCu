package com.mycompany.myapp.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * not an ignored comment
 */
@ApiModel(description = "not an ignored comment")
@Entity
@Table(name = "dcccargoent")
public class DCCCARGOENT implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "i_dcargo")
    private Long iDCARGO;

    @Column(name = "n_ombre")
    private String nOMBRE;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getiDCARGO() {
        return iDCARGO;
    }

    public DCCCARGOENT iDCARGO(Long iDCARGO) {
        this.iDCARGO = iDCARGO;
        return this;
    }

    public void setiDCARGO(Long iDCARGO) {
        this.iDCARGO = iDCARGO;
    }

    public String getnOMBRE() {
        return nOMBRE;
    }

    public DCCCARGOENT nOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
        return this;
    }

    public void setnOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DCCCARGOENT)) {
            return false;
        }
        return id != null && id.equals(((DCCCARGOENT) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DCCCARGOENT{" +
            "id=" + getId() +
            ", iDCARGO=" + getiDCARGO() +
            ", nOMBRE='" + getnOMBRE() + "'" +
            "}";
    }
}
