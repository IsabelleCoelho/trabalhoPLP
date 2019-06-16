public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data(String data){
        String[] dataAux = data.split("/");
        dia = Integer.parseInt(dataAux[0]);
        mes = Integer.parseInt(dataAux[1]);
        ano = Integer.parseInt(dataAux[2]);
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