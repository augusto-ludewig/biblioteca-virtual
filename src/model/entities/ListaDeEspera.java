package model.entities;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/** Representa uma lista de livros. */
public final class ListaDeEspera {
    private final Queue<Livro> listaDeEspera;

    public ListaDeEspera() {
        this.listaDeEspera = new Queue<Livro>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Livro> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Livro livro) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Livro> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean offer(Livro livro) {
                return false;
            }

            @Override
            public Livro remove() {
                return null;
            }

            @Override
            public Livro poll() {
                return null;
            }

            @Override
            public Livro element() {
                return null;
            }

            @Override
            public Livro peek() {
                return null;
            }
        };
    }

    public void adicionarLivro(final Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O livro não pode ser nulo");
        }
        this.listaDeEspera.add(livro);
    }

    public void removerLivro(final Livro livro) {
        listaDeEspera.remove(livro);
    }

    public void listarLivros() {
        for (Livro elemento : listaDeEspera) {
            System.out.println(elemento);
        }
    }
}
