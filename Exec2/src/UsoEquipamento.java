// Pacote onde a classe será armazenada
package entidades;

public class UsoEquipamento {
    private int idProjeto;
    private int idEquipamento;

    // Construtor, getters e setters
    public UsoEquipamento(int idProjeto, int idEquipamento) {
        this.idProjeto = idProjeto;
        this.idEquipamento = idEquipamento;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }
}
