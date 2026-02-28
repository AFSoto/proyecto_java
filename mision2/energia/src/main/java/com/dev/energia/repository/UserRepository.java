
// La carpeta repository sirve como la capa de acceso a datos — es donde se define cómo tu aplicación se comunica con la base de datos.
// Cada archivo dentro de ella es una interfaz que extiende JpaRepository, lo que le dice a Spring que genere automáticamente las consultas SQL básicas (buscar, guardar, eliminar, listar) sin que tengas que escribirlas tú. Si necesitas una consulta personalizada, también la defines aquí.
// En resumen: es el puente entre tu código Java y la base de datos.



// Define el paquete donde se encuentra esta clase
package com.dev.energia.repository;

// Importa el modelo User que representa la entidad de usuario en la base de datos
import com.dev.energia.model.User;

// Optional permite manejar resultados que pueden o no existir, evitando NullPointerException
import java.util.Optional;

// JpaRepository provee métodos CRUD listos para usar (save, findById, findAll, delete, etc.)
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad User.
 * Al extender JpaRepository<User, Long>, le indicamos:
 *   - User → la entidad que maneja
 *   - Long → el tipo de dato de su clave primaria (ID)
 *
 * Spring genera automáticamente la implementación en tiempo de ejecución,
 * no es necesario escribir ninguna clase que implemente esta interfaz.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por su nombre de usuario (username).
     *
     * Spring Data JPA interpreta el nombre del método y genera la consulta SQL
     * equivalente de forma automática:
     *   SELECT * FROM users WHERE username = ?
     *
     * Retorna un Optional<User> porque el usuario puede o no existir:
     *   - Optional.of(user)    → si se encontró el usuario
     *   - Optional.empty()     → si no existe ningún usuario con ese username
     */
    Optional<User> findByUsername(String username);


    
}