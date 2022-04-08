package br.com.salomaotech.cadastro.model.cliente;

import java.math.BigDecimal;
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
     * Seleciona todos os registros
     *
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model", nativeQuery = true)
    List<CadastroModel> findAllList(Pageable pageable);

    /**
     * Soma todos os valores da operação
     *
     * @param operacao
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model WHERE operacao=?", nativeQuery = true)
    BigDecimal findAllSaldo(String operacao);

    /**
     * Seleciona entre data inicial e final
     *
     * @param inicio
     * @param fim
     * @param conta
     * @param categoria
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model WHERE data_vencimento BETWEEN ? AND ? AND (conta LIKE %? AND categoria LIKE %?)", nativeQuery = true)
    List<CadastroModel> findByHistorico(String inicio, String fim, String conta, String categoria, Pageable pageable);

    /**
     * Conta o número de registros entre data inicial e final
     *
     * @param inicio
     * @param fim
     * @param conta
     * @param categoria
     * @return
     */
    @Query(value = "SELECT COUNT(id) FROM cadastro_model WHERE data_vencimento BETWEEN ? AND ? AND (conta LIKE %? AND categoria LIKE %?)", nativeQuery = true)
    long findByHistoricoCount(String inicio, String fim, String conta, String categoria);

    /**
     * Soma os valores entre data inicial e final
     *
     * @param inicio
     * @param fim
     * @param conta
     * @param categoria
     * @param operacao
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model WHERE data_vencimento BETWEEN ? AND ? AND (conta LIKE %? AND categoria LIKE %?) AND operacao=?", nativeQuery = true)
    BigDecimal findByHistoricoSaldo(String inicio, String fim, String conta, String categoria, String operacao);

    /**
     * Lista todas as contas
     *
     * @return
     */
    @Query(value = "SELECT DISTINCT CONTA FROM cadastro_model CONTA", nativeQuery = true)
    List<String> getContas();

    /**
     * Lista todas as categorias
     *
     * @return
     */
    @Query(value = "SELECT DISTINCT CATEGORIA FROM cadastro_model CATEGORIA", nativeQuery = true)
    List<String> getCategorias();

}
