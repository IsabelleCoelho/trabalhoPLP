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
    

    /** getters e setters da classe */
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

    public Peca getPeca(String nomePeca){
        for (Peca peca : pecas) {
            if (nomePeca.equals(peca.getNomeObra())) {
                return peca;
            }
        }
        return null;
    }

    /** Método responsável por retornar se a peça está exposta ou não */
    public boolean isExposto(){
        return exposto;
    }

    /** Método reponsável por retirar uma peça de exposição */
    public boolean retirarExposto(){
        return this.exposto = false;
    }

    /** Método responsável por adicionar uma nova peça */
    public boolean adicionarPeca(Peca umaPeca){
        return pecas.add(umaPeca);
    }

    /** Método responsável por remover uma paça, utilizando como base um nome */
    public boolean removerPeca(String nomeObra){
        for (Peca peca : pecas) {
            if(peca.getNomeObra().equals(nomeObra)){
                pecas.remove(peca);
                return true;
            }
        }
        return false;
    }

    /** Método responsável por converter o tipo das variáveis para mostra-las na tela */
    @Override
    public String toString(){
        System.out.println("Estado da coleção: ");
        if (exposto == false) {
            System.out.println("Não exposta.");
        }
        else{
            System.out.println("Exposta.");
        }
        String out = "Peças da Coleção " + nome + ":\n" ;
        for(Peca peca : pecas){
            out += peca.getNomeObra() + "\n";
        } 
        return out;
    }



    /** Método responsável por converter o tipo das variáveis para salvar no arquivo */
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
        out += "Com: " + pecas.size() + " obras" + "\n";
        for (Peca peca : pecas) {
            out += peca.toForm();
        }
        out += "------" + "\n";
        return out;
    }
}