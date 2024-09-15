package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Filme;
import br.ufscar.dc.dsw.domain.Produtora;

public interface IRestClientService {

    // Métodos para Filme

    Long createFilme(Filme filme);

    List<Filme> getFilmes();

    Filme getFilme(Long id);

    boolean updateFilme(Filme filme);

    boolean deleteFilme(Long id);

    // Métodos para Produtora

    Long createProdutora(Produtora produtora);

    List<Produtora> getProdutoras();

    Produtora getProdutora(Long id);

    boolean updateProdutora(Produtora produtora);

    boolean deleteProdutora(Long id);
}
