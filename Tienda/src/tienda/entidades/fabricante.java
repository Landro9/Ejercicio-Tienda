package tienda.entidades;

public class fabricante {

    protected Integer codigo;
    protected String nombre;

    public fabricante(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public fabricante() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "fabricante{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }

}
