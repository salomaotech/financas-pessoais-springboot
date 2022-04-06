package br.com.salomaotech.cadastro.model;

import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class Paginador {

    private final int numeroItensPorPagina;
    private final int numeroPaginaAtual;
    private final long numeroRegistrosTabela;

    /**
     * Construtor
     *
     * @param numeroItensPorPagina Número de itens por página
     * @param numeroPaginaAtual Número da página atual
     * @param numeroRegistrosTabela Número de registros da tabela
     */
    public Paginador(int numeroItensPorPagina, String numeroPaginaAtual, long numeroRegistrosTabela) {

        int pgAtual;

        /* excessão */
        try {

            pgAtual = Integer.parseInt(numeroPaginaAtual);

        } catch (java.lang.NumberFormatException ex) {

            pgAtual = 0;

        }

        /* popula */
        this.numeroItensPorPagina = numeroItensPorPagina;
        this.numeroRegistrosTabela = numeroRegistrosTabela;
        this.numeroPaginaAtual = pgAtual;

    }

    /**
     * Retorna o paginador
     *
     * @return Página atual
     */
    public Pageable getPaginador() {

        return PageRequest.of(this.numeroPaginaAtual, this.numeroItensPorPagina);

    }

    /**
     * Retorna o paginador ordenado por Direction.ASC
     *
     * @param nomeColuna NOome da coluna
     * @return Página atual
     */
    public Pageable getPaginadorOrdenadoAsc(String nomeColuna) {

        return PageRequest.of(this.numeroPaginaAtual, this.numeroItensPorPagina, Sort.by(Direction.ASC, nomeColuna));

    }

    /**
     * Retorna o paginador ordenado por Direction.DESC
     *
     * @param nomeColuna NOome da coluna
     * @return Página atual
     */
    public Pageable getPaginadorOrdenadoDesc(String nomeColuna) {

        return PageRequest.of(this.numeroPaginaAtual, this.numeroItensPorPagina, Sort.by(Direction.DESC, nomeColuna));

    }

    /**
     * Retorna o ArrayList com o número de páginas
     *
     * @return Número de páginas
     */
    public ArrayList getArrayListNumeroPaginas() {

        /* número de páginas calculadas */
        int numeroPaginasCalculado = Math.round(this.numeroRegistrosTabela / this.numeroItensPorPagina);

        /* ArrayList com o número de páginas calculadas */
        ArrayList arrayListPaginas = new ArrayList();

        /* itera */
        for (int i = 0; i <= numeroPaginasCalculado; i++) {

            /* popula array */
            arrayListPaginas.add(i);

        }

        /* retorno */
        return arrayListPaginas;

    }

}
