
package puestotrabajo;

/**
 *
 * @author a18luisdvp
 */
public class Persona {
    private byte edad;
    private String estudios;
    private byte nota;
    private String acceso;
    private String bachillerato;
    private String cicloSuperior;
    
    public Persona (byte edad, String estudios, byte nota){
        this.edad = edad;
        this.estudios = estudios;
        this.nota = nota;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public byte getNota() {
        return nota;
    }

    public void setNota(byte nota) {
        this.nota = nota;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }
    
    private void averiguarAcceso(){
        if(edad>=18){
        }else{
            acceso = "No puede acceder al puesto por ser menor de edad";
        }else if(estudios = "Bachillerato" || estudios = "Ciclo Superior" ){
                
                }
    }
}
