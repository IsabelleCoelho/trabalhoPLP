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
}
