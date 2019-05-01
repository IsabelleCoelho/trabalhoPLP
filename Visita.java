import java.util.*;

public class Visita {

	private Visitante visitante;
	private ArrayList<Setor> listaSetores;
	private Data dataVisitacao;

	public Visita(Visitante visitante,Data dataVisitacao){
		this.visitante = visitante;
		this.dataVisitacao = dataVisitacao;
		this.listaSetores = new ArrayList<Setor>();
	}

	public boolean adicionarSetorVisitado(Setor umSetor){
		return listaSetores.add(umSetor);
	}
}
