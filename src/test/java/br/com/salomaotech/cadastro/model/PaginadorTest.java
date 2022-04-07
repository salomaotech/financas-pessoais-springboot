package br.com.salomaotech.cadastro.model;

import br.com.salomaotech.cadastro.model.sistema.Paginador;
import static java.util.Objects.isNull;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaginadorTest {

    @Test
    public void testGetPaginador() {

        /* propriedades */
        int numeroItensPorPagina = 10;
        String numeroPaginaAtual = "0";
        long numeroRegistrosTabela = 1000;

        /* paginador */
        Paginador paginador = new Paginador(numeroItensPorPagina, numeroPaginaAtual, numeroRegistrosTabela);

        /* testa se não é nulo */
        assertEquals(true, !isNull(paginador.getPaginador()));

    }

    @Test
    public void getPaginadorOrdenadoAsc() {

        /* propriedades */
        int numeroItensPorPagina = 10;
        String numeroPaginaAtual = "0";
        long numeroRegistrosTabela = 1000;

        /* paginador */
        Paginador paginador = new Paginador(numeroItensPorPagina, numeroPaginaAtual, numeroRegistrosTabela);

        /* esperado e testado */
        String esperado = "nome_coluna: ASC";
        String testado = paginador.getPaginadorOrdenadoAsc("nome_coluna").getSort().toString();

        /* testa se a ordenação */
        assertEquals(esperado, testado);

    }

    @Test
    public void getPaginadorOrdenadoDesc() {

        /* propriedades */
        int numeroItensPorPagina = 10;
        String numeroPaginaAtual = "0";
        long numeroRegistrosTabela = 1000;

        /* paginador */
        Paginador paginador = new Paginador(numeroItensPorPagina, numeroPaginaAtual, numeroRegistrosTabela);

        /* esperado e testado */
        String esperado = "nome_coluna: DESC";
        String testado = paginador.getPaginadorOrdenadoDesc("nome_coluna").getSort().toString();

        /* testa se a ordenação */
        assertEquals(esperado, testado);

    }

    @Test
    public void testGetArrayListNumeroPaginas() {

        /* propriedades */
        int numeroItensPorPagina = 10;
        String numeroPaginaAtual = "0";
        long numeroRegistrosTabela = 1000;
        int numeroPaginasEsperado = 100;

        /* paginador */
        Paginador paginador = new Paginador(numeroItensPorPagina, numeroPaginaAtual, numeroRegistrosTabela);

        /* testa se o calculo para gerar o número de páginas está correto */
        assertEquals(numeroPaginasEsperado, paginador.getArrayListNumeroPaginas().size() - 1);

    }

}
