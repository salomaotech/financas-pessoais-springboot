package br.com.salomaotech.cadastro.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerPostTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPostAdiciona() throws Exception {

        /* testa o redirecionamento */
        this.mockMvc.perform(post("/adicionar").param("DataVencimento", "1989-09-15").param("valor", "100.00").param("historico", "Teste unitário cadastro")).andDo(print()).andExpect(status().is(302));

    }

    @Test
    public void testPostAdicionaTransferencia() throws Exception {

        /* testa o redirecionamento */
        this.mockMvc.perform(post("/adicionar/transferencia").param("conta", "000001").param("contaDestino", "000002").param("DataVencimento", "1989-09-15").param("valor", "100.00").param("historico", "Teste unitário transferência")).andDo(print()).andExpect(status().is(302));

    }

    @Test
    public void testPostAtualiza() throws Exception {

        /* testa o redirecionamento */
        this.mockMvc.perform(post("/adicionar/1").param("nome", "Teste Nome").param("cpf", "000.000.000-00")).andDo(print()).andExpect(status().is(302));

    }

    @Test
    public void testPostDeleta() throws Exception {

        /* testa o redirecionamento */
        this.mockMvc.perform(post("/deletar/1")).andDo(print()).andExpect(status().is(302));

    }

}
