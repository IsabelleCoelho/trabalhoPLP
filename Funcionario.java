public class Funcionario extends Pessoa {
    private float salario;
    private String ocupacao;
    private Setor trabalhaEm;

    public Funcionario(String nome, long cpf, float salario, String ocupacao, Setor setor){
        super(nome, cpf);
        this.salario = salario;
        this.ocupacao = ocupacao;
        this.trabalhaEm = setor;
    }
    public String getOcupacao() {
        return ocupacao;
    }
    @Override
    public String getNome() {
        return super.getNome();
    }
    public float getSalario() {
        return salario;
    }
    public Setor getTrabalhaEm() {
        return trabalhaEm;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public void setTrabalhaEm(Setor trabalhaEm) {
        this.trabalhaEm = trabalhaEm;
    }
    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }
    @Override
    public String toString(){
        String out = "Funcionário " + super.getNome() + " de CPF " + super.getCpf()+
        " trabalha como " + getOcupacao() + " no setor " + getTrabalhaEm() + ". Recebe " + getSalario();
        return out;
    }
    public String toArchive(){
        return getNome() + "\n" + getCpf() + "\n" + salario + "\n" + ocupacao + "\n" + trabalhaEm.getNomeSetor() + "\n";
    }
}
