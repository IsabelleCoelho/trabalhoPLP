public class Peca {
    private int anoDeCriacao;
    private int anoDeAquisicao;
    private String nomeObra;
    private String estado;
    

    public Peca(String nomeObra, int anoDeCriacao, int anoDeAquisicao, String estado) {
        this.nomeObra = nomeObra;
        this.anoDeCriacao = anoDeCriacao;
        this.anoDeAquisicao = anoDeAquisicao;
        this.estado = estado;
    }
    public String getNomeObra() {
        return nomeObra;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }
    public int getAnoDeAquisicao() {
        return anoDeAquisicao;
    }
    @Override
    public String toString(){
        return "A peça " + nomeObra + " adquirida no ano " + anoDeAquisicao + " foi criada no ano " + anoDeCriacao;
    }

    public String toArchive(){
        return anoDeCriacao + "\n" + anoDeAquisicao + "\n" + nomeObra + "\n" + estado + "\n";
    }
}
