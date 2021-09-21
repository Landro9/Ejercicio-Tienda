package tienda;

import java.util.Scanner;
import tienda.service.fabricanteService;
import tienda.service.productoService;

public class Tienda {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        int op;
        boolean salir = true;

        productoService productoService = new productoService();
        fabricanteService fabricanteService = new fabricanteService();

        try {
            while (salir == true) {
                System.out.println("1- Lista el nombre de todos los productos que hay en la tabla producto.");
                System.out.println("2- Lista los nombres y los precios de todos los productos de la tabla producto.");
                System.out.println("3- Listar aquellos productos que su precio esté entre 120 y 202.");
                System.out.println("4- Buscar y listar todos los Portátiles de la tabla producto.");
                System.out.println("5- Listar el nombre y el precio del producto más barato.");
                System.out.println("6- Ingresar un producto a la base de datos.");
                System.out.println("7- Ingresar un fabricante a la base de datos.");
                System.out.println("8- Editar un producto con datos a elección.");
                System.out.println("9- Salir");
                System.out.println("");
                System.out.println("Ingrese una opcion.");
                op = leer.nextInt();
                System.out.println("");
                switch (op) {
                    case 1:
                        productoService.imprimirNombreProd();
                        System.out.println("");
                        break;
                    case 2:
                        productoService.imprimirPricio();
                        System.out.println("");
                        break;
                    case 3:
                        productoService.productosRango();
                        System.out.println("");
                        break;
                    case 4:
                        productoService.imprimirPortatiles();
                        System.out.println("");
                        break;
                    case 5:
                        productoService.imprimirBarato();
                        System.out.println("");
                        break;
                    case 6:
                        productoService.ingresarProd();
                        System.out.println("");
                        break;
                    case 7:
                        fabricanteService.ingresarFarb();
                        System.out.println("");
                        break;
                    case 8:
                        productoService.editarProd();
                        break;
                    case 9:
                        salir = false;
                        break;
                }

            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
