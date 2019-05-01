import java.util.*;
public class Colecao{
	private ArrayList<Peca> pecas;
	private String nome;
	private boolean exposto;

	public Colecao(String nome){
		pecas = new ArrayList<Peca>();
		this.exposto = False;
		this.nome = nome;
	}
	public int getQuantidadeDePecas(){
		return pecas.size();
	}
	public getNome(){
		return nome;
	}
	public void setExposto(boolean exposto){
		this.exposto = exposto;
	}
	public boolean isExposto(){
		return exposto;
	}
	public bolean adicionarPeca(Peca umaPeca){
		return pecas.add(umaPeca);
	}
	public bolean removerPeca(String nomeObra){
		for (Peca peca : pecas) {
			if(peca.getNomeObra().equals(nomeObra)){
				pecas.remove(peca);
				return True;
			}
		}
		return False;
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
