package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.producto;

public class productoDAO extends DAO {

    public List<producto> listaProducto() throws Exception {

        try {
            String sql = "SELECT codigo, nombre, precio, codigo_fabricante "
                    + "FROM producto";

            consultarBase(sql);

            producto producto = null;
            List<producto> productos = new ArrayList<>();

            while (resultado.next()) {
                producto = new producto();

                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));

                productos.add(producto);

            }

            return productos;

        } catch (Exception e) {
            System.out.println("Error en lista tienda de (productoDAO");
            throw new Exception("Error landa un catch metodo");

        } finally {
            desconectarBase();
        }

    }

}
