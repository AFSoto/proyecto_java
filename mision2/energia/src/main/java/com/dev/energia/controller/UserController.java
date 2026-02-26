// ¿Para qué sirve este archivo?
// Es la capa Controller, el punto de entrada de la aplicación. Recibe las peticiones HTTP que llegan desde el cliente (navegador, app, Postman) y las delega al servicio. Define las rutas/endpoints de la API.

package com.dev.energia.controller;

import com.dev.energia.service.UserService;
import com.dev.energia.dto.LoginRequest;
import com.dev.energia.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// @RestController indica que esta clase maneja peticiones HTTP y que
// cada método retorna datos directamente en formato JSON (no vistas HTML)
@RestController

// Define la ruta base para todos los endpoints de este controlador
// Todos empezarán con /api/users
@RequestMapping("/api/users")
public class UserController {

    // Dependencia al servicio que contiene la lógica de negocio
    private final UserService userService;

    // Inyección de dependencias por constructor (práctica recomendada)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * POST /api/users
     * Crea un nuevo usuario con los datos recibidos en el cuerpo de la petición.
     * @RequestBody convierte automáticamente el JSON entrante en un objeto User.
     * Retorna el usuario creado con el código HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.crearUsuario(user));
    }

    /**
     * GET /api/users
     * Retorna la lista completa de usuarios registrados.
     * Responde con código HTTP 200 (OK) automáticamente.
     */
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    /**
     * GET /api/users/{id}
     * Busca un usuario por su ID.
     * @PathVariable extrae el {id} de la URL y lo convierte a Long.
     * Si no existe, lanza una excepción que responde con 404 (Not Found).
     */
    @GetMapping("/{id}")
    public User findByID(@PathVariable Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuario no encontrado"));
    }

    /**
     * PUT /api/users/{id}
     * Actualiza los datos de un usuario existente.
     * Recibe el ID por la URL y los nuevos datos en el cuerpo (JSON).
     * Retorna el usuario ya actualizado con código 200 (OK).
     */
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.update(id, userDetails);
    }

    /**
     * POST /api/users/login
     * Autentica a un usuario con sus credenciales (username y password).
     * Recibe un LoginRequest (DTO) con esos datos en el cuerpo.
     * Retorna un mensaje de éxito con código 200 (OK).
     * ⚠️ En producción debería retornar un token JWT en lugar de un String.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}