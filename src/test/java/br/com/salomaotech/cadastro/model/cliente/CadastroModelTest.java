package br.com.salomaotech.cadastro.model.cliente;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CadastroModelTest {

    @Test
    public void testGetId() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setId(0L);
        assertEquals(true, cadastroModel.getId() == 0L);

    }

    @Test
    public void testSetId() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setId(0L);
        assertEquals(true, cadastroModel.getId() == 0L);

    }

    @Test
    public void testGetDataRegistro() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setDataRegistro(LocalDate.now());
        assertEquals(true, LocalDate.now().equals(cadastroModel.getDataRegistro()));

    }

    @Test
    public void testSetDataRegistro() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setDataRegistro(LocalDate.now());
        assertEquals(true, LocalDate.now().equals(cadastroModel.getDataRegistro()));

    }

    @Test
    public void testGetDataVencimento() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setDataVencimento(LocalDate.now());
        assertEquals(true, LocalDate.now().equals(cadastroModel.getDataVencimento()));

    }

    @Test
    public void testSetDataVencimento() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setDataVencimento(LocalDate.now());
        assertEquals(true, LocalDate.now().equals(cadastroModel.getDataVencimento()));

    }

    @Test
    public void testGetOperacao() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setOperacao("saida");
        assertEquals(true, cadastroModel.getOperacao().equals("saida"));

    }

    @Test
    public void testSetOperacao() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setOperacao("saida");
        assertEquals(true, cadastroModel.getOperacao().equals("saida"));

    }

    @Test
    public void testGetHistorico() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setHistorico("Teste");
        assertEquals(true, cadastroModel.getHistorico().equals("Teste"));

    }

    @Test
    public void testSetHistorico() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setHistorico("Teste");
        assertEquals(true, cadastroModel.getHistorico().equals("Teste"));

    }

    @Test
    public void testGetCategoria() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setCategoria("Contas");
        assertEquals(true, cadastroModel.getCategoria().equals("Contas"));

    }

    @Test
    public void testSetCategoria() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setCategoria("Contas");
        assertEquals(true, cadastroModel.getCategoria().equals("Contas"));

    }

    @Test
    public void testGetConta() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setConta("000001");
        assertEquals(true, cadastroModel.getConta().equals("000001"));

    }

    @Test
    public void testSetConta() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setConta("000001");
        assertEquals(true, cadastroModel.getConta().equals("000001"));

    }

    @Test
    public void testGetValor() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setValor("1.99");
        assertEquals(true, cadastroModel.getValor().equals("1.99"));

    }

    @Test
    public void testSetValor() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setValor("1.99");
        assertEquals(true, cadastroModel.getValor().equals("1.99"));

    }

}
