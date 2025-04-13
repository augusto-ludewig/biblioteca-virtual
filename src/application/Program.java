package application;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

import model.entities.Biblioteca;
import model.entities.GrafoCategoria;
import model.entities.Livro;
import model.entities.Status;

public final class Program {
  private Program() {} // Construtor privado

  /**
   * Método principal de execução.
   *
   * @param args Argumentos da linha de comando
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<String> historicoNavegacao = new Stack<>();
    Stack<Livro> histricoConsultaLivros = new Stack<>();

    Livro l = new Livro();
    Queue<Livro> filaEspera = new PriorityQueue<>();
    GrafoCategoria grafo = new GrafoCategoria();
    Biblioteca biblioteca = new Biblioteca();
    Livro.criarLivros(biblioteca);

    System.out.println("Olá! Seja bem vindo(a) à sua Biblioteca Virtual!");

    char selecao = 0;
    while (selecao != 'f'){

      System.out.println("\nSelecione a opção: ");
      System.out.println("a) Listar livros");
      System.out.println("b) Consultar livro");
      System.out.println("c) Adicionar um livro");
      System.out.println("d) Emprestar um livro");
      System.out.println("e) Devolver um livro");
      System.out.println("f) Sair\n");

      System.out.print("Seleção: ");
      sc = new Scanner(System.in);
      selecao = sc.nextLine().charAt(0);
      System.out.println();

      if (selecao == 'a'){
        historicoNavegacao.push("Listar livros");
        biblioteca.listarLivros();
      }

      else if (selecao == 'b') {
        historicoNavegacao.push("Consultar livro");
        biblioteca.listarLivros();

        System.out.print("\nDigite o indice do livro desejado: ");
        int indice = sc.nextInt()-1;

        System.out.println("\n" + biblioteca.consultarLivro(indice).toStringDetalhado());
        histricoConsultaLivros.add(biblioteca.consultarLivro(indice));
      }

      else if (selecao == 'c') {
        historicoNavegacao.push("Adicionar um livro");
        System.out.print("Digite o nome do livro: ");
        String nomeLivro = sc.nextLine();

        System.out.print("Digite o nome do autor: ");
        String autorLivro = sc.nextLine();

        System.out.print("Digite o gênero literário: ");
        String generoLiterario = sc.nextLine();

        System.out.print("Digite o ano de publicação: ");
        int anoPublicacao = sc.nextInt();

        System.out.print("Digite a quantidade disponível em estoque: ");
        int quantidadeDeExemplares = sc.nextInt();

        biblioteca.adicionarLivro(new Livro(nomeLivro, autorLivro, generoLiterario, anoPublicacao, quantidadeDeExemplares));
      }

      else if (selecao == 'd') {
        historicoNavegacao.push("Emprestar um livro");
        biblioteca.listarLivros();
        System.out.print("Digite o indice do livro desejado: ");
        int indice = sc.nextInt() - 1;
        biblioteca.consultarLivro(indice).getExemplaresDisponiveis();

        if (biblioteca.consultarLivro(indice).emprestarExemplar() != null) {
          biblioteca.consultarLivro(indice).emprestarExemplar();
          System.out.println("Livro emprestado com sucesso!");
        } else {
          historicoNavegacao.push("Fila de espera");
          System.out.print("Livro indisponível! Deseja entrar na fila de espera? (s/n) ");
          sc = new Scanner(System.in);
          char input = sc.nextLine().charAt(0);
          if(input == 's'){
            filaEspera.add(biblioteca.consultarLivro(indice));
            System.out.println("Livro adicionado à lista de espera!");
          }
        }

      }

      else if (selecao == 'e') {
        if ()
        System.out.println("Livros emprestados: \n" + biblioteca.consultarLivro().getExemplaresEmprestados());
        System.out.print("\nDigite o indice do livro para devolvê-lo: ");
        sc = new Scanner(System.in);
        int input = sc.nextInt();
        biblioteca.consultarLivro(input).devolverExemplar(l.getExemplaresEmprestados().get(input));
      }

    }


    if (!filaEspera.isEmpty()) {
      System.out.println("\nLivros na fila de espera: ");
      for (int i=0; i < filaEspera.size(); i++){
        System.out.println("O livro " + filaEspera.remove().getTitulo() + " foi devolvido e está disponível para locação!");
      }
    }

      System.out.println("\nNavegação do usuário: ");
      for (int i=0; i < historicoNavegacao.size(); i++){
        System.out.print(historicoNavegacao.pop() + "\\");
      }
      System.out.println("\nLivros consultados: " + histricoConsultaLivros.toString());

      for (int i = 0; i < biblioteca.getListaDeLivros().size(); i++){

      }
    //    grafo.adicionarNode(livro1);
    //    grafo.adicionarNode(livro2);
    //    grafo.adicionarNode(livro3);
    //
    //    grafo.adicionarConexao(livro1, livro2);
    //    grafo.adicionarConexao(livro2, livro3);
    //
    //    grafo.mostrarConexoes();

      sc.close();

  }
}
