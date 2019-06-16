import java.util.*;

public class Visita {
    private ArrayList<Setor> listaSetores;
    private Data dataVisitacao;

    public Visita(Data dataVisitacao, ArrayList<Setor> listaSetoresVisitados){
        this.dataVisitacao = dataVisitacao;
        this.listaSetores = listaSetoresVisitados;
    }
    
    @Override
    public String toString() {
        String out = "Visita do dia: " + dataVisitacao.toString();
        for (Setor setor : listaSetores) {
            out += "\n" + setor.getNomeSetor();
        }
        return out;
    }
    public String toArchive(){
        String out = "";
        for (int i = 0; i < (listaSetores.size()-1); i++) {
            out += listaSetores.get(i).getNomeSetor() + " % ";
        }
        out += listaSetores.get(listaSetores.size()-1).getNomeSetor() + "\n";
        out += dataVisitacao.toString();
        return out;
    }
    public String toForm(){
        String out = "Setores visitados: ";
        for (int i = 0; i < (listaSetores.size()-1); i++) {
            out += listaSetores.get(i).getNomeSetor() + ", ";
        }
        out += listaSetores.get(listaSetores.size()-1).getNomeSetor() + "\n";
        out += "No dia: " + dataVisitacao.toString() + "\n";
        return out;
    }
}