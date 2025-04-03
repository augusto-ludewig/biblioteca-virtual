package model.entities;

import java.util.LinkedList;

// Representa uma lista de livro

public class ListaLivros {
	
	private LinkedList<Livro> listaLivros;

	public ListaLivros() {
		this.listaLivros = new LinkedList<Livro>();
	}

	// Adiciona um livro à lista
	public void adicionarLivro(final Livro livro) {
		listaLivros.add(livro);
	}

	// Remove um livro da lista
	public void removerLivro(final Livro livro) {
		listaLivros.remove(livro);
	}

	// Lista todos os livros
	public void listarLivros() {
		for (Livro elemento : listaLivros) {
			 System.out.println(elemento);
			}
	}

}
