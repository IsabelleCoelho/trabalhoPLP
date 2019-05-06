import java.util.*;

public class Visita {
    private ArrayList<Setor> listaSetores;
    private Data dataVisitacao;
    private Visitante pessoaVisitante;

    public Visita(Data dataVisitacao, listaSetoresVisitados
                  Visitante pessoaVisitante){
        this.dataVisitacao = dataVisitacao;
        this.listaSetores = new ArrayList<Setor>();
        this.pessoaVisitante = pessoaVisitante;
    }

    public boolean adicionarSetorVisitado(Setor umSetor){
        return listaSetores.add(umSetor);
    }
}
