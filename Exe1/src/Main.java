
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            AutorDAO autorDAO = new AutorDAO();
            LivroDAO livroDAO = new LivroDAO();

            // Inserindo um autor
            Autor autor = new Autor(1, "J.K. Rowling", "Britânica");
            autorDAO.inserirAutor(autor);

            // Inserindo um livro
            Livro livro = new Livro(1, "Harry Potter e a Pedra Filosofal", 1997, 1);
            livroDAO.inserirLivro(livro);

            // Listando autores
            System.out.println("Autores:");
            for (Autor a : autorDAO.listarAutores()) {
                System.out.println(a.getNome());
            }

            // Listando livros de um autor
            System.out.println("Livros de J.K. Rowling:");
            for (Livro l : livroDAO.listarLivrosPorAutor(1)) {
                System.out.println(l.getTitulo());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
