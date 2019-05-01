public class Peca {
	private int anoDeCriacao;
	private int anoDeAquisicao;
	private String nomeObra;
	private String estado;

	public Peca(int anoDeCriacao, int anoDeAquisicao,
				String nomeObra, String estado) {
		this.anoDeCriacao = anoDeCriacao;
		this.anoDeAquisicao = anoDeAquisicao;
		this.nomeObra = nomeObra;
		this.estado = estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Sring getNomeObra() {
		return nomeObra;
	}
	@Override
	public String toString(){
		return "A peça " + nomeObra + " adquirida no ano " + anoDeAquisicao + " foi criada no ano " + anoDeCriacao;
	}
}
