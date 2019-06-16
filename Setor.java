import java.util.*;

public class Setor {

    private String tipoDeExibicao;
    private String nomeSetor;

    private ArrayList<Colecao> colecoes;

    public Setor(String tipoDeExibicao, String nomeSetor){
        this.tipoDeExibicao = tipoDeExibicao;
        this.nomeSetor = nomeSetor;
        this.colecoes = new ArrayList<Colecao>();
    }

    /** getters e setters da classe */
    public String getNomeSetor() {
        return nomeSetor;
    }

    public String getTipoDeExibicao() {
        return tipoDeExibicao;
    }
    public void setTipoDeExibicao(String tipoDeExibicao){
        this.tipoDeExibicao = tipoDeExibicao;
    }

    private Colecao getColecao(String nomeColecao){
        for (Colecao colecao : colecoes) {
            if(nomeColecao.equals(colecao.getNome())){
                return colecao;
            }
        }
        return null;
    }

    
    /** Método responsável por adiconar uma nova coleção */
    public boolean adicionarColecao(Colecao umaColecao) {
        return colecoes.add(umaColecao);
    }

    /** Método responsável por, a partir de um nome, remover uma coleção */
    public boolean removerColecao(String nomeColecao){
        Colecao colecao = getColecao(nomeColecao);
        if(colecao != null){
            return colecoes.remove(colecao);
        }
        return false;
    }

    /** Método responsável por converter o tipo das variáveis para mostra-las na tela */
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

    /** Método responsável por converter o tipo das variáveis para salvar no arquivo */
    public String toArchive(){
        return tipoDeExibicao + "\n" + nomeSetor + "\n";
    }
}