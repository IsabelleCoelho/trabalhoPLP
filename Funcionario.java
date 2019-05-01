public class Funcionario extends Pessoa {
	private int cpf;
	private float salario;
	private String ocupacao;
	private Setor trabalhaEm;

	public Funcionario(String nome, int cpf, float salario, String ocupacao, Setor setor){
		super(nome);
		this.cpf = cpf;
		this.salario = salario;
		this.ocupacao = ocupacao;
		this.trabalhaEm = setor;
	}
	/**
	 * @return the ocupacao
	 */
	public String getOcupacao() {
		return ocupacao;
	}
	@Override
	public String getNome() {
		return super.getNome();
	}
	/**
	 * @return the cpf
	 */
	public int getCpf() {
		return cpf;
	}
	/**
	 * @return the salario
	 */
	public float getSalario() {
		return salario;
	}
	/**
	 * @return the trabalhaEm
	 */
	public Setor getTrabalhaEm() {
		return trabalhaEm;
	}
	/**
	 * @param salario the salario to set
	 */
	public void setSalario(float salario) {
		this.salario = salario;
	}
	/**
	 * @param trabalhaEm the trabalhaEm to set
	 */
	public void setTrabalhaEm(Setor trabalhaEm) {
		this.trabalhaEm = trabalhaEm;
	}
	/**
	 * @param ocupacao the ocupacao to set
	 */
	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
}