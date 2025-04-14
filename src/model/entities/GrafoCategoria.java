package model.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrafoCategoria {
    // Estrutura do grafo: Mapa de Livro para seus vizinhos (recomendações)
    private final Map<Livro, Set<Livro>> grafo;

    public GrafoCategoria() {
        this.grafo = new HashMap<>();
    }

    // Adiciona um livro ao grafo e conecta automaticamente por gênero
    public void adicionarNode(Livro livro) {
        if (!grafo.containsKey(livro)) {
            grafo.put(livro, new HashSet<>());

            // Conecta com livros do mesmo gênero
            for (Livro existente : grafo.keySet()) {
                if (existente.getGeneroLiterario().equalsIgnoreCase(livro.getGeneroLiterario())) {
                    adicionarConexao(existente, livro);
                }
            }
        }
    }

    // Cria conexão bidirecional entre dois livros
    public void adicionarConexao(Livro livro1, Livro livro2) {
        grafo.get(livro1).add(livro2);
        grafo.get(livro2).add(livro1);
    }

    // Mostra todas as conexões do grafo
    public void mostrarConexoes() {
        for (Map.Entry<Livro, Set<Livro>> entry : grafo.entrySet()) {
            System.out.println("\nLivro: " + entry.getKey().getTitulo());
            System.out.println("Recomendações (" + entry.getValue().size() + "):");
            for (Livro recomendacao : entry.getValue()) {
                System.out.println("  ▸ " + recomendacao.getTitulo() + " (" + recomendacao.getGeneroLiterario() + ")");
            }
        }
    }

    // Método para obter recomendações baseadas no gênero
    public Set<Livro> getRecomendacoes(Livro livro) {
        return grafo.getOrDefault(livro, new HashSet<>());
    }
}