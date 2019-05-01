import java.util.*;

public class Visita {
	private ArrayList<Setor> listaSetores;
	private Data dataVisitacao;

	public Visita(Data dataVisitacao){
		this.dataVisitacao = dataVisitacao;
		this.listaSetores = new ArrayList<Setor>();
	}

	public boolean adicionarSetorVisitado(Setor umSetor){
		return listaSetores.add(umSetor);
	}
}
