package paqueteprincipal;

/**
 *
 * @author a18luisdvp
 */
public class SalaCine {

    int aforo;
    int ocupadas;
    String pelicula;
    double entrada;

    public SalaCine() {
        aforo = 100;
        ocupadas = 0;
        pelicula = "";
        entrada = 5.0;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public void setOcupadas(int ocupadas) {
        this.ocupadas = ocupadas;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public void setLibres(int libres) {
        int ocu;
        ocu = aforo - libres;
        ocupadas = ocu;
    }

    public int getAforo() {
        return aforo;
    }

    public int getOcupadas() {
        return ocupadas;
    }

    public String getPelicula() {
        return pelicula;
    }

    public double getEntrada() {
        return entrada;
    }

    public int getLibres() {
        int lib;
        lib = aforo - ocupadas;
        return lib;
    }

    public double getPorcentaje() {
        double porcentaje;
        porcentaje = (double) ocupadas / (double) aforo * 100.0;
        return porcentaje;
    }
    
    public double getIngresos() {        
        double ingresos;        
        ingresos = ocupadas * entrada;        
        return ingresos;    
    }
    
    public void Vaciar() {
        ocupadas = 0;
        pelicula = "";
    }
    
    public void entraUno(){
        ocupadas++;
    }
}
