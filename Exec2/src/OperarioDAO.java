package dao;

import conexao.ConexaoBD;
import entidades.Operario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperarioDAO {

    // Método para inserir um novo Operário
    public void inserirOperario(Operario operario) {
        String sql = "INSERT INTO Operario (Nome_Operario, Funcao) VALUES (?, ?)";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, operario.getNomeOperario());
            stmt.setString(2, operario.getFuncao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um Operário existente
    public void atualizarOperario(Operario operario) {
        String sql = "UPDATE Operario SET Nome_Operario = ?, Funcao = ? WHERE ID_Operario = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, operario.getNomeOperario());
            stmt.setString(2, operario.getFuncao());
            stmt.setInt(3, operario.getIdOperario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um Operário
    public void excluirOperario(int idOperario) {
        String sql = "DELETE FROM Operario WHERE ID_Operario = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idOperario);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os Operários
    public List<Operario> listarOperarios() {
        List<Operario> operarios = new ArrayList<>();
        String sql = "SELECT * FROM Operario";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idOperario = rs.getInt("ID_Operario");
                String nomeOperario = rs.getString("Nome_Operario");
                String funcao = rs.getString("Funcao");

                Operario operario = new Operario(nomeOperario, funcao);
                operarios.add(operario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return operarios;
    }

    // Método para buscar um Operário por ID
    public Operario buscarOperarioPorId(int idOperario) {
        Operario operario = null;
        String sql = "SELECT * FROM Operario WHERE ID_Operario = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idOperario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nomeOperario = rs.getString("Nome_Operario");
                    String funcao = rs.getString("Funcao");

                    operario = new Operario(nomeOperario, funcao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return operario;
    }
}
