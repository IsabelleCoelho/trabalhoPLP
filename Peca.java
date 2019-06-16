public class Peca {
    private int anoDeCriacao;
    private int anoDeAquisicao;
    private String nomeObra;
    private String estado;
    

    public Peca(String nomeObra, int anoDeCriacao, 
                int anoDeAquisicao, String estado) {
        this.nomeObra = nomeObra;
        this.anoDeCriacao = anoDeCriacao;
        this.anoDeAquisicao = anoDeAquisicao;
        this.estado = estado;
    }

    /** getters e setters da classe */
    public String getNomeObra() {
        return nomeObra;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setNomeObra(String nomeObra) {
        this.nomeObra = nomeObra;
    }
    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }
    public int getAnoDeAquisicao() {
        return anoDeAquisicao;
    }

    /** Método responsável por converter o tipo das variáveis para mostra-las na tela */
    @Override
    public String toString(){
        return "A peça " + nomeObra + " adquirida no ano " + anoDeAquisicao + " foi criada no ano " + anoDeCriacao + ", cujo estado é " + estado + ".";
    }

    /** Método responsável por converter o tipo das variáveis para salvar no arquivo */
    public String toArchive(){
        return anoDeCriacao + "\n" + anoDeAquisicao + "\n" + nomeObra + "\n" + estado + "\n";
    }
    public String toForm(){
        String out = "Nome da obra: " + nomeObra + "\n" + "Está em estado: " + estado + "\n";
        out += "Foi criado em: " + anoDeCriacao + "\n";
        out += "Foi adquirido em: " + anoDeAquisicao + "\n";
        out += "---" + "\n";
        return out;
    }
}