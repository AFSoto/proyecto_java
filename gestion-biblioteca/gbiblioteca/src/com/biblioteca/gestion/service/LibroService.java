package com.biblioteca.gestion.service;
import java.util.ArrayList;
import com.biblioteca.gestion.model.Libro;

public class LibroService {
    private ArrayList<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro){
        libros.add(libro);
        System.out.println("libro añadido exitosamente");
    }

    public void listarLibros(){
        if (libros.isEmpty()) {
            System.out.println("no hay libros registrados");
        }
        for(Libro l : libros){
            l.resumen();
        }
    }

    public void eliminarLibro(String isb){
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isb)) {
                libros.remove(i);
                System.out.println("libro eliminado correctamente");
                return;
            }
        }
        System.out.println("libro no encontrado");
    }

    public void consultarLibro(String valor){
        for(Libro l : libros){
            if (l.getIsbn().equals(valor)) {
                System.out.println(l.resumen());
                return;
            }
            if (l.getTitulo().equals(valor)) {
                System.out.println(l.resumen());
            }
            if (l.getAutor().equals(valor)) {
                System.out.println(l.resumen());
            }
        }
        System.out.println("libro no encontrado");
    }
}
