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
                            "|5.  Alterar                         |\n" +
                            "|6.  Gerar relatório                 |\n" +
                            "|0.  Sair                            |\n" +
                            "|------------------------------------|\n" );
    }
    private static void MenuRegistrar() throws Exception {
        System.out.println ("|------------------------------------|\n" +
                            "|MENU REGISTRAR:                     |\n" +
                            "|1.  Registrar visita                |\n" +
                            "|2.  Registrar coleção               |\n" + 
                            "|3.  Registrar peça                  |\n" + 
                            "|4.  Registrar funcionário           |\n" +
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        opcao = scan.nextLine();
        switch (opcao){
            case "1":
                System.out.println("Nome do visitante a ser registrado:");
                String nomeVisitante =  scan.nextLine();
                System.out.println("CPF do visitante a ser registrado:");
                long cpfVisitante = scan.nextLong();
                adicionarVisitante(nomeVisitante , cpfVisitante);
                scan.nextLine();
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
                String nome = scan.nextLine();
                System.out.println("CPF");
                long cpf = scan.nextLong();
                System.out.println("Salário");
                int salario = scan.nextInt();
                scan.nextLine();
                System.out.println("Ocupação");
                String ocupacao = scan.nextLine();
                System.out.println("Nome do setor que ele irá trabalhar");
                String nomeSetor = scan.nextLine();
                adicionarFuncionario(nome , cpf , salario , ocupacao , nomeSetor);
            break;
        }
    }

    private static void MenuExcluir(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU EXCLUIR:                       |\n" +
                            "|1.  Excluir funcionário             |\n" + 
                            "|2.  Excluir coleção                 |\n" +
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        opcao = scan.nextLine();
        switch (opcao){
            case "1":
                System.out.println("CPF do funcionário a ser excluído");
                Long cpf = scan.nextLong();
                removerFuncionario(cpf);
                scan.nextLine();
            break;
            case "2":
                System.out.println("Nome da coleção a ser removida");
                String nome = scan.nextLine();
                removerColecao(nome);
            break;
        }
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
    }

    private static void MenuConsultar() throws Exception {
        System.out.println ("|------------------------------------|\n" +
                            "|MENU CONSULTAR:                     |\n" +
                            "|1.  Consultar visitante             |\n" +
                            "|2.  Consultar coleção               |\n" +
                            "|3.  Consultar peça                  |\n" +
                            "|4.  Consultar funcionário           |\n" + 
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        opcao = scan.nextLine();
        switch (opcao){
            case "1":
                System.out.println("CPF do visitante");
                Long CPFconsultaVisitante = scan.nextLong();
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
                long CPFconsultaFuncionario = scan.nextLong();
                scan.nextLine();
                consultarFuncionario(CPFconsultaFuncionario);
            break;
        }
    }
    
    private static void MenuGerarRelatorio(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU GERAR RELATORIO:               |\n" +
                            "|1.  Gerar relatório de obras        |\n" + 
                            "|2.  Gerar relatório de visitantes   |\n" + 
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        opcao = scan.nextLine();
        switch (opcao){
            case "1":
                System.out.println("Ainda não implementado");
            break;
            case "2":
                System.out.println("Ainda não implementado");
            break;
        }
    }

    private static void MenuAlterar(){
        System.out.println ("|----------------------------------------|\n" +
                            "|MENU ALTERAR:                           |\n" +
                            "|1.  Alterar visitante                   |\n" + 
                            "|2.  Alterar colecao                     |\n" +
                            "|3.  Alterar funcionário                 |\n" +
                            "|4.  Alterar peça                        |\n" +
                            "|5.  Alterar tipo de exibição do setor   |\n" + 
                            "|0.  Voltar                              |\n" +  
                            "|----------------------------------------|\n" );
        String opcao;
        opcao = scan.nextLine();
        switch (opcao){
            case "1":
                try{
                    MenuAlterarVisitante();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            break;
            case "2":
                try{
                    MenuAlterarColecao();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            break;
            case "3":
                try{
                    MenuAlterarFuncionario();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            break;
            case "4":
                try{
                    MenuAlterarPeca();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            break;
            case "5":
                String nome;
                System.out.println("Digite o nome do setor:");
                nome = scan.nextLine();
                Setor setorAlterado=museu.getSetor(nome);
                if(setorAlterado==null){
                    System.out.println("Setor inválido!");
                }
                else{
                    System.out.println("Digite o novo tipo de exibição:");
                    String novo = scan.nextLine();
                    setorAlterado.setTipoDeExibicao(novo);
                }
            break;
        }
    }

    private static void MenuAlterarVisitante() throws Exception {
        System.out.println ("|------------------------------------|\n" +
                            "|MENU ALTERAR VISITANTE:             |\n" +
                            "|1.  Alterar nome                    |\n" + 
                            "|2.  Alterar interesse               |\n" +
                            "|3.  Alterar faixa etária            |\n" +
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        opcao = scan.nextLine();
        System.out.println("Digite o CPF do visitante:");
        Long cpf = scan.nextLong();
        Visitante visitante = museu.getVisitante(cpf);
        scan.nextLine();
        if(visitante == null){
            throw new Exception("Visitante não cadastrado!");
        }
        switch (opcao){
            case "1":
                System.out.println("Digite o novo nome do visitante:");
                String nome = scan.nextLine();
                visitante.setNome(nome);
            break;
            case "2":
                System.out.println("Digite o novo interesse do visitante:");
                String interesse = scan.nextLine();
                visitante.setInteresse(interesse);
            break;
            case "3":
                System.out.println("Digite a nova faixa etária do visitante:");
                String faixaEtaria = scan.nextLine();
                visitante.setFaixaEtaria(faixaEtaria);
            break;
        }
    }


    private static void MenuAlterarColecao() throws Exception {
        System.out.println ("|------------------------------------|\n" +
                            "|MENU ALTERAR COLEÇÃO:               |\n" +
                            "|1.  Alterar nome                    |\n" + 
                            "|2.  Alterar setor                   |\n" +
                            "|3.  Alterar estado                  |\n" +
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        opcao = scan.nextLine();
        System.out.println("Digite o nome atual da coleção:");
        String nomeColecao = scan.nextLine();
        Colecao colecao = museu.getColecao(nomeColecao);
        if(colecao == null){
            throw new Exception("Coleção não cadastrada!");
        }
        switch (opcao){
            case "1":
                System.out.println("Digite o novo nome da coleção:");
                String nome = scan.nextLine();
                colecao.setNome(nome);
            break;
            case "2":
                System.out.println("Digite o novo setor:");
                String nomeSetor = scan.nextLine();
                Setor setor = museu.getSetor(nomeSetor);
                if(setor == null){
                    System.out.println("Setor inválido!");
                    throw new Exception("Setor inválido!");
                }
                colecao.setSetor(setor);
            break;
            case "3":
                System.out.println("Digite 'retirar' para remover de exibição da coleção. Senão, digite 'colocar' para colocar uma coleção em exibição.");
                String escolha = scan.nextLine();
                mudarEstadoColecao(nomeColecao, escolha);
            break;
        }
    }

    private static void MenuAlterarFuncionario() throws Exception {
        System.out.println ("|------------------------------------|\n" +
                            "|MENU ALTERAR FUNCIONÁRIO:           |\n" +
                            "|1.  Alterar nome                    |\n" + 
                            "|2.  Alterar ocupação                |\n" +
                            "|3.  Alterar salário                 |\n" +
                            "|4.  Alterar setor                   |\n" +
                            "|------------------------------------|\n" );
        String opcao;
        opcao = scan.nextLine();
        System.out.println("Digite o CPF do funcionário:");
        Long cpfFuncionario = scan.nextLong();
        scan.nextLine();
        Funcionario funcionario = museu.getFuncionario(cpfFuncionario);
        if(funcionario == null){
            throw new Exception("Funcionário não cadastrado!");
        }
        switch (opcao){
            case "1":
                System.out.println("Digite o novo nome do funcionário:");
                String nome = scan.nextLine();
                funcionario.setNome(nome);
            break;
            case "2":
                System.out.println("Digite a nova ocupação do funcionário:");
                String ocupacao = scan.nextLine();
                funcionario.setOcupacao(ocupacao);
            break;
            case "3":
                System.out.println("Digite o novo salário do funcionário:");
                Float salario = scan.nextFloat();
                scan.nextLine();
                funcionario.setSalario(salario);
            break;
            case "4":
                System.out.println("Digite alterar setor:");
                String nomeSetor = scan.nextLine();
                Setor setor = museu.getSetor(nomeSetor);
                if(setor == null){
                    throw new Exception("Setor inválido!");
                }
                funcionario.setTrabalhaEm(setor);
            break;
        }
    }

    private static void MenuAlterarPeca() throws Exception {
        System.out.println ("|------------------------------------|\n" +
                            "|MENU ALTERAR PEÇA:                  |\n" +
                            "|1.  Alterar nome                    |\n" + 
                            "|2.  Alterar estado                  |\n" +
                            "|0.  Voltar                          |\n" +  
                            "|------------------------------------|\n" );
        String opcao;
        opcao = scan.nextLine();
        System.out.println("Digite o nome da coleção da peça:");
        String nomeColecao = scan.nextLine();
        Colecao colecao = museu.getColecao(nomeColecao);
        if(colecao == null){
            throw new Exception("Coleção inválida!");
        }
        System.out.println("Digite nome da peça:");
        String nomePeca = scan.nextLine();
        Peca peca = colecao.getPeca(nomePeca);
        if(peca == null){
            throw new Exception("Nome inválido!");
        }
        switch (opcao){
            case "1":
                System.out.println("Digite o novo nome da peça:");
                String nome = scan.nextLine();
                peca.setNomeObra(nome);
            break;
            case "2":
                System.out.println("Digite o novo estado da peça:");
                String estado = scan.nextLine();
                peca.setEstado(estado);
            break;
        }
    }
    
    private static void adicionarVisitante(String nomeVisitante, long cpf){
        System.out.println("Quais setores " + nomeVisitante + " visitou?");
        System.out.println("Setores diponíveis do museu:");
        System.out.println(museu.listarSetores());
        System.out.println("Digite o nome dos setores visitados seguido de enter e para finalizar a inserção digite -1");
        ArrayList<Setor> setoresVisitados = new ArrayList<Setor>();
        String read = "0";
        Setor setor;
        while(!read.equals("-1")){
            read = scan.nextLine();
            setor = museu.getSetor(read);
            if(setor != null){
                setoresVisitados.add(setor);
            }
        } 
        Visita visita = new Visita(data, setoresVisitados);
        museu.registrarVisitante(nomeVisitante, cpf, visita);
    }
    private static void adicionarFuncionario(String nome, long cpf, float salario, String ocupacao, String nomeSetor)
            throws Exception {
        if(museu.getFuncionario(cpf) != null){
            throw new Exception("Funcionario já existe.");
        }
        if(museu.contratarFuncionario(nome , cpf , salario , ocupacao , nomeSetor)){
            System.out.println("Funcionario registrado!");
        }
    }
    private static void registrarPeca(String nomeObra, int anoDeCriacao, int anoDeAquisicao, String estado, String colecao) {
        Peca peca = new Peca(nomeObra, anoDeCriacao, anoDeAquisicao, estado);
        museu.registrarPeca(peca, colecao);
    }
    private static void adicionarColecao(String nomeColecao) throws Exception {
        Colecao colecao = museu.getColecao(nomeColecao);
        if (colecao != null) {
            throw new Exception("Colecão já inserida!");
        }
        museu.registrarColecao(new Colecao(nomeColecao));
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
            System.out.println("Coleção removida com sucesso!");
        }
        else{
            System.out.println("Coleção não registrada.");
        }
    }
    private static void consultarVisitante(long CPFconsultaVisitante) throws Exception {
        Visitante visitante;
        visitante = museu.getVisitante(CPFconsultaVisitante);
        if(visitante == null){
            throw new Exception("Visitante não registrado.");
        }
        System.out.println(visitante.toString());
    }
    private static void consultarColecao(String nomeColecao) throws Exception {
        Colecao colecao;
        colecao = museu.getColecao(nomeColecao);
        if(colecao == null){
            throw new Exception("Coleção não registrada.");
        }
        System.out.println(colecao.toString());
    }
    private static void consultarFuncionario(long CPFfuncionario) throws Exception {
        Funcionario funcionario;
        funcionario = museu.getFuncionario(CPFfuncionario);
        if(funcionario == null){
            throw new Exception("Funcionario não registrado.");
        }
        System.out.println(funcionario.toString());
        
    }

    private static void mudarEstadoColecao(String nomeColecao, String opcao) throws Exception {
        if(museu.getColecao(nomeColecao) == null){
            throw new Exception("Coleção não registrada.");
        }
        if("retirar".equals(opcao)){
            museu.retirarDeExibicao(nomeColecao);
            System.out.println("Coleção retirada de exposição.");
        }
        else{
            if("retirar".equals(opcao)){
                museu.retirarDeExibicao(nomeColecao);
                System.out.println("Coleção retirada de exposição.");
            }
            else if("colocar".equals(opcao)){
                System.out.println("Qual o setor no qual a coleção será exibida?");
                String setor = scan.nextLine();
                museu.colocarEmExibicao(nomeColecao,setor);
                System.out.println("Coleção colocada em exposição.");
            }
            else{
                System.out.println("Opção inválida!");
            }
        }
    }

    private static void consultarPeca(String nomePeca, String nomeColecao) throws Exception {
        Peca peca = museu.consultarPeca(nomePeca, nomeColecao);
        if (peca == null) {
            throw new Exception("Combinação de chaves inválida, por favor consulte a listagem de coleções e pecas.");
        }
        System.out.println(peca);
    }

    /* Testes já implementados */
    /* Setup do museu */
    private static void testarMuseu() throws Exception {
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

        System.out.println("Cadastrando 10 funcionários");
        museu.contratarFuncionario("Lucas", 10000000000l, 2234.4f, "guia", "Setor 1");
        museu.contratarFuncionario("João Pedro", 99999999999l, 2343.4f, "guia", "Setor 2");
        museu.contratarFuncionario("Eduardo", 88888888888l, 1222.4f, "guia", "Setor 3");
        museu.contratarFuncionario("Igor", 77777777777l, 1233.6f, "guia", "Setor 1");
        museu.contratarFuncionario("João", 66666666666l, 5555.5f, "guia", "Setor 2");
        museu.contratarFuncionario("Cristina", 55555555555l, 12000.9f, "guia", "Setor 3");
        museu.contratarFuncionario("Pedro", 44444444444l, 5000.6f, "guia", "Setor 1");
        museu.contratarFuncionario("Glaucia", 33333333333l, 4000.5f, "guia", "Setor 2");
        museu.contratarFuncionario("Raquel", 22222222222l, 3000.98f, "guia", "Setor 3");
        museu.contratarFuncionario("Eder", 11111111111l, 4448.05f, "guia", "Setor 1");

        System.out.println(museu.listarFuncionarios());
    }

    public static void main(String[] args) throws Exception {
        String opcao;
        do{
            mainMenu();
            opcao = scan.nextLine();
            switch (opcao){
                case "1":
                    try{
                        MenuRegistrar();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case "2":
                    try{
                        MenuExcluir();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case "3":
                    try{
                        MenuListar();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case "4":
                    try{
                        MenuConsultar();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case "6":
                    try{
                        MenuGerarRelatorio();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case "5":
                    try{
                        MenuAlterar();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case "-5":
                    try{
                        testarMuseu();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
            }
        }while(!opcao.equals("0"));
    }
}