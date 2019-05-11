import java.util.*;

public class Main{
    private static Museu museu = new Museu();
    private static Scanner scan = new Scanner(System.in);
    private static Data data = new Data(12, 5, 2019);

    private static void mainMenu(){
        System.out.println ("|-----------------------------------|\n" +
                            "|MENU:                              |\n" +
                            "|1.Registrar visita                 |\n" +
                            "|2.Registrar peça                   |\n" + //Ainda não implementado
                            "|3.Registrar coleção                |\n" + //Ainda não implementado
                            "|4.Registrar funcionário            |\n" + //Ainda não implementado
                            "|5.Excluir funcionário              |\n" + //Ainda não implementado
                            "|6.Excluir Coleção                  |\n" + //Ainda não implementado
                            "|7.Gerar relatório de obras         |\n" + //Ainda não implementado
                            "|8.Gerar relatório de visitantes    |\n" + //Ainda não implementado
                            "|0.Sair                             |\n" + //Ainda não implementado
                            "|-----------------------------------|\n" );
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
            if(read != "-1"){
                if(setor != null){
                    setoresVisitados.add(setor);
                }
                else{
                    System.out.println("Setor inválido\n");
                }
            }
        } while (!read.equals("-1"));
        Visita visita = new Visita(data, setoresVisitados);
        museu.registrarVisitante(nomeVisitante, cpf, visita);
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
                    System.out.println("Nome da peça a ser registrada");
                    String nomeObra = scan.nextLine();
                    System.out.println("Ano de criação da peça a ser registrada");
                    int anoDeCriacao = scan.nextInt();
                    System.out.println("Ano de aquisição da peça a ser registrada");
                    int anoDeAquisicao = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Estado de conservação da peça a ser registrada");
                    String estado = scan.nextLine();

                break;
                case "3":
                    
                break;
                case "4":
                    
                break;
                case "5":
                    
                break;
                case "6":
                    
                break;
                case "7":
                    
                break;
                case "8":
                    
                break;
                case "0":
                    scan.close();
                break;
                default:
            }
        }while(!opcao.equals("0"));
    }
}
