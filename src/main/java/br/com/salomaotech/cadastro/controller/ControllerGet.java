package br.com.salomaotech.cadastro.controller;

import br.com.salomaotech.cadastro.model.cliente.CadastroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import br.com.salomaotech.cadastro.model.cliente.CadastroRepository;
import br.com.salomaotech.cadastro.model.sistema.FormataParaMoedaBrasileira;
import br.com.salomaotech.cadastro.model.sistema.Paginador;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.isNull;
import org.springframework.web.context.request.WebRequest;

/**
 * Lida com os endpoints do Get
 *
 * @author @salomaotech
 */
@Controller
public class ControllerGet {

    @Autowired
    CadastroRepository cadastroRepository;

    /* mapeia a rota para a página PaginaErro404 */
    @GetMapping("/pagina_erro404")
    public ModelAndView getErro404() {

        /* retorna a página */
        return new ModelAndView("PaginaErro404");

    }

    /* mapeia a rota para a página PaginaCadastro */
    @GetMapping("/pagina_cadastro")
    public ModelAndView getCadastra() {

        /* nova ModelAndView */
        ModelAndView model = new ModelAndView("PaginaCadastro");

        /* popula com os dados vazios */
        model.addObject("cadastro", new CadastroModel());

        /* popula contas, categorias */
        model.addObject("contas", this.cadastroRepository.getContas());
        model.addObject("categorias", this.cadastroRepository.getCategorias());

        /* retorna a página */
        return model;

    }

    /* Chama a página de cadastro de transferência */
    @GetMapping("/pagina_cadastro/transferencia")
    public ModelAndView getCadastraTransferencia() {

        /* nova ModelAndView */
        ModelAndView model = new ModelAndView("PaginaCadastroTransferencia");

        /* popula com os dados vazios */
        model.addObject("cadastro", new CadastroModel());

        /* popula contas, categorias */
        model.addObject("contas", this.cadastroRepository.getContas());
        model.addObject("categorias", this.cadastroRepository.getCategorias());

        /* retorna a página */
        return model;

    }

    /* mapeia a rota para a página PaginaCadastro */
    @GetMapping("/pagina_cadastro/{id}")
    public ModelAndView getAtualiza(@PathVariable("id") long id) {

        /* valida se o cadastro associado ao ID existe no banco de dados */
        if (this.cadastroRepository.findById(id).isPresent()) {

            /* nova ModelAndView */
            ModelAndView model = new ModelAndView("PaginaCadastro");

            /* cadastro model */
            CadastroModel cadastro = cadastroRepository.getById(id);

            /* popula com os dados encontrados no banco de dados */
            model.addObject("cadastro", cadastro);

            /* popula contas */
            model.addObject("contas", this.cadastroRepository.getContas());

            /* retorna a página com os dados já populados */
            return model;

        } else {

            /* retorna a página de erro */
            return new ModelAndView("PaginaErro404");

        }

    }

    /* mapeia a rota para a página PaginaDeleta */
    @GetMapping("/pagina_deleta/{id}")
    public ModelAndView getDeleta(@PathVariable("id") long id) {

        /* valida se o cadastro associado ao ID existe no banco de dados */
        if (this.cadastroRepository.findById(id).isPresent()) {

            /* nova ModelAndView */
            ModelAndView model = new ModelAndView("PaginaDeleta");

            /* popula com os dados encontrados no banco de dados */
            model.addObject("cadastro", cadastroRepository.getById(id));

            /* retorna a página com os dados já populados */
            return model;

        } else {

            /* retorna a página de erro */
            return new ModelAndView("PaginaErro404");

        }

    }

    /* mapeia a rota para a página PaginaResultados */
    @GetMapping({"/", "/pagina_resultados"})
    public ModelAndView getResultados(WebRequest request) {

        /* nova ModelAndView */
        ModelAndView model = new ModelAndView("PaginaResultados");

        /* paginador */
        Paginador paginador;

        /* informa se irá usar a pesquisa */
        boolean isPesquisa = false;

        /* resultados */
        List resultados;

        /* excessão */
        try {

            /* se o parametro for diferente de vazio e nulo então está pesquisando */
            isPesquisa = !request.getParameter("query").isEmpty() & !isNull(request.getParameter("query"));

        } catch (java.lang.NullPointerException ex) {

        }

        /* valida parametro */
        if (!isPesquisa) {

            /* não usa filtro de pesquisa */
            paginador = new Paginador(50, request.getParameter("pagina"), this.cadastroRepository.count());

            /* resultados */
            resultados = cadastroRepository.findAllList(paginador.getPaginadorOrdenadoAsc("historico"));

        } else {

            /* usa filtro de pesquisa */
            paginador = new Paginador(50, request.getParameter("pagina"), this.cadastroRepository.findByHistoricoCount(request.getParameter("query")));

            /* resultados */
            resultados = cadastroRepository.findByHistorico(request.getParameter("query"), paginador.getPaginadorOrdenadoAsc("historico"));

        }

        /* popula com os dados encontrados no banco de dados */
        model.addObject("cadastros", resultados);

        /* itera os resultados para formatar os dados antes de exibir na model */
        for (Iterator it = resultados.iterator(); it.hasNext();) {

            /* cast */
            CadastroModel cadastro = (CadastroModel) it.next();

            /* formata o valor para moeda brasileira R$ */
            cadastro.setValor(FormataParaMoedaBrasileira.cifrar(cadastro.getValor()));

        }

        /* popula com os dados encontrados no banco de dados */
        model.addObject("numero_paginas", paginador.getArrayListNumeroPaginas());
        model.addObject("pagina", request.getParameter("pagina"));
        model.addObject("query", request.getParameter("query"));

        /* retorna a página com os dados já populados */
        return model;

    }

}
