
package Clases;


 // @author

public class C_Empresa {
    
    private static final int tamMax=140;
    
    private String cif;
    private String razonSocial;
    private String direccion;
    private String telefono;
    
    
    public C_Empresa () {}
    
    public C_Empresa (String cif, String razonSocial, String direccion, String telefono) {
        
        this.cif=cif;
        this.razonSocial=razonSocial;
        this.direccion=direccion;
        this.telefono=telefono;
        
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTamañoMax() {
        return tamMax;
    }
    
    public int getTamañoReal() {
        
        return this.cif.length()*2+this.razonSocial.length()*2+this.direccion.length()*2+this.telefono.length()*2+2+2;
    }
    
}
