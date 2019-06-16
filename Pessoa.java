public class Pessoa {
    private String nome;
    private Long cpf;

    public Pessoa(String nome, Long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

/** getters e setters da classe */
    public String getNome() {
        return nome;
    }

    public long getCpf(){
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Método responsável por converter o tipo das variáveis para mostra-las na tela */
    @Override
    public String toString() {
        return nome;
    }
}