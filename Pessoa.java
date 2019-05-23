public class Pessoa {
    private String nome;
    private Long cpf;

    public Pessoa(String nome, Long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public long getCpf(){
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
