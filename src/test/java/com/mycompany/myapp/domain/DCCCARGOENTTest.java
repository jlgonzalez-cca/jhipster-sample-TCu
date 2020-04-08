package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class DCCCARGOENTTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DCCCARGOENT.class);
        DCCCARGOENT dCCCARGOENT1 = new DCCCARGOENT();
        dCCCARGOENT1.setId(1L);
        DCCCARGOENT dCCCARGOENT2 = new DCCCARGOENT();
        dCCCARGOENT2.setId(dCCCARGOENT1.getId());
        assertThat(dCCCARGOENT1).isEqualTo(dCCCARGOENT2);
        dCCCARGOENT2.setId(2L);
        assertThat(dCCCARGOENT1).isNotEqualTo(dCCCARGOENT2);
        dCCCARGOENT1.setId(null);
        assertThat(dCCCARGOENT1).isNotEqualTo(dCCCARGOENT2);
    }
}
