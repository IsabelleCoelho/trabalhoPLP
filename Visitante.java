import java.util.ArrayList;
public class Visitante extends Pessoa {
    private String origem;
    private String interesse;
    private String faixaEtaria;
    private ArrayList<Visita> visitas;
    
    public Visitante(String nome, long cpf){
        super(nome, cpf);
        this.origem = null;
        this.interesse = null;
        this.faixaEtaria = null;
        this.visitas = new ArrayList<Visita>();
    }

    /** getters e setters da classe */
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }
    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    public String getOrigem() {
        return origem;
    }
    public String getInteresse() {
        return interesse;
    }
    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    /** Método responsável por adicionar uma nova visita */
    public void adicionarVisita(Visita visita){
        visitas.add(visita);
    }

    /** Método responsável por converter o tipo das variáveis para mostra-las na tela */
    @Override
    public String toString(){
        String out = "Visitante " + super.getNome() + " de CPF " + super.getCpf();
        if(origem != null && interesse != null && faixaEtaria != null){
            out += " oriundo de " + getOrigem() + ", cuja idade é ";
            out += getFaixaEtaria() + " anos, ";
            out += "possui interesse em " + getInteresse() + ".";
        }
        out += "\n" + "Visitou: \n";
        for (Visita visita : visitas) {
            out += visita.toString() + "\n" ;
        }
        return out;
    }

    /** Método responsável por converter o tipo das variáveis para salvar no arquivo */
    public String toArchive(){
        String out = getNome() + "\n" + getCpf() + "\n" + origem + "\n" + interesse + "\n" + faixaEtaria + "\n";
        out += visitas.size() + "\n";
        for (Visita visita : visitas) {
            out += visita.toArchive();
        }
        return out;
    }
    /** Método responsável por converter o tipo das variáveis para salvar no relatório */
    public String toForm(){
        String out = "Nome: " + getNome() + "\n" + "CPF: " + getCpf() + "\n" + "Origem: " + origem + "\n" + "Com interesse em: " + interesse + "\n" + "Idade: " + faixaEtaria + "\n";
        for (Visita visita : visitas) {
            out += visita.toForm();
        }
        out += "------" + "\n";
        return out;
    }
}