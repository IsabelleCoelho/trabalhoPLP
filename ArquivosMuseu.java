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
            int qtdSetores = Integer.parseInt(bufferLeitura.readLine());
            for (int i = 0; i < qtdSetores; i++) {
                String tipoDeExibicao = bufferLeitura.readLine();
                String nomeSetor = bufferLeitura.readLine();
                setores.add(new Setor(tipoDeExibicao, nomeSetor));
            }
            bufferLeitura.close();
            arqLeitura.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void carregarVisitantes(){
        try{
            FileReader arqLeitura = new FileReader(arqVisitante);
            BufferedReader bufferLeitura = new BufferedReader(arqLeitura);
            int qtdVisitantes = Integer.parseInt(bufferLeitura.readLine());
            for (int i = 0; i < qtdVisitantes; i++) {
                String nome = bufferLeitura.readLine();
                long cpf = Long.parseLong(bufferLeitura.readLine());
                Visitante visitante = new Visitante(nome, cpf);
                visitante.setOrigem(bufferLeitura.readLine());
                visitante.setInteresse(bufferLeitura.readLine());
                visitante.setFaixaEtaria(bufferLeitura.readLine());

                int qtdVisitas = Integer.parseInt(bufferLeitura.readLine());
                for (int k = 0; k < qtdVisitas; k++){
                    //Ler visitas
                    ArrayList<Setor> setoresList = new ArrayList<Setor>();
                    String nomeSetores = bufferLeitura.readLine();
                    String[] setores = nomeSetores.split(" % ");
                    for (int j = 0; j < setores.length; j++) {
                        setoresList.add(getSetor(setores[j]));
                    }
                    Data data = new Data(bufferLeitura.readLine());
                    visitante.adicionarVisita(new Visita(data, setoresList));
                }
                visitantes.add(visitante);
            }
            bufferLeitura.close();
            arqLeitura.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    private void carregarFuncionarios() {
        try {
            FileReader arqLeitura = new FileReader(arqFuncionario);
            BufferedReader bufferLeitura = new BufferedReader(arqLeitura);
            int qtdFuncionarios = Integer.parseInt(bufferLeitura.readLine());
            for (int i = 0; i < qtdFuncionarios; i++) {
                String nome = bufferLeitura.readLine();
                long cpf = Long.parseLong(bufferLeitura.readLine());
                float salario = Float.parseFloat(bufferLeitura.readLine());
                String ocupacao = bufferLeitura.readLine();
                Setor trabalhaEm = getSetor(bufferLeitura.readLine());
                funcionarios.add(new Funcionario(nome, cpf, salario, ocupacao, trabalhaEm));
            }
            bufferLeitura.close();
            arqLeitura.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void carregarColecoes() {
        try {
            FileReader arqLeitura = new FileReader(arqColecaoPecas);
            BufferedReader bufferLeitura = new BufferedReader(arqLeitura);
            int qtdColecoes = Integer.parseInt(bufferLeitura.readLine());
            for (int i = 0; i < qtdColecoes; i++) {
                String nome = bufferLeitura.readLine();
                boolean exposto = Boolean.parseBoolean(bufferLeitura.readLine());
                Setor setor = null;
                if (exposto) {
                    setor = getSetor(bufferLeitura.readLine());    
                }
                ArrayList<Peca> pecas = new ArrayList<Peca>();
                int qtdPecas = Integer.parseInt(bufferLeitura.readLine());
                for (int j = 0; j < qtdPecas; j++) {
                    int anoDeCriacao = Integer.parseInt(bufferLeitura.readLine());
                    int anoDeAquisicao = Integer.parseInt(bufferLeitura.readLine());
                    String nomeObra = bufferLeitura.readLine();
                    String estado = bufferLeitura.readLine();
                    Peca peca = new Peca(nomeObra, anoDeCriacao, anoDeAquisicao, estado);
                    pecas.add(peca);
                }
                Colecao colecao = new Colecao(nome, exposto, setor, pecas);
                colecoes.add(colecao);
                if (exposto) {
                    setor.adicionarColecao(colecao);    
                }
            }
            bufferLeitura.close();
            arqLeitura.close();
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
        return new Museu(visitantes, funcionarios, setores, colecoes);
    }

    private void salvarSetores(ArrayList<Setor> setores) {
        try {
            FileWriter arqEscrita = new FileWriter(arqSetores);
            BufferedWriter bufferEscrita = new BufferedWriter(arqEscrita);
            bufferEscrita.write(String.valueOf(setores.size()));
            bufferEscrita.newLine();
            for(Setor setor : setores) {
                bufferEscrita.write(setor.toArchive());
            }
            bufferEscrita.close();
            arqEscrita.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void salvarVisitantes(ArrayList<Visitante> visitantes) {
        try {
            FileWriter arqEscrita = new FileWriter(arqVisitante);
            BufferedWriter bufferEscrita = new BufferedWriter(arqEscrita);
            bufferEscrita.write(String.valueOf(visitantes.size()));
            bufferEscrita.newLine();
            for (Visitante visitante : visitantes) {
                bufferEscrita.write(visitante.toArchive());
            }
            bufferEscrita.close();
            arqEscrita.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void salvarFuncionarios(ArrayList<Funcionario> funcionarios) {
        try {
            FileWriter arqEscrita = new FileWriter(arqFuncionario);
            BufferedWriter bufferEscrita = new BufferedWriter(arqEscrita);
            bufferEscrita.write(String.valueOf(funcionarios.size()));
            bufferEscrita.newLine();
            for (Funcionario funcionario : funcionarios) {
                bufferEscrita.write(funcionario.toArchive());
            }
            bufferEscrita.close();
            arqEscrita.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void salvarColecoes(ArrayList<Colecao> colecoes) {
        try {
            FileWriter arqEscrita = new FileWriter(arqColecaoPecas);
            BufferedWriter bufferEscrita = new BufferedWriter(arqEscrita);
            bufferEscrita.write(String.valueOf(colecoes.size()));
            bufferEscrita.newLine();
            for (Colecao colecao : colecoes) {
                bufferEscrita.write(colecao.toArchive());
            }
            bufferEscrita.close();
            arqEscrita.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void salvar(ArrayList<Setor> setores, ArrayList<Visitante> visitantes, ArrayList<Funcionario> funcionarios, ArrayList<Colecao> colecoes) {
        salvarSetores(setores);
        salvarVisitantes(visitantes);
        salvarFuncionarios(funcionarios);
        salvarColecoes(colecoes);
    }
}