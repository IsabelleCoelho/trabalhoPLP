import java.util.*;
public class Acervo {
	private int quantidadeDeObras;
	private ArrayList<Peca> pecas;
	public Acervo(){
		this.quantidadeDeObras = 0;
		pecas = new ArrayList<Peca>();
	}
	@Overwrite
	public toString(){
		String out = "Peças do Acervo ";
		for(Peca peca : pecas){
			out += peca.getNomeObra();
			out += "\n";
			return out;
		} 
	}
}
