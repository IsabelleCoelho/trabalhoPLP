import java.util.*;
public class Visitante extends Pessoa {
	private ArrayList<Visita> listaVisitas;
	public Visitante(String nome){
		super(nome);
		listaVisitas = new ArrayList<Visita>();
	}
	public bolean adicionarVisita(Visita umaVisita){
		return listaVisitas.add(umaVisita);
	}

}
