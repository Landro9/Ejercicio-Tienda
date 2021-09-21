package tienda.service;

import java.util.List;
import java.util.Scanner;
import tienda.entidades.fabricante;
import tienda.persistencia.fabricanteDAO;

public class fabricanteService {

    private fabricanteDAO dao;

    public fabricanteService() {
        this.dao = new fabricanteDAO();
    }

    public List<fabricante> crearFabricantes() throws Exception {
        try {
            List<fabricante> listaFabricantes = dao.listaFabricante();
            return listaFabricantes;

        } catch (Exception e) {
            throw new Exception("Nose pudo crear lista fabricante");
        }

    }

    public void ImprimirFabricantes() throws Exception {

        try {
            List<fabricante> listaFabricantes = dao.listaFabricante();

            if (listaFabricantes.isEmpty()) {
                throw new Exception("Lista fabricante vacia");
            } else {
                for (fabricante u : listaFabricantes) {
                    System.out.print("Codigo " + u.getCodigo() + ", ");
                    System.out.print("Nombre " + u.getNombre());
                    System.out.println("");

                }
            }

        } catch (Exception e) {
            System.out.println("Error imprimir fabricante");

        }

    }

    public void ingresarFarb() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            List<fabricante> listaFabricantes = dao.listaFabricante();
            fabricante nuevo = new fabricante();

            System.out.println("Ingresa el nombre del fabricante.");
            nuevo.setNombre(leer.next());
            System.out.println("Ingresa el codigo del fabricante.");
            nuevo.setCodigo(leer.nextInt());
            System.out.println("");

            listaFabricantes.add(nuevo);

            if (listaFabricantes.isEmpty()) {
                throw new Exception("Lista fabricante vacia");
            } else {
                for (fabricante u : listaFabricantes) {
                    System.out.print("Codigo " + u.getCodigo() + ", ");
                    System.out.print("Nombre " + u.getNombre());
                    System.out.println("");
                }

            }

        } catch (Exception e) {
            System.out.println("Error imprimir fabricante");

        }

    }

}
