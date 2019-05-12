import java.util.*;

public class Main{
    private static Museu museu = new Museu();
    private static Scanner scan = new Scanner(System.in);
    private static Data data = new Data(12, 5, 2019);

    private static void mainMenu(){
        System.out.println ("|------------------------------------|\n" +
                            "|MENU:                               |\n" +
                            "|1.  Registrar visita                |\n" +
                            "|2.  Registrar coleção               |\n" + //Ainda não implementado
                            "|3.  Registrar peça                  |\n" + //Testar
                            "|4.  Registrar funcionário           |\n" + //Ainda não implementado
                            "|5.  Excluir funcionário             |\n" + //Ainda não implementado
                            "|6.  Excluir coleção                 |\n" + //Ainda não implementado
                            "|7.  Listar funcionários             |\n" + //Ainda não implementado
                            "|8.  Consultar visitante             |\n" +
                            "|9.  Consultar coleção               |\n" +
                            "|10. Consultar peça                  |\n" +
                            "|11. Consultar funcionário           |\n" +
                            "|12. Gerar relatório de obras        |\n" + //Ainda não implementado
                            "|13. Gerar relatório de visitantes   |\n" + //Ainda não implementado
                            "|0.  Sair                            |\n" + //Ainda não implementado
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
    private static void adicionarColecao(String lido){
        Colecao colecao = museu.getColecao(lido);
        if (colecao != null) {
            System.out.println("Colecão já inserida");
        }
        else {
            museu.registrarColecao(new Colecao(lido));
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
    private static void consultarVisitante(String nomeConsultaVisitante, int CPFconsultaVisitante){
        Visitante visitante;
        visitante = museu.getVisitante(CPFconsultaVisitante);
        System.out.println(visitante.toString());
    }
    private static void consultarColecao(String nomeColecao){
        Colecao colecao;
        colecao = museu.getColecao(nomeColecao);
        System.out.println(colecao.toString());
    }
    private static void consultarFuncionario(int CPFfuncionario){
        Funcionario funcionario;
        funcionario = museu.getFuncionario(CPFfuncionario);
        System.out.println(funcionario.toString());
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
                    
                break;
                case "7":
                    System.out.println(museu.listarFuncionarios()); 
                break;
                case "8":
                    System.out.println("Nome do visitante a ser consultado");
                    String nomeConsultaVisitante = scan.nextLine();
                    System.out.println("CPF do visitante");
                    int CPFconsultaVisitante = scan.nextInt();
                    scan.nextLine();
                    consultarVisitante(nomeConsultaVisitante, CPFconsultaVisitante);
                break;
                case "9":
                    System.out.println("Nome da coleção a ser consultado");
                    String nomeColecao = scan.nextLine();
                    consultarColecao(nomeColecao);
                break;
                case "10":
                    System.out.println("Nome da peca a ser consultado");
                    String nomePeca = scan.nextLine();
                break;
                case "11":
                    System.out.println("CPF do funcionario");
                    int CPFconsultaFuncionario = scan.nextInt();
                    scan.nextLine();
                    consultarFuncionario(CPFconsultaFuncionario);
                break;
                case "12":

                break;
                case "13":

                break;
                case "0":
                    scan.close();
                break;
                default:
            }
        }while(!opcao.equals("0"));
    }
}
