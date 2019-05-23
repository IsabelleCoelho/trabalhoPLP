import java.util.*;

public class Main{
    private static Museu museu = new Museu();
    private static Scanner scan = new Scanner(System.in);
    private static Data data = new Data(12, 5, 2019);

    private static void mainMenu(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU:                               |\n" +
                            "|1.  Registrar                       |\n" +
                            "|2.  Excluir                         |\n" + 
                            "|3.  Listar                          |\n" +
                            "|4.  Consultar                       |\n" +
                            "|5.  Gerar Relatório                 |\n" +
                            "|0.  Sair                            |\n" +
                            "|------------------------------------|\n" );
    }
    private static void MenuRegistrar(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU REGISTRAR:                     |\n" +
                            "|1.  Registrar visita                |\n" +
                            "|2.  Registrar coleção               |\n" + 
                            "|3.  Registrar peça                  |\n" + 
                            "|4.  Registrar funcionário           |\n" +
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        do{
            opcao = scan.nextLine();
            switch (opcao){
                case "1":
                    System.out.println("Nome do visitante a ser registrado:");
                    String nomeVisitante =  scan.nextLine();
                    System.out.println("CPF do visitante a ser registrado:");
                    long cpfVisitante = scan.nextLong();
                    adicionarVisitante(nomeVisitante , cpfVisitante);
                break;
                case "2":
                    System.out.println("Digite o nome da nova coleção");
                    String lido;
                    lido = scan.nextLine();
                    adicionarColecao(lido);  
                break;
                case "3":
                    System.out.println("Nome da peça a ser registrada");
                    String nomeObra = scan.nextLine();
                    System.out.println("Ano de criação da peça a ser registrada");
                    int anoDeCriacao = scan.nextInt();
                    System.out.println("Ano de aquisição da peça a ser registrada");
                    int anoDeAquisicao = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Estado de conservação da peça a ser registrada");
                    String estado = scan.nextLine();
                    System.out.println("Colecao a ser inserida");
                    String colecao = scan.nextLine();
                    registrarPeca(nomeObra, anoDeCriacao, anoDeAquisicao, estado, colecao);
                break;
                case "4":
                    System.out.println("Escreva os dados do usuario");
                    System.out.println("Nome");
                    String nome;
                    nome = scan.nextLine();
                    System.out.println("CPF");
                    long cpf;
                    cpf = scan.nextLong();
                    System.out.println("Salário");
                    int salario;
                    salario = scan.nextInt();
                    System.out.println("Ocupação");
                    String ocupacao;
                    ocupacao = scan.nextLine();
                    System.out.println("Nome do setor que ele irá trabalhar");
                    String nomeSetor;
                    nomeSetor = scan.nextLine();
                    adicionarFuncionario(nome , cpf , salario , ocupacao , nomeSetor);
                break;
            }
        }while(!opcao.equals("0"));
    }

    private static void MenuExcluir(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU EXCLUIR:                       |\n" +
                            "|1.  Excluir funcionário             |\n" + 
                            "|2.  Excluir coleção                 |\n" +
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        do{
            opcao = scan.nextLine();
            switch (opcao){
                case "1":
                    System.out.println("CPF do funcionário a ser excluído");
                    int cpf = scan.nextInt();
                    removerFuncionario(cpf);
                break;
                case "2":
                    System.out.println("Nome da coleção a ser removida");
                    String nome = scan.nextLine();
                    removerColecao(nome);
                break;
            }
        }while(!opcao.equals("0"));
    }

    private static void MenuListar(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU LISTAR:                        |\n" +
                            "|1.  Listar funcionários             |\n" +
                            "|2.  Listar visitantes               |\n" +
                            "|3.  Listar coleções                 |\n" +  
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        do{
            opcao = scan.nextLine();
            switch (opcao){
                case "1":
                    System.out.println(museu.listarFuncionarios());
                break;
                case "2":
                    System.out.println(museu.listarVisitantes());
                break;
                case "3":
                    System.out.println(museu.listarColecoes());
                break;
            }
        }while(!opcao.equals("0"));
    }

    private static void MenuConsultar(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU CONSULTAR:                     |\n" +
                            "|1.  Consultar visitante             |\n" +
                            "|2.  Consultar coleção               |\n" +
                            "|3.  Consultar peça                  |\n" +
                            "|4.  Consultar funcionário           |\n" + 
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        do{
            opcao = scan.nextLine();
            switch (opcao){
                case "1":
                    System.out.println("CPF do visitante");
                    int CPFconsultaVisitante = scan.nextInt();
                    scan.nextLine();
                    consultarVisitante(CPFconsultaVisitante);
                break;
                case "2":
                    System.out.println("Nome da coleção a ser consultado");
                    String nomeColecao = scan.nextLine();
                    consultarColecao(nomeColecao);
                break;
                case "3":
                    System.out.println("Nome da peca a ser consultado:");
                    String nomePeca = scan.nextLine();
                    System.out.println("Nome da coleção onde a peça se encontra:");
                    String nomeColecao_consultaObra = scan.nextLine();
                    consultarPeca(nomePeca, nomeColecao_consultaObra);
                break;
                case"4":
                    System.out.println("CPF do funcionario");
                    int CPFconsultaFuncionario = scan.nextInt();
                    scan.nextLine();
                    consultarFuncionario(CPFconsultaFuncionario);
                break;
            }
        }while(!opcao.equals("0"));
    }
    
    private static void MenuGerarRelatorio(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU GERAR RELATORIO:               |\n" +
                            "|1.  Gerar relatório de obras        |\n" + 
                            "|2.  Gerar relatório de visitantes   |\n" + 
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        do{
            opcao = scan.nextLine();
            switch (opcao){
                case "1":
                    System.out.println("Ainda não implementado");
                break;
                case "2":
                    System.out.println("Ainda não implementado");
                break;
            }
        }while(!opcao.equals("0"));
    }

    private static void adicionarVisitante(String nomeVisitante, long cpf){
        System.out.println("Quais setores " + nomeVisitante + " visitou?");
        System.out.println("Digite o nome dos setores visitados seguido de enter e para finalizar a inserção digite -1");
        System.out.println(museu.listarSetores());
        ArrayList<Setor> setoresVisitados = new ArrayList<Setor>();
        String read = "-1";
        Setor setor;
        do {
            read = scan.nextLine();
            setor = museu.getSetor(read);
            if(setor != null){
                setoresVisitados.add(setor);
            }
        } while (!read.equals("-1"));
        Visita visita = new Visita(data, setoresVisitados);
        museu.registrarVisitante(nomeVisitante, cpf, visita);
    }
    private static void adicionarFuncionario(String nome, long cpf, float salario, String ocupacao, String nomeSetor){
        if(museu.getFuncionario(cpf) != null){
            System.out.println("Funcionario já existe");
        }else{
            museu.contratarFuncionario(nome , cpf , salario , ocupacao , nomeSetor);
            System.out.println("Funcionario registrado!");
        }
    }
    private static void registrarPeca(String nomeObra, int anoDeCriacao, int anoDeAquisicao, String estado, String colecao) {
        Peca peca = new Peca(nomeObra, anoDeCriacao, anoDeAquisicao, estado);
        museu.registrarPeca(peca, colecao);
    }
    private static void adicionarColecao(String nomeColecao){
        Colecao colecao = museu.getColecao(nomeColecao);
        if (colecao != null) {
            System.out.println("Colecão já inserida");
        }
        else {
            museu.registrarColecao(new Colecao(nomeColecao));
        }
    }

    private static void removerFuncionario(long cpf){
        if (museu.excluirFuncionario(cpf)) {
            System.out.println("Funcionário removido com sucesso!");
        }
        else{
            System.out.println("Funcionario não registrado.");
        }
    }
    private static void removerColecao(String nome){
        if (museu.excluirColecao(nome)){
            System.out.println("Coleção removido com sucesso!");
        }
        else{
            System.out.println("Coleção não registrada.");
        }
    }
    private static void consultarVisitante(long CPFconsultaVisitante){
        Visitante visitante;
        visitante = museu.getVisitante(CPFconsultaVisitante);
        if(visitante != null){
            System.out.println(visitante.toString());
        }
        else{
            System.out.println("Visitante não registrado.");
        }
    }
    private static void consultarColecao(String nomeColecao){
        Colecao colecao;
        colecao = museu.getColecao(nomeColecao);
        if(colecao != null){
            System.out.println(colecao.toString());
        }
        else{
            System.out.println("Coleção não registrada.");
        }
    }
    private static void consultarFuncionario(long CPFfuncionario){
        Funcionario funcionario;
        funcionario = museu.getFuncionario(CPFfuncionario);
        if(funcionario != null){
            System.out.println(funcionario.toString());
        }
        else{
            System.out.println("Funcionario não registrado.");
        }
        
    }

    private static void mudarEstadoColecao(String nomeColecao, String opcao){
        if(museu.getColecao(nomeColecao) == null){
            System.out.println("Coleção não registrada.");
        }
        else{
            if("retirar".equals(opcao)){
                museu.retirarDeExibicao(nomeColecao);
                System.out.println("Coleção retirada de exposição");
            }
            else{
                System.out.println("Qual o setor no qual a coleção será exibida?");
                String setor = scan.nextLine();
                museu.colocarEmExibicao(nomeColecao,setor);
                System.out.println("Coleção colocada em exposição");
            }
        }
    }

    private static void consultarPeca(String nomePeca, String nomeColecao){
        Peca peca = museu.consultarPeca(nomePeca, nomeColecao);
        if (peca != null) {
            System.out.println(peca);
        }
        System.out.println("Combinação de chaves inválida, por favor consulte a listagem de coleções e pecas");
    }

    /** Testes já implementados */
    private static void testarMuseu(){
        adicionarColecao("Astronomia atraves dos seculos");
        registrarPeca("Galileu", 1, 2, "Bom", "Astronomia atraves dos seculos");
        registrarPeca("Descoberta de venus", 2, 3, "Ruim", "Astronomia atraves dos seculos");
        registrarPeca("Não é magia, é ciência", 3, 4, "Otimo", "Astronomia atraves dos seculos");
        registrarPeca("Lunetas", 4, 5, "Bom", "Astronomia atraves dos seculos");
        System.out.println(museu.listarColecoes());
        
        adicionarColecao("Armas históricas");
        registrarPeca("Lanças históricas", 5, 6, "Bom", "Armas históricas");
        registrarPeca("Primeira arma de fogo", 6, 7, "Bom", "Armas históricas");
        registrarPeca("Ak-47?", 7, 8, "Bom", "Armas históricas");
        registrarPeca("Arcos e tudo mais", 8, 9, "Bom", "Armas históricas");
        System.out.println(museu.listarColecoes());

        adicionarColecao("Invenções classicas");
        registrarPeca("Asas?!", 9, 10, "Bom", "Invenções classicas");
        registrarPeca("Primeiro avião", 10, 11, "Bom", "Invenções classicas");
        registrarPeca("França, mãe da aviação", 11, 12, "Bom", "Invenções classicas");
        registrarPeca("Revolução do vapor", 12, 13, "Bom", "Invenções classicas");
        System.out.println(museu.listarColecoes());

        adicionarColecao("Leonardo da Vinci arte e invenções");
        registrarPeca("Replica Monalisa", 13, 14, "Bom", "Leonardo da Vinci arte e invenções");
        registrarPeca("Maquina voadora", 14, 15, "Bom", "Leonardo da Vinci arte e invenções");
        registrarPeca("Tanque de guerra", 15, 16, "Bom", "Leonardo da Vinci arte e invenções");
        registrarPeca("Criptex", 16, 17, "Bom", "Leonardo da Vinci arte e invenções");
        System.out.println(museu.listarColecoes());
        
    }

    public static void main(String[] args) {
        String opcao;
        do{
            mainMenu();
            opcao = scan.nextLine();
            switch (opcao){
                case "1":
                    MenuRegistrar();
                break;
                case "2":
                    MenuExcluir();
                break;
                case "3":
                    MenuListar();
                break;
                case "4":
                    MenuConsultar();
                break;
                case "5":
                    MenuGerarRelatorio();
                break;
                case "-5":
                    testarMuseu();
                break;
            }
        }while(!opcao.equals("0"));
    }
}