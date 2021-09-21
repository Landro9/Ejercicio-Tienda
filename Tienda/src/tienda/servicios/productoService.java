package tienda.service;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import tienda.entidades.producto;
import tienda.persistencia.productoDAO;

public class productoService {

    private productoDAO dao;

    public productoService() {
        this.dao = new productoDAO();
    }

    public List<producto> crearListaProducto() throws Exception {

        try {
            List<producto> listaProductos = dao.listaProducto();

            return listaProductos;

        } catch (Exception e) {
            throw new Exception("Nose pudo crear lista producto");
        }

    }

    public void imprimirProducto() throws Exception {

        try {
            List<producto> listaProductos = dao.listaProducto();
            if (listaProductos.isEmpty()) {
                throw new Exception("Lista producto vacia");
            } else {
                for (producto u : listaProductos) {
                    System.out.print("Codigo " + u.getCodigo() + ", ");
                    System.out.print("Nombre " + u.getNombre() + ", ");
                    System.out.print("Precio " + u.getPrecio() + ", ");
                    System.out.print("Codigo Fabricante " + u.getCodigo_fabricante());
                    System.out.println("");
                }

            }

        } catch (Exception e) {
            System.out.println("Error imprimir producto");
        }

    }

    public void imprimirNombreProd() {
        try {
            List<producto> listaProductos = dao.listaProducto();
            if (listaProductos.isEmpty()) {
                throw new Exception("Lista producto vacia");
            } else {
                for (producto u : listaProductos) {
                    System.out.print("Nombre " + u.getNombre());
                    System.out.println("");
                }

            }

        } catch (Exception e) {
            System.out.println("Error imprimir producto");
        }

    }

    public void imprimirPricio() {

        try {
            List<producto> listaProductos = dao.listaProducto();
            if (listaProductos.isEmpty()) {
                throw new Exception("Lista producto vacia");
            } else {
                for (producto u : listaProductos) {
                    System.out.print("Nombre " + u.getNombre() + ", ");
                    System.out.print("Precio " + u.getPrecio());
                    System.out.println("");
                }

            }

        } catch (Exception e) {
            System.out.println("Error imprimir producto");
        }
    }

    public void productosRango() {

        try {
            List<producto> listaProductos = dao.listaProducto();
            if (listaProductos.isEmpty()) {
                throw new Exception("Lista producto vacia");
            } else {
                for (producto u : listaProductos) {
                    if (u.getPrecio() >= 120 && u.getPrecio() <= 202) {
                        System.out.print("Codigo " + u.getCodigo() + ", ");
                        System.out.print("Nombre " + u.getNombre() + ", ");
                        System.out.print("Precio " + u.getPrecio() + ", ");
                        System.out.print("Codigo Fabricante " + u.getCodigo_fabricante());
                        System.out.println("");
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("Error imprimir producto");
        }

    }

    public void imprimirPortatiles() {
        try {
            List<producto> listaProductos = dao.listaProducto();
            if (listaProductos.isEmpty()) {
                throw new Exception("Lista producto vacia");
            } else {
                for (producto u : listaProductos) {
                    if (u.getNombre().contains("Portátil")) {
                        System.out.print("Codigo " + u.getCodigo() + ", ");
                        System.out.print("Nombre " + u.getNombre() + ", ");
                        System.out.print("Precio " + u.getPrecio() + ", ");
                        System.out.print("Codigo Fabricante " + u.getCodigo_fabricante());
                        System.out.println("");
                    }

                }
            }

        } catch (Exception e) {
            System.out.println("Error imprimir producto");
        }
    }

    public void imprimirBarato() {

        try {
            List<producto> listaProductos = dao.listaProducto();
            listaProductos.sort(comaparadorMenor);
            if (listaProductos.isEmpty()) {
                throw new Exception("Lista producto vacia");
            } else {
                for (producto u : listaProductos) {
                    System.out.print("Codigo " + u.getCodigo() + ", ");
                    System.out.print("Nombre " + u.getNombre() + ", ");
                    System.out.print("Precio " + u.getPrecio() + ", ");
                    System.out.print("Codigo Fabricante " + u.getCodigo_fabricante());
                    System.out.println("");
                    break;
                }

            }

        } catch (Exception e) {
            System.out.println("Error imprimir producto");
        }

    }

    public static Comparator<producto> comaparadorMenor = new Comparator<producto>() {
        @Override
        public int compare(producto o1, producto o2) {
            return o1.getPrecio().compareTo(o2.getPrecio());
        }
    };

    public void ingresarProd() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            List<producto> listaProductos = dao.listaProducto();
            producto nuevo = new producto();

            System.out.println("Ingresa el nombre del producto.");
            nuevo.setNombre(leer.next());
            System.out.println("Ingresa el codigo del producto.");
            nuevo.setCodigo(leer.nextInt());
            System.out.println("Ingresa el precio del producto.");
            nuevo.setPrecio(leer.nextDouble());
            System.out.println("Ingresa el codigo del fabricante del producto.");
            nuevo.setCodigo_fabricante(leer.nextInt());
            System.out.println("");

            listaProductos.add(nuevo);

            for (producto u : listaProductos) {
                System.out.print("Codigo " + u.getCodigo() + ", ");
                System.out.print("Nombre " + u.getNombre() + ", ");
                System.out.print("Precio " + u.getPrecio() + ", ");
                System.out.print("Codigo Fabricante " + u.getCodigo_fabricante());
                System.out.println("");

            }
        } catch (Exception e) {
        }

    }

    public void editarProd() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        int buscar;

        try {
            List<producto> listaProductos = dao.listaProducto();
            if (listaProductos.isEmpty()) {
                throw new Exception("Lista producto vacia");
            } else {
                System.out.println("Ingrese el codigo del producto a modificar.");
                buscar = leer.nextInt();
                System.out.println("");
                for (producto u : listaProductos) {
                    if (u.getCodigo().equals(buscar)) {
                        System.out.print("Codigo " + u.getCodigo() + ", ");
                        System.out.print("Nombre " + u.getNombre() + ", ");
                        System.out.print("Precio " + u.getPrecio() + ", ");
                        System.out.print("Codigo Fabricante " + u.getCodigo_fabricante());
                        System.out.println("");
                    }

                    System.out.println("");
                    System.out.println("Ingresa el nombre del producto.");
                    u.setNombre(leer.next());
                    u.setCodigo(buscar);
                    System.out.println("Ingresa el precio del producto.");
                    u.setPrecio(leer.nextDouble());
                    System.out.println("Ingresa el codigo del fabricante del producto.");
                    u.setCodigo_fabricante(leer.nextInt());
                    System.out.println("");

                    listaProductos.add(u);
                    
                    System.out.print("Codigo " + u.getCodigo() + ", ");
                    System.out.print("Nombre " + u.getNombre() + ", ");
                    System.out.print("Precio " + u.getPrecio() + ", ");
                    System.out.print("Codigo Fabricante " + u.getCodigo_fabricante());
                    System.out.println("");
                    break;
                }
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println("Error imprimir producto");
        }

    }

}
//        public static Comparator <CLASE> comaparadorMenor = new Comparator<CLASE>(){
//            @Override
//            public int compare(CLASE o1, CLASE o2){
//                return o1.getAtributo().compareTo(o2.getAtributo());
//            }
//        };
