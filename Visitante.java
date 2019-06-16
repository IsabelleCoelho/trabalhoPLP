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
    public void adicionarVisita(Visita visita){
        visitas.add(visita);
    }

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

    @Override
    public String toString(){
        String out = "Visitante " + super.getNome() + " de CPF " + super.getCpf();
        if(origem != null && interesse != null && faixaEtaria != null){
            out += " oriundo de " + getOrigem() + " ";
            out += getFaixaEtaria() + " anos de idade ";
            out += "Com interesse em " + getInteresse();
        }
        out += " Visitou: \n";
        for (Visita visita : visitas) {
            out += visita.toString();
        }
        return out;
    }
    public String toArchive(){
        String out = getNome() + "\n" + getCpf() + "\n" + origem + "\n" + interesse + "\n" + faixaEtaria + "\n";
        out += visitas.size() + "\n";
        for (Visita visita : visitas) {
            out += visita.toArchive();
        }
        return out;
    }
}