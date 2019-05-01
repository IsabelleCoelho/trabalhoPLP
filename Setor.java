import java.util.*;

public class Setor {

	private String tipoDeExibicao;
	private String nomeSetor;

	private ArrayList<Colecao> colecoes;

	/** Definindo o construtor */
	public Setor(String tipoDeExibicao, String nomeSetor){
		this.tipoDeExibicao = tipoDeExibicao;
		this.nomeSetor = nomeSetor;
		this.colecoes = new ArrayList<Colecao>();
	}

	/** Adicionando uma nova peça a um setor */
	public void adicionarPeca(Colecao umaColecao) {
		colecoes.add(umaColecao);
	}

	@Override
	public String toString(){
		String out = "Setor " + nomeSetor + " exibe ";
		if(tipoDeExibicao.equals("temporario")){
			out = out + " temporariamente ";
		}
		for (Colecao umaColecao : colecoes) {
			out = out + umaColecao.nomeColecao + "\n";
		}
		return out;
	}
}
