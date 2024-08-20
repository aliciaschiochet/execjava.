// Pacote onde a classe será armazenada
package entidades;

public class AlocacaoEngenheiro {
    private int idProjeto;
    private int idEngenheiro;

    // Construtor, getters e setters
    public AlocacaoEngenheiro(int idProjeto, int idEngenheiro) {
        this.idProjeto = idProjeto;
        this.idEngenheiro = idEngenheiro;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdEngenheiro() {
        return idEngenheiro;
    }

    public void setIdEngenheiro(int idEngenheiro) {
        this.idEngenheiro = idEngenheiro;
    }
}
