import java.util.*;
public class Colecao{
    private ArrayList<Peca> pecas;
    private String nome;
    private boolean exposto;

    public Colecao(String nome){
        pecas = new ArrayList<Peca>();
        this.exposto = false;
        this.nome = nome;
    }
    public int getQuantidadeDePecas(){
        return pecas.size();
    }
    public String getNome(){
        return nome;
    }
    public void setExposto(boolean exposto){
        this.exposto = exposto;
    }
    public boolean isExposto(){
        return exposto;
    }
    public boolean adicionarPeca(Peca umaPeca){
        return pecas.add(umaPeca);
    }
    public boolean removerPeca(String nomeObra){
        for (Peca peca : pecas) {
            if(peca.getNomeObra().equals(nomeObra)){
                pecas.remove(peca);
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        String out = "Peças da Coleção " + nome + ":\n" ;
        for(Peca peca : pecas){
            out += peca.getNomeObra() + "\n";
        } 
        return out;
    }
}
