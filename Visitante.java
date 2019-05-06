import java.util.*;
public class Visitante extends Pessoa {
    private String origem;
    private String interesse;
    private String faixaEtaria;
    
    public Visitante(String nome, int cpf,
                     String origem, String interesse, String faixaEtaria){
        super(nome, cpf);
        this.origem = origem;
        this.interesse = interesse;
        this.faixaEtaria = faixaEtaria;
    }

}
