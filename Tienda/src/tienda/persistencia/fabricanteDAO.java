package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.fabricante;

public class fabricanteDAO extends DAO {

    public List<fabricante> listaFabricante() throws Exception {
        try {
            String sql = "SELECT codigo, nombre FROM fabricante";

            consultarBase(sql);

            fabricante fabricante = null;
            List<fabricante> fabricantes = new ArrayList<>();

            while (resultado.next()) {

                fabricante = new fabricante();

                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));

                fabricantes.add(fabricante);

            }

            return fabricantes;

        } catch (Exception e) {
            System.out.println("Error en lista tienda de (fabricanteDAO");
            throw new Exception("Error landa un catch metodo");

        } finally {
            desconectarBase();
        }

    }

}
