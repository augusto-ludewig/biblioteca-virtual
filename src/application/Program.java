package application;

import java.util.*;

import model.entities.*;

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

    Queue<Livro> filaEspera = new PriorityQueue<>();
    GrafoCategoria grafo = new GrafoCategoria();
    Biblioteca biblioteca = new Biblioteca();
    new Livro().criarLivros(biblioteca);

    // Adicionar todos os livros da biblioteca ao grafo
    for (Livro livro : biblioteca.getListaDeLivros()) {
      grafo.adicionarNode(livro);
    }

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

        Livro livroSelecionado = biblioteca.consultarLivro(indice);

        System.out.println("\n" + biblioteca.consultarLivro(indice).toStringDetalhado());
        histricoConsultaLivros.add(livroSelecionado);

        // Faz recomendações de livros com base no gênero literário do livro
        Set<Livro> recomendacoes = grafo.getRecomendacoes(livroSelecionado);
        System.out.println("\nOutras recomendações para " + livroSelecionado.getTitulo() + ":");
        recomendacoes.forEach(l -> System.out.println(" ▸ " + l.getTitulo()));
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
        System.out.print("Digite o índice do livro desejado: ");
        int indice = sc.nextInt() - 1;

        Livro livroSelecionado = biblioteca.consultarLivro(indice);
        Exemplar exemplarEmprestado = livroSelecionado.emprestarExemplar();

        if (exemplarEmprestado != null) {
          System.out.println("Livro emprestado com sucesso! Exemplar ID: " + exemplarEmprestado.getId());
        } else {
          sc = new Scanner(System.in);
          System.out.print("Livro indisponível! Deseja entrar na fila de espera? (s/n) ");
          char input = sc.nextLine().charAt(0);
          if(input == 's'){
            filaEspera.add(livroSelecionado);
            System.out.println("Você está na posição " + filaEspera.size() + " da fila!");
          }
        }
      }

      else if (selecao == 'e') {
        List<Exemplar> emprestados = new ArrayList<>();
        for (Livro livro : biblioteca.getListaDeLivros()) {
          emprestados.addAll(livro.getExemplaresEmprestados());
        }

        if (!emprestados.isEmpty()) {
          System.out.println("Livros emprestados:");
          for (int i = 0; i < emprestados.size(); i++) {
            System.out.println((i+1) + " - " + emprestados.get(i).getId());
          }

          System.out.print("Digite o índice do exemplar para devolver: ");
          int escolha = sc.nextInt() - 1;
          Exemplar exemplar = emprestados.get(escolha);
          exemplar.setStatus(Status.DISPONIVEL);
          System.out.println("Devolução realizada com sucesso!");
        } else {
          System.out.println("Não há livros emprestados!");
        }
      }

    }

    // Zerando a fila de espera - apenas simulação
    if (!filaEspera.isEmpty()) {
      System.out.println("\nNotificações da fila de espera:");
      while (!filaEspera.isEmpty()) {
        Livro livro = filaEspera.poll();
        System.out.println("O livro " + livro.getTitulo() + " está disponível!");
      }
    }

      System.out.println("\nNavegação do usuário: ");
      for (int i=0; i < historicoNavegacao.size(); i++){
        System.out.print(historicoNavegacao.pop() + "\\");
      }

      System.out.println("\nLivros consultados: ");
      for (Livro l : histricoConsultaLivros){
        System.out.println("- " + l.toString());
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
