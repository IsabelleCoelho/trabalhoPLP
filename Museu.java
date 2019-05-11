import java.util.*;

public class Museu{
    private ArrayList<Visitante> visitantes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Setor> setores;
    private ArrayList<Colecao> colecoes;

    public Museu(){
        visitantes = new ArrayList<Visitante>();
        funcionarios = new ArrayList<Funcionario>();
        setores = new ArrayList<Setor>();
        colecoes = new ArrayList<Colecao>();
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
        boolean inserido = false;
        for (Visitante visitante : visitantes) {
            if(visitante.getCpf() == cpf){
                visitante.adicionarVisita(visita);
                inserido = true;
            }
        }
        if(!inserido){
            System.out.println("Usuário ainda não inserido. Deseja cadastrar interesse, origem e idade? (s/n)");
            Visitante novo = new Visitante(nome, cpf);
            novo.adicionarVisita(visita);
            Scanner scan = new Scanner(System.in);
            String check = scan.nextLine();
            if(check.equals("s")){
                System.out.println("Origem do Visitante: ");
                novo.setOrigem(scan.nextLine());
                System.out.println("Idade de visitante: ");
                novo.setFaixaEtaria(scan.nextInt());
                scan.nextLine();
                System.out.println("Interesse do visitante");
                novo.setInteresse(scan.nextLine());
                scan.nextLine();
            }
            visitantes.add(novo);
            System.out.println(novo);
        }
    }
    public boolean cadastrarColecao(Colecao colecao){
        boolean inserido = false;
        for (Colecao col : colecoes) {
            if(col.getNome().equals(colecao.getNome())){
                inserido = true;
                System.out.println("Colecao já existe");
                return false;
            }
        }
        if(!inserido){
            colecoes.add(colecao);
            System.out.println("Coleção cadastrada");
            return true;
        }
        System.out.println("#debug possível erro de lógica");
        return false; //Nunca chegará neste return
    }
    public Setor getSetor(String nomeSetor){
        for (Setor setor : setores) {
            if(nomeSetor.equals(setor.getNomeSetor())){
                return setor;
            }
        }
        return null;
    }
    public boolean contratarFuncionario(String nome, int cpf, float salario, String ocupacao, String nomeSetor){
        Setor novoSetor = getSetor(nomeSetor);
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getCpf() == cpf){
                System.out.println("CPF já cadastrado, erro");
                return false;
            }
        }
        if(novoSetor != null){
            funcionarios.add(new Funcionario(nome, cpf, salario, ocupacao, novoSetor));
            return true;
        }
        System.out.println("Setor não cadastrado, erro na contratação");
        return false;
    }
    public boolean exibirColecao(String nomeSetor, String nomeColecao){
        Setor set = null;
        Colecao col = null;
        for (Setor setor : setores) {
            if(nomeSetor.equals(setor.getNomeSetor())){
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
                return false;
            }
            else{
                System.out.println("Sucesso!!!");
                col.setExposto(true);
                set.adicionarColecao(col);
                return true;
            }
        }
        System.out.println("Parâmetros inválidos");
        return false;
    }
    public String listarSetores(){
        String out = "";
        for (Setor setor : setores) {
            out += setor.getNomeSetor() + "\n";
        }
        return out;
    }
    public boolean registrarPeca(){
        return true;
    }
}

