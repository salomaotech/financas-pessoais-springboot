package br.com.salomaotech.cadastro.model.sistema;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FormataNumeroTest {

    @Test
    public void testFormatarNumero() {

        /* testa as conversões */
        assertEquals(true, FormataNumero.formatarNumero("0").equals(new BigDecimal("0")));
        assertEquals(true, FormataNumero.formatarNumero("abc").equals(new BigDecimal("0")));
        assertEquals(true, FormataNumero.formatarNumero("1,99").equals(new BigDecimal("1.99")));
        assertEquals(true, FormataNumero.formatarNumero("1.999,36").equals(new BigDecimal("1999.36")));
        assertEquals(false, FormataNumero.formatarNumero("1.999.999.36").equals(new BigDecimal("1999999.36")));

    }

    @Test
    public void testFormatarNumeroParaBr() {

        /* numeros positivos */
        assertEquals(true, FormataNumero.formatarNumeroParaBr("1").equals("R$ 1,00"));
        assertEquals(true, FormataNumero.formatarNumeroParaBr("10").equals("R$ 10,00"));
        assertEquals(true, FormataNumero.formatarNumeroParaBr("100").equals("R$ 100,00"));
        assertEquals(true, FormataNumero.formatarNumeroParaBr("10000").equals("R$ 10.000,00"));
        assertEquals(true, FormataNumero.formatarNumeroParaBr("1000000").equals("R$ 1.000.000,00"));

        /* numeros negativos */
        assertEquals(true, FormataNumero.formatarNumeroParaBr("-200").equals("-R$ 200,00"));

        /* não númericos */
        assertEquals(true, FormataNumero.formatarNumeroParaBr("abc").equals("R$ 0,00"));

    }

}
