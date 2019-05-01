import java.util.*;
public class Visitante extends Pessoa {
	private ArrayList<Visita> listaVisitas;
	public Visitante(String nome, int cpf){
		super(nome, cpf);
		listaVisitas = new ArrayList<Visita>();
	}
	public boolean adicionarVisita(Visita umaVisita){
		return listaVisitas.add(umaVisita);
	}

}
