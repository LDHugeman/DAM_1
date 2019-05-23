package objetos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David
 */
public class EmpleadoTemporal extends Empleado {

    private Date fechaInicio;
    private Date fechaFin;
    private float pagoDia;
    private ArrayList<Venta> ventas;

    public EmpleadoTemporal(String dni, String nombre, String telefono, float porcentajeRetencion, String cifEmpresa, Date fechaInicio, Date fechaFin, float pagoDia) {
        super(dni, nombre, telefono, porcentajeRetencion, cifEmpresa);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pagoDia = pagoDia;
        this.ventas = new ArrayList<>();
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public String getStringFechaInicio(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fechaInicio);
    }
    
    public String getStringFechaFin(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fechaFin);
    }

    public float getPagoDia() {
        return pagoDia;
    }

    public void setPagoDia(float pagoDia) {
        this.pagoDia = pagoDia;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public float calculoNomina() {
        return (pagoDia * obtenerDiasTrabajados()) - (pagoDia * obtenerDiasTrabajados() * super.getPorcentajeRetencion());
    }

    private long obtenerDiasTrabajados() {
        final long MILISEGUNDOS_DIA = 1000 * 60 * 60 * 24;
        long fechaInicioMS = fechaInicio.getTime();
        long fechaFinMs = fechaFin.getTime();
        return (fechaFinMs - fechaInicioMS) / MILISEGUNDOS_DIA;
    }
}
