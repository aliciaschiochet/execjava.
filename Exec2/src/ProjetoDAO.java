// Pacote onde a classe será armazenada
package dao;

import conexao.ConexaoBD;
import entidades.Projeto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {

    // Método para inserir um novo Projeto
    public void inserirProjeto(Projeto projeto) {
        String sql = "INSERT INTO Projeto (Nome_Projeto, Local, Data_Inicio, Data_Termino) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, projeto.getNomeProjeto());
            stmt.setString(2, projeto.getLocal());
            stmt.setDate(3, new java.sql.Date(projeto.getDataInicio().getTime()));
            stmt.setDate(4, new java.sql.Date(projeto.getDataTermino().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um Projeto existente
    public void atualizarProjeto(Projeto projeto) {
        String sql = "UPDATE Projeto SET Nome_Projeto = ?, Local = ?, Data_Inicio = ?, Data_Termino = ? WHERE ID_Projeto = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, projeto.getNomeProjeto());
            stmt.setString(2, projeto.getLocal());
            stmt.setDate(3, new java.sql.Date(projeto.getDataInicio().getTime()));
            stmt.setDate(4, new java.sql.Date(projeto.getDataTermino().getTime()));
            stmt.setInt(5, projeto.getIdProjeto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um Projeto
    public void excluirProjeto(int idProjeto) {
        String sql = "DELETE FROM Projeto WHERE ID_Projeto = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idProjeto);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos Projetos
    public List<Projeto> listarProjetos() {
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT * FROM Projeto";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idProjeto = rs.getInt("ID_Projeto");
                String nomeProjeto = rs.getString("Nome_Projeto");
                String local = rs.getString("Local");
                Date dataInicio = rs.getDate("Data_Inicio");
                Date dataTermino = rs.getDate("Data_Termino");

                Projeto projeto = new Projeto(nomeProjeto, local, dataInicio, dataTermino);
                projetos.add(projeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projetos;
    }

    // Método para buscar um Projeto por ID
    public Projeto buscarProjetoPorId(int idProjeto) {
        Projeto projeto = null;
        String sql = "SELECT * FROM Projeto WHERE ID_Projeto = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idProjeto);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nomeProjeto = rs.getString("Nome_Projeto");
                    String local = rs.getString("Local");
                    Date dataInicio = rs.getDate("Data_Inicio");
                    Date dataTermino = rs.getDate("Data_Termino");

                    projeto = new Projeto(nomeProjeto, local, dataInicio, dataTermino);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projeto;
    }
}
