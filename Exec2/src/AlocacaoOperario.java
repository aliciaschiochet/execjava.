// Pacote onde a classe será armazenada
package entidades;

public class AlocacaoOperario {
    private int idProjeto;
    private int idOperario;

    // Construtor, getters e setters
    public AlocacaoOperario(int idProjeto, int idOperario) {
        this.idProjeto = idProjeto;
        this.idOperario = idOperario;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(int idOperario) {
        this.idOperario = idOperario;
    }
}
