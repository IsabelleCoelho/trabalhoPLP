import java.util.*;
public class Colecao{
	private int quantidadeDeObras;
	private ArrayList<Peca> pecas;
	public Acervo(){
		this.quantidadeDeObras = 0;
		pecas = new ArrayList<Peca>();
	}
	public bolean adicionarPeca(Peca umaPeca){
		return pecas.add(umaPeca);
	}
	public bolean removerPeca(String get.NomeObra()){

	}
	@Overwrite
	public toString(){
		String out = "Peças da Coleção";
		for(Peca peca : pecas){
			out += peca.getNomeObra();
			out += "\n";
			return out;
		} 
	}

}
