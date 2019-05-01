import java.util.*;

public class Museu{
    private ArrayList<Visitante> visitantes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Setor> setores;
    private ArrayList<Coelecao> colecoes;

    public Museu(){
        visitantes = new ArrayList<Visitante>();
        funcionarios = new ArrayList<Funcionario>();
        setores = new ArrayList<Setor>();
        colecoes = new ArrayList<Coelecao>();
        //Adicionar aqui os setores a serem adicionados
        setores.add(new Setor("Permanente", "Setor 1"));
        setores.add(new Setor("Temporario", "Setor 2"));
        setores.add(new Setor("Temporario", "Setor 3"));
    }

    public String gerarRelatorioPessoas(){
        return "";
    }

    public String gerarRelatorioObras(){
        return "";
    }

    public void registrarVisitante(String nome, int cpf, Visita visita){
        boolean inserido = False;
        for (Visitante visitante : visitantes) {
            if(visitante.getCpf() == cpf){
                visitante.adicionarVisita(visita);
                inserido = True;
            }
        }
        if(!inserido){
            Visitante novo = new Visitante(nome, cpf);
            novo.adicionarVisita(visita);
            visitantes.add(novo);
        }
    }
    public boolean cadastrarColecao(Colecao colecao){
        boolean inserido = False;
        for (Colecao col : colecoes) {
            if(col.getNome().equals(colecao.getNome())){
                inserido = True;
                System.out.println("Colecao já existe");
                return False;
            }
        }
        if(!inserido){
            colecoes.add(colecao);
            System.out.println("Coleção cadastrada");
            return True;
        }
    }
    public boolean contratarFuncionario(String nome, int cpf, float salario, String ocupacao, String nomeSetor){
        Setor novoSetor = null;
        for (Setor setor : Setores) {
            if(nomeSetor.equals(setor.getNomeSetor())){
                novoSetor = setor;
            }
        }
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getCpf() == cpf){
                System.out.println("CPF já cadastrado, erro");
                return False;
            }
        }
        if(novoSetor != null){
            funcionarios.add(new Funcionario(nome, cpf, salario, ocupacao, novoSetor));
            return True;
        }
        System.out.println("Setor não cadastrado, erro na contratação");
        return False;
    }
    public boolean exibirColecao(String nomeSetor, String nomeColecao){
        Setor set = null;
        Colecao col = null;
        for (Setor setor : setores) {
            if(nomeSetor.equals(setor.getNome())){
                set = setor;
            }
        }
        for (Colecao colecao : colecoes) {
            if(nomeColecao.equals(colecao.getNome())){
                col = colecao;
            }
        }
        if(set != null && col != null){
            if(col.isExposto()){
                System.out.println("Colecao já em exposicao");
                return False;
            }
            else{
                System.out.println("Sucesso!!!");
                col.setExposto(True);
                set.adicionarColecao(col);
                return True;
            }
        }
        System.out.println("Parâmetros inválidos");
        return False;
    }
}

