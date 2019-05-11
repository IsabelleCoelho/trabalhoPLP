import java.util.*;

public class Main{
    private static Museu museu = new Museu();
    private static Scanner scan = new Scanner(System.in);
    private static void mainMenu(){
        System.out.println ("|-----------------------------------|\n" +
                            "|MENU:                              |\n" +
                            "|1.Registrar visita                 |\n" +
                            "|2.Registrar obra                   |\n" + //Ainda não implementado
                            "|3.Registrar coleção                |\n" + //Ainda não implementado
                            "|4.Registrar funcionário            |\n" + //Ainda não implementado
                            "|5.Excluir funcionário              |\n" + //Ainda não implementado
                            "|6.Excluir Coleção                  |\n" + //Ainda não implementado
                            "|7.Gerar relatório de obras         |\n" + //Ainda não implementado
                            "|8.Gerar relatório de visitantes    |\n" + //Ainda não implementado
                            "|9.Sair                             |\n" + //Ainda não implementado
                            "|-----------------------------------|\n" );
    }

    private static void adicionarVisitante(String nomeVisitante, int cpf){
        System.out.println("Quais setores " + nomeVisitante + " visitou?");
        System.out.println("Digite o nome dos setores visitados seguido de enter e para finalizar a inserção digite -1");
        System.out.println(museu.listarSetores());
        ArrayList<Setor> setoresVisitados = new ArrayList<Setor>();
        String read;
        do {
            read = scan.nextLine();
        } while (!read.equals("-1"));
    }
    public static void main(String[] args) {
        
        int opcao;
        do{
            mainMenu();
            opcao = scan.nextInt();
            switch (opcao){
                case 1:
                    String nomeVisitante = scan.nextLine();
                    int cpfVisitante = scan.nextInt();
                    adicionarVisitante(nomeVisitante, cpfVisitante);
                break;
                case 2:
                    
                break;
                case 3:
                    
                break;
                case 4:
                    
                break;
                case 5:
                    
                break;
                case 6:
                    
                break;
                case 7:
                    
                break;
                case 8:
                    
                break;
                case 9:
                    scan.close();
                break;
                default:
            }
        }while(opcao != 9);
        
    }
}
