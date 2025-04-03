package model.entities;

import java.util.LinkedList;

public class listaLivros {
	
	public LinkedList<Livro> listaLivros;
	
	public listaLivros() {
		this.listaLivros = new LinkedList<Livro>();
	}
	
	public void adicionarLivro(Livro livro) {
		listaLivros.add(livro);
	}
	
	public void removerLivro(Livro livro) {
		listaLivros.remove(livro);
	}
	
	public void listarLivros() {
		for (Livro elemento : listaLivros) {
			 System.out.println(elemento);
			}
	}

}
