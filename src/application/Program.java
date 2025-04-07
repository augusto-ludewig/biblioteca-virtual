package application;

import java.util.Scanner;
import model.entities.ListaLivros;
import model.entities.Livro;

public final class Program {
  private Program() {}; // Construtor privado

  /**
   * Método principal de execução.
   * 
   * @param args Argumentos da linha de comando
   */
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Olá! Seja bem vindo(a) à sua Biblioteca Virtual!");
    System.out.println("Primeiramente vamos criar um livro.");
    System.out.print("Digite o nome do livro: ");
    String nomeLivro = sc.nextLine();
    System.out.print("Digite o nome do autor: ");
    String autorLivro = sc.nextLine();
    System.out.print("Digite o ano de publicação: ");
    Integer anoPublicacao = sc.nextInt();

    Livro livro = new Livro(nomeLivro, autorLivro, anoPublicacao);

    System.out.print("Deseja adicioná-lo na lista de desejos? (s/n): ");
    String input = sc.next();

    char lista = input.charAt(0);

    if (lista == 's') {

      ListaLivros listaLivros = new ListaLivros();
      listaLivros.adicionarLivro(livro);
      listaLivros.listarLivros();

    } else if (lista == 'n') {
      System.out.println("O livro não foi adicionado à lista.");
    } else {
      System.out.println("Valor inválido! O livro não foi adicionado à lista.");
    }
    
    sc.close();
  }
}
