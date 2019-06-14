public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    public Data(String stringData){
        String[] data = stringData.split("/");
        this.dia = Integer.parseInt(data[0]);
        this.mes = Integer.parseInt(data[1]);
        this.ano = Integer.parseInt(data[2]);
    }

    public void setData(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    public int getDia() {
        return this.dia;
    }
    public int getMes() {
        return this.mes;
    }
    public int getAno() {
        return this.ano;
    }

    @Override
    public String toString(){
        return getDia() + "/" + getMes() + "/" + getAno();
    }
}