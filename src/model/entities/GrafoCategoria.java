package model.entities;

import java.util.ArrayList;
import java.util.LinkedList;

// Esse grafo faz o relacionamento dos livros através das suas categorias
public class GrafoCategoria {
    private ArrayList<Livro> nodes;
    private ArrayList<LinkedList<Livro>> conexoes;

    public GrafoCategoria(){
        nodes = new ArrayList<>();
        conexoes = new ArrayList<>();
    }

    public void adicionarNode(Livro nomeNode){
        nodes.add(nomeNode);
        conexoes.add(new LinkedList<>());
    }

    public void adicionarConexao(Livro origem, Livro destino){
        int indiceNodeOrigem = nodes.lastIndexOf(origem);
        int indiceNodeDestino = nodes.lastIndexOf(destino);

        if(indiceNodeOrigem != -1 && indiceNodeDestino != -1){
            conexoes.get(indiceNodeOrigem).add(destino);
            conexoes.get(indiceNodeDestino).add(origem);
        }

    }

    public void mostrarConexoes(){
        // Aqui mostramos as conexões
        for (int i =0; i < nodes.size(); i++){
            System.out.println("O livro chamado " + nodes.get(i).getTitulo() + " tem conexões com: ");

            LinkedList<Livro> conexoesNodeAtual = conexoes.get(i);

            // Aqui mostramos as conexões de cada nó
            for (int j = 0; j < conexoesNodeAtual.size(); j++){
                System.out.print(j+1 + ". " + conexoesNodeAtual.get(j).getTitulo());

                System.out.println();

            }

        }
    }
}
