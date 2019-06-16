import java.util.*;
public class Colecao{
    private ArrayList<Peca> pecas;
    private String nome;
    private boolean exposto;
    private Setor setor;

    public Colecao(String nome){
        pecas = new ArrayList<Peca>();
        this.exposto = false;
        this.nome = nome;
        this.setor = null;
    }
    public Colecao(String nome, boolean exposto, Setor setor, ArrayList<Peca> pecas) {
        this.nome = nome;
        this.exposto = exposto;
        this.setor = setor;
        this.pecas = pecas;
    }
    
    public int getQuantidadeDePecas(){
        return pecas.size();
    }
    public String getNome(){
        return nome;
    }
    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    public Setor getSetor() {
        return setor;
    }
    public void setExposto(boolean exposto){
        this.exposto = exposto;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public boolean isExposto(){
        return exposto;
    }
    public boolean retirarExposto(){
        return this.exposto = false;
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

    public Peca getPeca(String nomePeca){
        for (Peca peca : pecas) {
            if (nomePeca.equals(peca.getNomeObra())) {
                return peca;
            }
        }
        return null;
    }
    public String toArchive(){
        String out = nome + "\n" + exposto + "\n";;
        if (exposto) {
            out += setor.getNomeSetor() + "\n";    
        }
        out += pecas.size() + "\n";
        for (Peca peca : pecas) {
            out += peca.toArchive();
        }
        return out;
    }

    public String toForm(){
        String out = "Nome da coleção: " + nome + "\n";
        if (exposto) {
            out += "Está no setor: " + setor.getNomeSetor() + "\n";
        } else {
            out += "Não está em um setor" + "\n";
        }
        out += "Com: " + pecas.size() + "obras" + "\n";
        for (Peca peca : pecas) {
            out += peca.toForm();
        }
        return out;
    }
}