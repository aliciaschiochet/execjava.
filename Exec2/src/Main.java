import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria instâncias dos DAOs
        dao.ProjetoDAO projetoDAO = new dao.ProjetoDAO();
        dao.EngenheiroDAO engenheiroDAO = new dao.EngenheiroDAO();
        dao.OperarioDAO operarioDAO = new dao.OperarioDAO();
        var equipamentoDAO = new EquipamentoDAO();
        var materialDAO = new MaterialDAO();

        // Inserir um novo projeto
        entidades.Projeto projeto = new entidades.Projeto("Projeto A", "Local A", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000L));
        projetoDAO.inserirProjeto(projeto);

        // Atualizar um projeto existente
        projeto.setNomeProjeto("Projeto Atualizado");
        projetoDAO.atualizarProjeto(projeto);

        // Listar todos os projetos
        List<entidades.Projeto> projetos = projetoDAO.listarProjetos();
        for (entidades.Projeto p : projetos) {
            System.out.println(p);
        }

        // Buscar um projeto por ID
        entidades.Projeto p = projetoDAO.buscarProjetoPorId(1);
        System.out.println(p);

        // Inserir um novo engenheiro
        entidades.Engenheiro engenheiro = new entidades.Engenheiro("Engenheiro A", "Especialidade A");
        engenheiroDAO.inserirEngenheiro(engenheiro);

        // Atualizar um engenheiro existente
        engenheiro.setNomeEngenheiro("Engenheiro Atualizado");
        engenheiroDAO.atualizarEngenheiro(engenheiro);

        // Listar todos os engenheiros
        List<entidades.Engenheiro> engenheiros = engenheiroDAO.listarEngenheiros();
        for (entidades.Engenheiro e : engenheiros) {
            System.out.println(e);
        }

        // Buscar um engenheiro por ID
        entidades.Engenheiro e = engenheiroDAO.buscarEngenheiroPorId(1);
        System.out.println(e);

        // Inserir um novo operário
        entidades.Operario operario = new entidades.Operario("Operário A", "Função A");
        operarioDAO.inserirOperario(operario);

        // Atualizar um operário existente
        operario.setNomeOperario("Operário Atualizado");
        operarioDAO.atualizarOperario(operario);

        // Listar todos os operários
        List<entidades.Operario> operarios = operarioDAO.listarOperarios();
        for (entidades.Operario o : operarios) {
            System.out.println(o);
        }

        // Buscar um operário por ID
        entidades.Operario o = operarioDAO.buscarOperarioPorId(1);
        System.out.println(o);

        // Inserir um novo equipamento
        entidades.Equipamento equipamento = new entidades.Equipamento("Equipamento A", "Tipo A");
        equipamentoDAO.inserirEquipamento(equipamento);

        // Atualizar um equipamento existente
        equipamento.setNomeEquipamento("Equipamento Atualizado");
        equipamentoDAO.atualizarEquipamento(equipamento);

        // Listar todos os equipamentos
        List<entidades.Equipamento> equipamentos = equipamentoDAO.listarEquipamentos();
        assert equipamentos != null;
        for (entidades.Equipamento eq : equipamentos) {
            System.out.println(eq);
        }

        // Buscar um equipamento por ID
        entidades.Equipamento eq = equipamentoDAO.buscarEquipamentoPorId(1);
        System.out.println(eq);

        // Inserir um novo material
        entidades.Material material = new entidades.Material("Material A", 100);
        materialDAO.inserirMaterial(material);

        // Atualizar um material existente
        material.setNomeMaterial("Material Atualizado");
        material.setQuantidade(200);
        materialDAO.atualizarMaterial(material);

        // Listar todos os materiais
        List<entidades.Material> materiais = materialDAO.listarMateriais();
        for (entidades.Material m : materiais) {
            System.out.println(m);
        }

        // Buscar um material por ID
        entidades.Material m = materialDAO.buscarMaterialPorId(1);
        System.out.println(m);
    }

    private static class EquipamentoDAO {
        public void inserirEquipamento(entidades.Equipamento equipamento) {

        }

        public void atualizarEquipamento(entidades.Equipamento equipamento) {

        }

        public List<entidades.Equipamento> listarEquipamentos() {
            return null;
        }

        public entidades.Equipamento buscarEquipamentoPorId(int i) {
            return null;
        }
    }

    private static class MaterialDAO {
        public void inserirMaterial(entidades.Material material) {

        }

        public void atualizarMaterial(entidades.Material material) {

        }

        public List<entidades.Material> listarMateriais() {
            return null;
        }

        public entidades.Material buscarMaterialPorId(int i) {
            return null;
        }
    }
}
