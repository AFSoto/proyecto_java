package com.biblioteca.gestion.app;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.biblioteca.gestion.model.Libro;
import com.biblioteca.gestion.service.LibroService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LibroService service = new LibroService();
        int option = -1;
        System.out.println("== SISTEMAS GESTION DE LIBROS ==");
        do {
            try {

                mostrarMenu();
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        agregarLibro(sc, service);
                        break;
                    case 2:
                        service.listarLibros();
                        break;
                    case 3:
                        System.out.println("ingrese titulo o autor o isbn");
                        sc.nextLine();
                        service.consultarLibro(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("ingrese el ISBN a eliminar");
                        sc.nextLine();
                        service.eliminarLibro(sc.nextLine());
                        break;
                    case 0:
                        System.out.println("opcion invalida");
                        break;
                
                    default:
                        System.out.println("opcion invalida");
                        break;
                }
                
            } catch (InputMismatchException i) {
                System.out.println("Error debe ingresar un numero");
            }catch(Exception e){
                System.out.println("Error inesperado: "+e.getMessage());
            }
            
        } while (option != 0);
        sc.close();
        System.out.println("=== PROGRAMA FINALIZADO ===");
    }

    private static void mostrarMenu(){
        System.out.println("== MENU DE LIBROS == ");
        System.out.println("1. agregar libro");
        System.out.println("2. consultar libros");
        System.out.println("3. sliminar libro");
        System.out.println("0. salir");
        System.out.println("selecione una opcion");
    }
    private static void agregarLibro(Scanner sc,LibroService service){

        try {
            sc.nextLine();
            System.out.println("ISBN");
            String isbn = sc.nextLine();

            System.out.println("TITULO");
            String titulo = sc.nextLine();

            System.out.println("AUTOR");
            String autor = sc.nextLine();

            Libro libro = new Libro(isbn, titulo, autor);
            service.agregarLibro(libro);

            System.out.println("libro agregado correctamente");
            
        } catch (InputMismatchException e) {
            System.out.println("Datos invalidos");
            sc.nextLine();
        }
        

    }

    
}
