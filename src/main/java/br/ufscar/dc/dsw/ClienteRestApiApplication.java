package br.ufscar.dc.dsw;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.domain.Filme;
import br.ufscar.dc.dsw.domain.Produtora;
import br.ufscar.dc.dsw.service.spec.IRestClientService;

@SpringBootApplication
public class ClienteRestApiApplication {

    private static final Logger log = LoggerFactory.getLogger(ClienteRestApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ClienteRestApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(IRestClientService service) throws Exception {
        return args -> {
            
            // Exemplo de Produtora
            Produtora produtora = new Produtora();
            produtora.setCNPJ("98.737.787/8601-99");  // Um CNPJ válido com 18 caracteres
            produtora.setNome("Produtora Teste Unica");
            
            log.info("-----------------------------------");
            log.info("Criando nova Produtora");
            log.info("-----------------------------------");

            // Salvando a Produtora
            Long produtoraId = service.createProdutora(produtora);
            log.info("Produtora criada com ID: " + produtoraId);

            // Setando o ID da produtora após salvar
            produtora.setId(produtoraId);

            log.info("-----------------------------------");
            log.info("Listando todas as Produtoras");
            log.info("-----------------------------------");
            List<Produtora> produtoras = service.getProdutoras();
            for (Produtora p : produtoras) {
                log.info(p.toString());
            }

            log.info("-----------------------------------");
            log.info("Numero de Produtoras: " + produtoras.size());
            log.info("-----------------------------------");

            // Exemplo de Filme
            Filme filme = new Filme();
            filme.setTitulo("Filme Teste");
            filme.setDiretor("Diretor Teste");
            filme.setAno(2023);
            filme.setPreco(new BigDecimal("29.99"));
            filme.setProdutora(produtora); // Associando a produtora persistida

            log.info("-----------------------------------");
            log.info("Criando novo Filme");
            log.info("-----------------------------------");
            Long filmeId = service.createFilme(filme);
            log.info("Filme criado com ID: " + filmeId);

            log.info("-----------------------------------");
            log.info("Listando todos os Filmes");
            log.info("-----------------------------------");
            List<Filme> filmes = service.getFilmes();
            for (Filme f : filmes) {
                log.info(f.toString());
            }

            log.info("-----------------------------------");
            log.info("Numero de Filmes: " + filmes.size());
            log.info("-----------------------------------");

            log.info("-----------------------------------");
            log.info("Buscando Filme pelo ID (" + filmeId + ")");
            log.info("-----------------------------------");
            filme = service.getFilme(filmeId);
            log.info(filme.toString());

            log.info("-----------------------------------");
            log.info("Atualizando Filme (" + filmeId + ")");
            log.info("-----------------------------------");
            filme.setTitulo("Filme Teste Atualizado");
            boolean ok = service.updateFilme(filme);
            log.info("Filme atualizado: " + ok);

            log.info("-----------------------------------");
            log.info("Buscando Filme atualizado (" + filmeId + ")");
            log.info("-----------------------------------");
            filme = service.getFilme(filmeId);
            log.info(filme.toString());

            log.info("-----------------------------------");
            log.info("Removendo Filme (" + filmeId + ")");
            log.info("-----------------------------------");
            ok = service.deleteFilme(filmeId);
            log.info("Filme removido: " + ok);

            log.info("-----------------------------------");
            log.info("Listando todos os Filmes novamente");
            log.info("-----------------------------------");
            filmes = service.getFilmes();
            log.info("Numero de Filmes: " + filmes.size());
            log.info("-----------------------------------");

            // Removendo todos os filmes associados à produtora antes de remover a produtora
            log.info("-----------------------------------");
            log.info("Removendo todos os filmes da Produtora (" + produtoraId + ")");
            log.info("-----------------------------------");
            filmes = service.getFilmes();
            for (Filme f : filmes) {
                if (f.getProdutora().getId().equals(produtoraId)) {
                    log.info("Removendo filme: " + f.getTitulo());
                    ok = service.deleteFilme(f.getId());
                    log.info("Filme removido: " + ok);
                }
            }

            log.info("-----------------------------------");
            log.info("Removendo Produtora (" + produtoraId + ")");
            log.info("-----------------------------------");
            ok = service.deleteProdutora(produtoraId);
            log.info("Produtora removida: " + ok);

            log.info("-----------------------------------");
            log.info("Listando todas as Produtoras novamente");
            log.info("-----------------------------------");
            produtoras = service.getProdutoras();
            log.info("Numero de Produtoras: " + produtoras.size());
            log.info("-----------------------------------");
        };
    }
}
