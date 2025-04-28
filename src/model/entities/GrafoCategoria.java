package model.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Representa um grafo de recomendações de livros baseado em gênero literário.
 * <p>
 * Cada livro é um nó no grafo, e conexões bidirecionais são estabelecidas entre
 * livros do mesmo gênero.
 * </p>
 */
public final class GrafoCategoria {

    /**
     * Estrutura do grafo: mapa de cada livro para seu conjunto de recomendações.
     */
    private final Map<Livro, Set<Livro>> grafo;

    /**
     * Construtor padrão que inicializa o grafo vazio.
     */
    public GrafoCategoria() {
        this.grafo = new HashMap<>();
    }

    /**
     * Adiciona um {@code Livro} ao grafo e cria automaticamente conexões
     * com livros existentes do mesmo gênero.
     *
     * @param livro o livro a ser adicionado ao grafo
     */
    public void adicionarNode(final Livro livro) {
        if (!grafo.containsKey(livro)) {
            grafo.put(livro, new HashSet<>());
            // Conecta com livros do mesmo gênero
            for (Livro existente : grafo.keySet()) {
                if (existente.getGeneroLiterario()
                        .equalsIgnoreCase(livro.getGeneroLiterario())) {
                    adicionarConexao(existente, livro);
                }
            }
        }
    }

    /**
     * Cria uma conexão bidirecional entre dois livros no grafo.
     *
     * @param livro1 o primeiro livro da conexão
     * @param livro2 o segundo livro da conexão
     */
    public void adicionarConexao(
            final Livro livro1,
            final Livro livro2
    ) {
        grafo.get(livro1).add(livro2);
        grafo.get(livro2).add(livro1);
    }

    /**
     * Exibe todas as conexões de livros no grafo no console.
     */
    public void mostrarConexoes() {
        for (Map.Entry<Livro, Set<Livro>> entry : grafo.entrySet()) {
            System.out.println();
            System.out.println("Livro: " + entry.getKey().getTitulo());
            System.out.println(
                    "Recomendações (" + entry.getValue().size() + "):"
            );
            for (Livro recomendacao : entry.getValue()) {
                System.out.println(
                        "  ▸ "
                                + recomendacao.getTitulo()
                                + " ("
                                + recomendacao.getGeneroLiterario()
                                + ")"
                );
            }
        }
    }

    /**
     * Obtém as recomendações para um determinado livro.
     *
     * @param livro o livro cujas recomendações serão retornadas
     * @return conjunto de livros recomendados, vazio se não houver conexões
     */
    public Set<Livro> getRecomendacoes(final Livro livro) {
        return grafo.getOrDefault(livro, new HashSet<>());
    }
}
