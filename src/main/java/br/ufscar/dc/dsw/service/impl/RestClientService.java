package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.ufscar.dc.dsw.domain.Filme;
import br.ufscar.dc.dsw.domain.Produtora;
import br.ufscar.dc.dsw.service.spec.IRestClientService;

@Service
public class RestClientService implements IRestClientService {

    RestClient restClient = RestClient.create("http://localhost:8080"); // URL da sua API REST

    // Métodos para Filme

    @Override
    public Long createFilme(Filme filme) {
        ResponseEntity<Filme> res = restClient.post()
            .uri("/api/filmes")
            .contentType(MediaType.APPLICATION_JSON)
            .body(filme)
            .retrieve()
            .toEntity(Filme.class);

        Filme f = res.getBody();
        return f != null ? f.getId() : null;
    }

    @Override
    public List<Filme> getFilmes() {
        List<Filme> list = restClient.get()
            .uri("/api/filmes")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(new ParameterizedTypeReference<List<Filme>>() {});
        return list;
    }

    @Override
    public Filme getFilme(Long id) {
        Filme filme = restClient.get()
            .uri("/api/filmes/" + id)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(Filme.class);
        return filme;
    }

    @Override
    public boolean updateFilme(Filme filme) {
        ResponseEntity<Void> res = restClient.put()
            .uri("/api/filmes/" + filme.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .body(filme)
            .retrieve()
            .toBodilessEntity();

        return res.getStatusCode() == HttpStatus.OK;
    }

    @Override
    public boolean deleteFilme(Long id) {
        ResponseEntity<Void> res = restClient.delete()
            .uri("/api/filmes/" + id)
            .retrieve()
            .toBodilessEntity();

        return res.getStatusCode() == HttpStatus.NO_CONTENT;
    }

    // Métodos para Produtora

    @Override
    public Long createProdutora(Produtora produtora) {
        ResponseEntity<Produtora> res = restClient.post()
            .uri("/api/produtoras")
            .contentType(MediaType.APPLICATION_JSON)
            .body(produtora)
            .retrieve()
            .toEntity(Produtora.class);

        Produtora p = res.getBody();
        return p != null ? p.getId() : null;
    }

    @Override
    public List<Produtora> getProdutoras() {
        List<Produtora> list = restClient.get()
            .uri("/api/produtoras")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(new ParameterizedTypeReference<List<Produtora>>() {});
        return list;
    }

    @Override
    public Produtora getProdutora(Long id) {
        Produtora produtora = restClient.get()
            .uri("/api/produtoras/" + id)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(Produtora.class);
        return produtora;
    }

    @Override
    public boolean updateProdutora(Produtora produtora) {
        ResponseEntity<Void> res = restClient.put()
            .uri("/api/produtoras/" + produtora.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .body(produtora)
            .retrieve()
            .toBodilessEntity();

        return res.getStatusCode() == HttpStatus.OK;
    }

    @Override
    public boolean deleteProdutora(Long id) {
        ResponseEntity<Void> res = restClient.delete()
            .uri("/api/produtoras/" + id)
            .retrieve()
            .toBodilessEntity();

        return res.getStatusCode() == HttpStatus.NO_CONTENT;
    }
}
