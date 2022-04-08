package br.com.salomaotech.cadastro.model.cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CadastroModelTest {

    @Test
    public void testGetId() {

        CadastroModel instance = new CadastroModel();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetId() {

        long id = 0L;
        CadastroModel instance = new CadastroModel();
        instance.setId(id);

    }

    @Test
    public void testGetDataRegistro() {

        CadastroModel instance = new CadastroModel();
        LocalDate expResult = null;
        LocalDate result = instance.getDataRegistro();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetDataRegistro() {

        LocalDate dataRegistro = null;
        CadastroModel instance = new CadastroModel();
        instance.setDataRegistro(dataRegistro);

    }

    @Test
    public void testGetDataVencimento() {

        CadastroModel instance = new CadastroModel();
        LocalDate expResult = null;
        LocalDate result = instance.getDataVencimento();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetDataVencimento() {

        LocalDate dataVencimento = null;
        CadastroModel instance = new CadastroModel();
        instance.setDataVencimento(dataVencimento);

    }

    @Test
    public void testGetOperacao() {

        CadastroModel instance = new CadastroModel();
        String expResult = null;
        String result = instance.getOperacao();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetOperacao() {

        String operacao = null;
        CadastroModel instance = new CadastroModel();
        instance.setOperacao(operacao);

    }

    @Test
    public void testGetHistorico() {

        CadastroModel instance = new CadastroModel();
        String expResult = null;
        String result = instance.getHistorico();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetHistorico() {

        String historico = null;
        CadastroModel instance = new CadastroModel();
        instance.setHistorico(historico);

    }

    @Test
    public void testGetCategoria() {

        CadastroModel instance = new CadastroModel();
        String expResult = null;
        String result = instance.getCategoria();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetCategoria() {

        String categoria = null;
        CadastroModel instance = new CadastroModel();
        instance.setCategoria(categoria);

    }

    @Test
    public void testGetConta() {

        CadastroModel instance = new CadastroModel();
        String expResult = null;
        String result = instance.getConta();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetConta() {

        String conta = null;
        CadastroModel instance = new CadastroModel();
        instance.setConta(conta);

    }

    @Test
    public void testGetValor() {

        CadastroModel instance = new CadastroModel();
        String expResult = null;
        String result = instance.getValor();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetValor() {

        String valor = null;
        CadastroModel instance = new CadastroModel();
        instance.setValor(valor);

    }

}
