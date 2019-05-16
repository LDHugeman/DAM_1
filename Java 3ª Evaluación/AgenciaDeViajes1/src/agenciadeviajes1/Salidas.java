package agenciadeviajes1;

public class Salidas {
    public void Salir (int numeroPersonas, int tipoReserva, float precioDia, int dias, float precioFinal){
        if (tipoReserva==1 || tipoReserva==2){
            if(tipoReserva==1){
                
                if(numeroPersonas==1 || numeroPersonas==2){
                    precioDia = 40;
                }
                else if(numeroPersonas==3 || numeroPersonas==4){
                    precioDia = 70;
                }
                else if(numeroPersonas==5 || numeroPersonas==6){
                    precioDia = 100;
                }
                else if(numeroPersonas>=7){
                    precioDia = 150;
                }
                precioFinal = precioDia * dias;
                System.out.println("Reservado un apartamento para "+numeroPersonas+".\n"
                        + "Precio total a pagar: "+precioFinal+" euros.");
            }
            else if(tipoReserva==2){
                precioFinal = (numeroPersonas+dias)*25;
                System.out.println("Reservada una vivienda unifamiliar para "+numeroPersonas+".\n"
                        + "Precio total a pagar: "+precioFinal+" euros.");
            }
        }else{
            System.err.println("Error, esta no opción no es correcta");
        }
        
       
    }
}