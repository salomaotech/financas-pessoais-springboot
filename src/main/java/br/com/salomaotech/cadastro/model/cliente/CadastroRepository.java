package br.com.salomaotech.cadastro.model.cliente;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositório do Spring
 *
 * @author @salomaotech
 */
@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel, Long> {

    /**
     * Lista todos os registros
     *
     * @param pageable Paginador
     * @return List com CadastroModel
     */
    @Query(value = "SELECT * FROM cadastro_model", nativeQuery = true)
    List<CadastroModel> findAllList(Pageable pageable);

    /**
     * Pesquisa por historico
     *
     * @param historico Histórico
     * @param pageable Paginador
     * @return List com CadastroModel
     */
    @Query(value = "SELECT * FROM cadastro_model WHERE historico LIKE %?%", nativeQuery = true)
    List<CadastroModel> findByHistorico(String historico, Pageable pageable);

    /**
     * Retorna a quantidade de itens em uma pesquisa por historico
     *
     * @param historico Histórico
     * @return Long com a quantidade de itens
     */
    @Query(value = "SELECT COUNT(id) FROM cadastro_model WHERE historico LIKE %?%", nativeQuery = true)
    long findByHistoricoCount(String historico);

    /**
     * Retorna as contas disponiveis
     *
     * @return
     */
    @Query(value = "SELECT DISTINCT CONTA FROM cadastro_model CONTA", nativeQuery = true)
    List<String> getContas();

    /**
     * Retorna as categorias disponiveis
     *
     * @return
     */
    @Query(value = "SELECT DISTINCT CATEGORIA FROM cadastro_model CATEGORIA", nativeQuery = true)
    List<String> getCategorias();

}