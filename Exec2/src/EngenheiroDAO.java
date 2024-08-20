// Pacote onde a classe será armazenada
package dao;

import conexao.ConexaoBD;
import entidades.Engenheiro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EngenheiroDAO {

    // Método para inserir um novo Engenheiro
    public void inserirEngenheiro(Engenheiro engenheiro) {
        String sql = "INSERT INTO Engenheiro (Nome_Engenheiro, Especialidade) VALUES (?, ?)";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, engenheiro.getNomeEngenheiro());
            stmt.setString(2, engenheiro.getEspecialidade());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um Engenheiro existente
    public void atualizarEngenheiro(Engenheiro engenheiro) {
        String sql = "UPDATE Engenheiro SET Nome_Engenheiro = ?, Especialidade = ? WHERE ID_Engenheiro = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, engenheiro.getNomeEngenheiro());
            stmt.setString(2, engenheiro.getEspecialidade());
            stmt.setInt(3, engenheiro.getIdEngenheiro());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um Engenheiro
    public void excluirEngenheiro(int idEngenheiro) {
        String sql = "DELETE FROM Engenheiro WHERE ID_Engenheiro = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idEngenheiro);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos Engenheiros
    public List<Engenheiro> listarEngenheiros() {
        List<Engenheiro> engenheiros = new ArrayList<>();
        String sql = "SELECT * FROM Engenheiro";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idEngenheiro = rs.getInt("ID_Engenheiro");
                String nomeEngenheiro = rs.getString("Nome_Engenheiro");
                String especialidade = rs.getString("Especialidade");

                Engenheiro engenheiro = new Engenheiro(nomeEngenheiro, especialidade);
                engenheiros.add(engenheiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return engenheiros;
    }

    // Método para buscar um Engenheiro por ID
    public Engenheiro buscarEngenheiroPorId(int idEngenheiro) {
        Engenheiro engenheiro = null;
        String sql = "SELECT * FROM Engenheiro WHERE ID_Engenheiro = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idEngenheiro);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nomeEngenheiro = rs.getString("Nome_Engenheiro");
                    String especialidade = rs.getString("Especialidade");

                    engenheiro = new Engenheiro(nomeEngenheiro, especialidade);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return engenheiro;
    }
}
