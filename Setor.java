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

	/** Adicionanda uma nova peça a um setor */
	public void adicionarColecao(Colecao umaColecao) {
		colecoes.add(umaColecao);
	}

	public String getNomeSetor() {
		return nomeSetor;
	}

	public String getTipoDeExibicao() {
		return tipoDeExibicao;
	}
	public void setTipoDeExibicao(String tipoDeExibicao){
		this.tipoDeExibicao = tipoDeExibicao;
	}

	@Override
	public String toString(){
		String out = "Setor " + nomeSetor + " exibe ";
		if(tipoDeExibicao.equals("temporario")){
			out = out + " temporariamente ";
		}
		for (Colecao umaColecao : colecoes) {
			out = out + umaColecao.getNome() + "\n";
		}
		return out;
	}
}
