import java.io.*;
import java.util.*;

public class ArquivosMuseu{
    private String arqVisitante;
    private String arqFuncionario;
    private String arqSetores;
    private String arqColecaoPecas;

    private ArrayList<Visitante> visitantes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Setor> setores;
    private ArrayList<Colecao> colecoes;

    public ArquivosMuseu() {
        arqVisitante = "visitantes.txt";
        arqFuncionario = "funcionarios.txt"; 
        arqSetores = "setores.txt";
        arqColecaoPecas = "colecoes.txt";

        visitantes = new ArrayList<Visitante>();
        funcionarios = new ArrayList<Funcionario>();
        setores = new ArrayList<Setor>();
        colecoes = new ArrayList<Colecao>();
    }

    private Setor getSetor(String nomeSetor){
        for (Setor setor : setores) {
            if(nomeSetor.equals(setor.getNomeSetor())){
                return setor;
            }
        }
        return null;
    }

    private void carregarSetores() {
        try {
            FileReader arqLeitura = new FileReader(arqSetores);
            BufferedReader bufferLeitura = new BufferedReader(arqLeitura);
            int qtdSetores = Integer.getInteger(bufferLeitura.readLine());
            for (int i = 0; i < qtdSetores; i++) {
                String tipoDeExibicao = bufferLeitura.readLine();
                String nomeSetor = bufferLeitura.readLine();
                setores.add(new Setor(tipoDeExibicao, nomeSetor));
            }
            bufferLeitura.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void carregarVisitantes(){
        try{
            FileReader arqLeitura = new FileReader(arqVisitante);
            BufferedReader bufferLeitura = new BufferedReader(arqLeitura);
            int qtdVisitantes = Integer.getInteger(bufferLeitura.readLine());
            for (int i = 0; i < qtdVisitantes; i++) {
                String nome = bufferLeitura.readLine();
                long cpf = Long.getLong(bufferLeitura.readLine());
                Visitante visitante = new Visitante(nome, cpf);
                visitante.setOrigem(bufferLeitura.readLine());
                visitante.setInteresse(bufferLeitura.readLine());
                visitante.setFaixaEtaria(bufferLeitura.readLine());

                int qtdVisitas = Integer.getInteger(bufferLeitura.readLine());
                for (int k = 0; k < qtdVisitas; k++){
                    //Ler visitas
                    ArrayList<Setor> setoresList = new ArrayList<Setor>();
                    String nomeSetores = bufferLeitura.readLine();
                    String[] setores = nomeSetores.split(" % ");
                    for (int j = 0; j < setores.length; j++) {
                        setoresList.add(getSetor(setores[i]));
                    }
                    Data data = new Data(bufferLeitura.readLine());
                    visitante.adicionarVisita(new Visita(data, setoresList));
                }
                visitantes.add(visitante);
            }
            bufferLeitura.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    private void carregarFuncionarios() {
        try {
            FileReader arqLeitura = new FileReader(arqFuncionario);
            BufferedReader bufferLeitura = new BufferedReader(arqLeitura);
            int qtdFuncionarios = Integer.getInteger(bufferLeitura.readLine());
            for (int i = 0; i < qtdFuncionarios; i++) {
                String nome = bufferLeitura.readLine();
                long cpf = Long.getLong(bufferLeitura.readLine());
                float salario = Float.getFloat(bufferLeitura.readLine());
                String ocupacao = bufferLeitura.readLine();
                Setor trabalhaEm = getSetor(bufferLeitura.readLine());
                funcionarios.add(new Funcionario(nome, cpf, salario,
                                 ocupacao, trabalhaEm));
            }
            bufferLeitura.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void carregarColecoes() {
        try {
            FileReader arqLeitura = new FileReader(arqColecaoPecas);
            BufferedReader bufferLeitura = new BufferedReader(arqLeitura);
            int qtdColecoes = Integer.getInteger(bufferLeitura.readLine());
            for (int i = 0; i < qtdColecoes; i++) {
                String nome = bufferLeitura.readLine();
                boolean exposto = Boolean.getBoolean(bufferLeitura.readLine());
                Setor setor = getSetor(bufferLeitura.readLine());

                ArrayList<Peca> pecas = new Peca();
                int qtdPecas = Integer.getInteger(bufferLeitura.readLine());
                for (int j = 0; j < qtdPecas; i++) {
                    int anoDeCriacao = Integer.getInteger(bufferLeitura.readLine());
                    int anoDeAquisicao = Integer.getInteger(bufferLeitura.readLine());
                    String nomeObra = bufferLeitura.readLine();
                    String estado = bufferLeitura.readLine();
                    pecas.add(new Peca(anoDeCriacao,
                              anoDeAquisicao, nomeObra, estado));
                }
                colecoes.add(new Colecao(nome, exposto,
                             setor, pecas));
            }
            bufferLeitura.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public Museu caregar(){
        carregarSetores();
        carregarVisitantes();
        carregarFuncionarios();
        carregarColecoes();
        return new Museu(setores, visitantes, funcionarios, colecoes);
    }

    private void salvarSetores(ArrayList setores) {
        try {
            FileWriter arqEscrita = new FileWriter(arqSetores);
            BufferedWriter bufferEscrita = new BufferedWriter(arqEscrita);
            bufferEscrita.write(String.getString(setores.length));
            for (Setor setor : setores) {
                bufferEscrita.write(String.getString(setor));
            }
            bufferEscrita.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void salvarVisitantes(ArrayList visitantes) {
        try {
            FileWriter arqEscrita = new FileWriter(arqVisitante);
            BufferedWriter bufferEscrita = new BufferedWriter(arqEscrita);
            bufferEscrita.write(String.getString(visitantes.length));
            for (Setor visitante : visitantes) {
                bufferEscrita.write(String.getString(visitante));
            }
            bufferEscrita.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void salvarFuncionarios(ArrayList funcionarios) {
        try {
            FileWriter arqEscrita = new FileWriter(arqFuncionario);
            BufferedWriter bufferEscrita = new BufferedWriter(arqEscrita);
            bufferEscrita.write(String.getString(funcionarios.length));
            for (Setor funcionario : funcionarios) {
                bufferEscrita.write(String.getString(funcionario));
            }
            bufferEscrita.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void salvarColecoes(ArrayList colecoes) {
        try {
            FileWriter arqEscrita = new FileWriter(arqColecaoPecas);
            BufferedWriter bufferEscrita = new BufferedWriter(arqEscrita);
            bufferEscrita.write(String.getString(colecoes.length));
            for (Setor colecao : colecoes) {
                bufferEscrita.write(String.getString(colecao));
            }
            bufferEscrita.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void salvar(ArrayList setores, ArrayList visitantes,
                       ArrayList funcionarios, ArrayList colecoes) {
        salvarSetores(setores);
        salvarVisitantes(visitantes);
        salvarFuncionarios(funcionarios);
        salvarColecoes(colecoes);
    }
}