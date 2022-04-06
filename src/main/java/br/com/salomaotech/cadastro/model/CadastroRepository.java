package br.com.salomaotech.cadastro.model;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel, Long> {

    /**
     * Pesquisa por descricao
     *
     * @param descricao Nome
     * @param pageable Paginador
     * @return List com CadastroModel
     */
    @Query(value = "SELECT * FROM cadastro_model WHERE descricao LIKE %?%", nativeQuery = true)
    List<CadastroModel> findByDescricao(String descricao, Pageable pageable);

    /**
     * Retorna a quantidade de itens em uma pesquisa por descricao
     *
     * @param descricao Nome
     * @return Long com a quantidade de itens
     */
    @Query(value = "SELECT COUNT(id) FROM cadastro_model WHERE descricao LIKE %?%", nativeQuery = true)
    long findByDescricaoCount(String descricao);

}
