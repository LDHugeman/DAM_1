package objetos;

/**
 *
 * @author David
 */
public class Producto {

    private String codigo;
    private String descripcionArticulo;
    private int stockAlmacen;
    private float precioUnitario;
    private String cifEmpresa;

    public Producto(String codigo, String descripcionArticulo, int stockAlmacen, float precioUnitario, String cifEmpresa) {
        this.codigo = codigo;
        this.descripcionArticulo = descripcionArticulo;
        this.stockAlmacen = stockAlmacen;
        this.precioUnitario = precioUnitario;
        this.cifEmpresa = cifEmpresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    } 

    public int getStockAlmacen() {
        return stockAlmacen;
    }

    public void setStockAlmacen(int stockAlmacen) {
        this.stockAlmacen = stockAlmacen;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCifEmpresa() {
        return cifEmpresa;
    }

    public void setCifEmpresa(String cifEmpresa) {
        this.cifEmpresa = cifEmpresa;
    }
    
    public void calcularStock(int unidadesVendidas){
       stockAlmacen = stockAlmacen - unidadesVendidas;
    }
}
