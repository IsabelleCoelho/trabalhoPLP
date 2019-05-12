import java.util.*;

public class Main{
    private static Museu museu = new Museu();
    private static Scanner scan = new Scanner(System.in);
    private static Data data = new Data(12, 5, 2019);

    private static void mainMenu(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU:                               |\n" +
                            "|1.  Registrar visita                |\n" +
                            "|2.  Registrar coleção               |\n" + 
                            "|3.  Registrar peça                  |\n" + 
                            "|4.  Registrar funcionário           |\n" + 
                            "|5.  Excluir funcionário             |\n" + 
                            "|6.  Excluir coleção                 |\n" + 
                            "|7.  Listar funcionários             |\n" +
                            "|8.  Listar visitantes               |\n" +
                            "|9.  Listar coleções                 |\n" + 
                            "|10. Consultar visitante             |\n" +
                            "|11. Consultar coleção               |\n" +
                            "|12. Consultar peça                  |\n" +
                            "|13. Consultar funcionário           |\n" +
                            "|14. Gerar relatório de obras        |\n" + 
                            "|15. Gerar relatório de visitantes   |\n" + 
                            "|0.  Sair                            |\n" + 
                            "|------------------------------------|\n" );
    }

    private static void adicionarVisitante(String nomeVisitante, int cpf){
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

    private static void removerFuncionario(int cpf){
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
    private static void consultarVisitante(String nomeConsultaVisitante, int CPFconsultaVisitante){
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
    private static void consultarFuncionario(int CPFfuncionario){
        Funcionario funcionario;
        funcionario = museu.getFuncionario(CPFfuncionario);
        if(funcionario != null){
            System.out.println(funcionario.toString());
        }
        else{
            System.out.println("Funcionario não registrado.");
        }
        
    }

    private static void consultarPeca(String nomePeca, String nomeColecao){
        Peca peca = museu.consultarPeca(nomePeca, nomeColecao);
        if (peca != null) {
            System.out.println(peca);
        }
        System.out.println("Combinação de chaves inválida, por favor consulte a listagem de coleções e pecas");
    }

    public static void main(String[] args) {
        String opcao;
        do{
            mainMenu();
            opcao = scan.nextLine();
            switch (opcao){
                case "1":
                    System.out.println("Nome do visitante a ser registrado");
                    String nomeVisitante = scan.nextLine();
                    System.out.println("CPF do visitante a ser registrado");
                    int cpfVisitante = scan.nextInt();
                    scan.nextLine();
                    adicionarVisitante(nomeVisitante, cpfVisitante);
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
                    
                break;
                case "5":
                    System.out.println("CPF do funcionário a ser excluído");
                    int cpf = scan.nextInt();
                    removerFuncionario(cpf);
                break;
                case "6":
                    System.out.println("Nome da coleção a ser removida");
                    String nome = scan.nextLine();
                    removerColecao(nome);
                break;
                case "7":
                    System.out.println(museu.listarFuncionarios());
                break;
                case "8":
                    System.out.println(museu.listarVisitantes());
                break;
                case "9":
                    System.out.println(museu.listarColecoes());
                    
                break;
                case "10":
                    System.out.println("Nome do visitante a ser consultado");
                    String nomeConsultaVisitante = scan.nextLine();
                    System.out.println("CPF do visitante");
                    int CPFconsultaVisitante = scan.nextInt();
                    scan.nextLine();
                    consultarVisitante(nomeConsultaVisitante, CPFconsultaVisitante);
                break;
                case "11":
                    System.out.println("Nome da coleção a ser consultado");
                    String nomeColecao = scan.nextLine();
                    consultarColecao(nomeColecao);
                break;
                case "12":
                    System.out.println("Nome da peca a ser consultado:");
                    String nomePeca = scan.nextLine();
                    System.out.println("Nome da coleção onde a peça se encontra:");
                    String nomeColecao_consultaObra = scan.nextLine();
                    consultarPeca(nomePeca, nomeColecao_consultaObra);
                break;
                case "13":
                    System.out.println("CPF do funcionario");
                    int CPFconsultaFuncionario = scan.nextInt();
                    scan.nextLine();
                    consultarFuncionario(CPFconsultaFuncionario);
                break;
                case "14":
                    System.out.println("Ainda não implementado");
                break;
                case "15":
                    System.out.println("Ainda não implementado");
                break;
                case "0":
                    scan.close();
                break;
                default:
            }
        }while(!opcao.equals("0"));
    }
}
