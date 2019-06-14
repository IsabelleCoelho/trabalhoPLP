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

    public Museu(ArrayList<Visitante> visitantes, ArrayList<Funcionario> funcionarios, ArrayList<Setor> setores, ArrayList<Colecao> colecoes){
        this.visitantes = visitantes;
        this.funcionarios = funcionarios;
        this.setores = setores;
        this.colecoes = colecoes;
    }

    public String gerarRelatorioPessoas(){
        return "";
    }

    public String gerarRelatorioObras(){
        return "";
    }

    public void registrarVisitante(String nome, long cpf, Visita visita){
        Visitante visitante = getVisitante(cpf);
        if(visitante != null){
            visitante.adicionarVisita(visita);
        }
        else{
            System.out.println("Usuário ainda não inserido. Deseja cadastrar interesse, origem e Faixa etária? (s/n)");
            Visitante novo = new Visitante(nome, cpf);
            novo.adicionarVisita(visita);
            Scanner scan = new Scanner(System.in);
            String check = scan.nextLine();
            if(check.equals("s")){
                System.out.println("Origem do Visitante: ");
                novo.setOrigem(scan.nextLine());
                System.out.println("'Faixa etária' do visitante: ");
                novo.setFaixaEtaria(scan.nextLine());
                System.out.println("Interesse do visitante");
                novo.setInteresse(scan.nextLine());
                scan.nextLine();
            }
            visitantes.add(novo);
            System.out.println(novo);
        }
    }
    public boolean registrarColecao(Colecao colecao){
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
    public Funcionario getFuncionario(long cpf){
        for (Funcionario funcionario : funcionarios) {
            if(cpf == funcionario.getCpf()){
                return funcionario;
            }
        }
        return null;
    }
    public boolean contratarFuncionario(String nome, long cpf, float salario, String ocupacao, String nomeSetor){
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
    public Colecao getColecao(String nomeColecao){
        for (Colecao colecao : colecoes) {
            if(colecao.getNome().equals(nomeColecao)){
                return colecao;
            }
        }
        return null;
    }
    public boolean registrarPeca(Peca peca, String nomeColecao){
        Colecao colecao = getColecao(nomeColecao);
        if(colecao != null){
            return colecao.adicionarPeca(peca);
        }
        System.out.println("Colecao não existe");
        return false;
    }
    public boolean excluirFuncionario(long cpf){
        Funcionario funcionario = getFuncionario(cpf);
        if(funcionario != null){
            return funcionarios.remove(funcionario);
        }
        return false;
    }
    
    public boolean excluirColecao(String nome){
        Colecao colecao = getColecao(nome);
        if(colecao != null){
            return colecoes.remove(colecao);
        }
        return false;
    }
    public String listarVisitantes(){
        String out = "";
        for (Visitante visitante : visitantes) {
            out += visitante.toString() + "\n";
        }
        return out;
    }

    public String listarFuncionarios(){
        String out = "";
        for (Funcionario funcionario : funcionarios) {
            out += funcionario.toString() + "\n";
        }
        return out;
    }
    public String listarColecoes(){
        String out = "";
        for (Colecao colecao : colecoes) {
            out += colecao.toString() + "\n";
        }
        return out;
    }

    public Visitante getVisitante(long CPFconsultaVisitante){
        for(Visitante visitante : visitantes){
            if(visitante.getCpf() == CPFconsultaVisitante){
                return visitante;
            }
        }
        return null;
    }

    public Peca consultarPeca(String peca, String nomeColecao){
        Colecao colecao = getColecao(nomeColecao);
        if (colecao != null) {
            return colecao.getPeca(peca);
        }
        return null;
    }

    public boolean retirarDeExibicao(String nomeColecao){
        Colecao colecao = getColecao(nomeColecao);
        colecao.setExposto(false);
        return colecao.retirarExposto();
    }

    public boolean colocarEmExibicao(String nomeColecao,String nomeSetor){
        Colecao colecao = getColecao(nomeColecao);
        colecao.setExposto(true);
        Setor setor = getSetor(nomeSetor);
        return setor.adicionarColecao(colecao);
    }
}

