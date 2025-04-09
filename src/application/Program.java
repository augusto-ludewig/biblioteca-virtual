package application;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import model.entities.ListaLivros;
import model.entities.Livro;

public final class Program {
  private Program() {} // Construtor privado

  /**
   * Método principal de execução.
   *
   * @param args Argumentos da linha de comando
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Olá! Seja bem vindo(a) à sua Biblioteca Virtual!");

    System.out.println("Selecione a opção: ");
    System.out.println("a) Adicionar um livro");
    System.out.println("b) Listar livros disponíveis");
    System.out.println("c) Lista de desejos");
    System.out.println("d) Adicionar um livro\n");

    System.out.print("Seleção: ");
    char selecao = sc.nextLine().charAt(0);

    System.out.print("Digite o nome do livro: ");
    String nomeLivro = sc.nextLine();

    System.out.print("Digite o nome do autor: ");
    String autorLivro = sc.nextLine();

    System.out.print("Digite o ano de publicação: ");
    int anoPublicacao = sc.nextInt();

    System.out.print("Digite a quantidade disponível em estoque: ");
    int disponibilidade = sc.nextInt();
    sc = new Scanner(System.in);

    Livro livro = new Livro(nomeLivro, autorLivro, anoPublicacao, disponibilidade);
    Queue<Livro> filaEspera = new PriorityQueue<>();

    if (livro.getDisponibilidade() == 0) {
      System.out.print("Livro indisponível! Deseja entrar na fila de espera? (s/n) ");
      char input = sc.nextLine().charAt(0);
      if(input == 's'){
        filaEspera.add(livro);
        filaEspera.add(new Livro("Jason Momoa", "Carlos", 1982, 0));
        filaEspera.add(new Livro("Jason Momoa", "Carlos", 1982, 0));
        System.out.println("Você foi adicionado à lista de espera!");
      } else {
        System.out.print("Deseja adicioná-lo ao carrinho? (s/n): ");
        char carrinho = sc.nextLine().charAt(0);

        if (carrinho == 's') {
          ListaLivros listaLivros = new ListaLivros();
          listaLivros.adicionarLivro(livro);
          listaLivros.listarLivros();
        } else if (carrinho == 'n') {
          System.out.println("O livro não foi adicionado à lista.");
        } else {
          System.out.println("Valor inválido! O livro não foi adicionado à lista.");
        }
      }
    }

    System.out.println("Lista de espera: ");
    System.out.println(filaEspera.toString());

    sc.close();
  }
}
