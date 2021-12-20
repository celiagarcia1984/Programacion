package MisClases;

public class Circunferencia {
    private int radio;

    public Circunferencia(int radio) {
        this.radio = radio;
    }

    public Circunferencia() {
    }


    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public double CalcularLongitud(){

        double longitud = 0;
        longitud = 2*Math.PI*radio;

        return longitud;
    }

    public double CalcularArea(){
        double area = 0;
        area = Math.PI * (radio^2);

        return area;
    }

    public double CalcularVolumen(){
        double volumen = 0;
        volumen = (4*Math.PI * radio* radio*radio/3);

        return volumen;
    }
}
