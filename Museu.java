import java.util.*;

public class Museu{
    private ArrayList<Visitante> visitantes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Setor> setores;
    private ArrayList<Colecao> colecoes;

    /** Método de criação de museu default */
    public Museu(){
        visitantes = new ArrayList<Visitante>();
        funcionarios = new ArrayList<Funcionario>();
        setores = new ArrayList<Setor>();
        colecoes = new ArrayList<Colecao>();
        //Setores default
        setores.add(new Setor("Permanente", "Setor 1"));
        setores.add(new Setor("Temporario", "Setor 2"));
        setores.add(new Setor("Temporario", "Setor 3"));
    }
    /** Método de criação do museu com base no arquivo*/
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

    /** Método o qual registra um novo visitante */
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
                System.out.println("Interesse do visitante: ");
                novo.setInteresse(scan.nextLine());
            }
            visitantes.add(novo);
            System.out.println(novo);
            System.out.println("Pressione 'ENTER' para finalizar a operação.");
        }
    }

    /** Método o qual registra uma nova coleção */
    public boolean registrarColecao(Colecao colecao){
        boolean inserido = false;
        for (Colecao col : colecoes) {
            if(col.getNome().equals(colecao.getNome())){
                inserido = true;
                System.out.println("Colecao já existe.");
                return false;
            }
        }
        if(!inserido){
            colecoes.add(colecao);
            System.out.println("Coleção cadastrada.");
            System.out.println("Coleção não está em exibição.");
            return true;
        }
        System.out.println("#debug possível erro de lógica");
        return false; //Nunca chegará neste return
    }

    /** Método o qual, a partir de um nome, retorna um setor  */
    public Setor getSetor(String nomeSetor){
        for (Setor setor : setores) {
            if(nomeSetor.equals(setor.getNomeSetor())){
                return setor;
            }
        }
        return null;
    }

    /** Método o qual, a partir de um CPF, retorna um funcionário */
    public Funcionario getFuncionario(long cpf){
        for (Funcionario funcionario : funcionarios) {
            if(cpf == funcionario.getCpf()){
                return funcionario;
            }
        }
        return null;
    }

    /** Método o qual registra um funcionário */
    public boolean contratarFuncionario(String nome, long cpf, float salario, String ocupacao, String nomeSetor){
        Setor novoSetor = getSetor(nomeSetor);
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getCpf() == cpf){
                System.out.println("CPF já cadastrado. Erro!");
                return false;
            }
        }
        if(novoSetor != null){
            funcionarios.add(new Funcionario(nome, cpf, salario, ocupacao, novoSetor));
            return true;
        }
        System.out.println("Setor não cadastrado. Erro na contratação.");
        return false;
    }

    /** Método o qual coloca uma coleção em exibição em determinado setor */
    public boolean exibirColecao(String nomeSetor, String nomeColecao){
        Setor setor = getSetor(nomeSetor);
        Colecao colecao = getColecao(nomeColecao);
        if(setor != null && colecao != null){
            if(colecao.isExposto()){
                System.out.println("Colecao já em exposicao!");
                return false;
            }
            else{
                System.out.println("Sucesso!!!");
                colecao.setExposto(true);
                setor.adicionarColecao(colecao);
                return true;
            }
        }
        return false;
    }

    /** Método o qual lista todos os setores registrados */
    public String listarSetores(){
        String out = "";
        for (Setor setor : setores) {
            out += setor.getNomeSetor() + "\n";
        }
        return out;
    }

    /** Método o qual, a partir de um nome, retorna a coleção correspondente */
    public Colecao getColecao(String nomeColecao){
        for (Colecao colecao : colecoes) {
            if(colecao.getNome().equals(nomeColecao)){
                return colecao;
            }
        }
        return null;
    }

    /** Método o qual insere uma peça em determinada coleção  */
    public boolean registrarPeca(Peca peca, String nomeColecao){
        Colecao colecao = getColecao(nomeColecao);
        if(colecao != null){
            return colecao.adicionarPeca(peca);
        }
        System.out.println("Colecao não existe.");
        return false;
    }

    /** Método o qual, a partir de um CPF, exclui um funcionário */
    public boolean excluirFuncionario(long cpf){
        Funcionario funcionario = getFuncionario(cpf);
        if(funcionario != null){
            return funcionarios.remove(funcionario);
        }
        return false;
    }

    /** Método o qual, a partir de um nome, remove uma coleção */
    public boolean excluirColecao(String nome){
        Colecao colecao = getColecao(nome);
        if(colecao != null){
            return colecoes.remove(colecao);
        }
        return false;
    }

    /** Método o qual lista todos os visitantes cadatrados */
    public String listarVisitantes(){
        String out = "";
        for (Visitante visitante : visitantes) {
            out += visitante.toString() + "\n";
        }
        return out;
    }

    /** Método o qual lista todos os funcionáriios registrados */
    public String listarFuncionarios(){
        String out = "";
        for (Funcionario funcionario : funcionarios) {
            out += funcionario.toString() + "\n";
        }
        return out;
    }

    /** Método o qual lista todas as coleções registradas */
    public String listarColecoes(){
        String out = "";
        for (Colecao colecao : colecoes) {
            out += colecao.toString() + "\n";
        }
        return out;
    }

    /** Método o qual, a partir de um CPF fornecido, retorna um visitante correspondente */
    public Visitante getVisitante(long CPFconsultaVisitante){
        for(Visitante visitante : visitantes){
            if(visitante.getCpf() == CPFconsultaVisitante){
                return visitante;
            }
        }
        return null;
    }

    /** Método o qual retorna os dados acerca de determinada peça, pertencente a determinada coleção */
    public Peca consultarPeca(String peca, String nomeColecao){
        Colecao colecao = getColecao(nomeColecao);
        if (colecao != null) {
            return colecao.getPeca(peca);
        }
        return null;
    }

    /** Método o qual retira de exibição a coleção fornecida */
    public boolean retirarDeExibicao(String nomeColecao){
        Colecao colecao = getColecao(nomeColecao);
        colecao.setExposto(false);
        return colecao.retirarExposto();
    }

    /** Método o qual coloca uma coleção em exibição em determinado setor */
    public boolean colocarEmExibicao(String nomeColecao,String nomeSetor){
        Colecao colecao = getColecao(nomeColecao);
        colecao.setExposto(true);
        Setor setor = getSetor(nomeSetor);
        return setor.adicionarColecao(colecao);
    }
}
