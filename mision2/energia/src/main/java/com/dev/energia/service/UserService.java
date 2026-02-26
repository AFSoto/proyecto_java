package com.dev.energia.service;

import com.dev.energia.dto.LoginRequest;
import com.dev.energia.exception.ResourceNotFoundException;
import com.dev.energia.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.dev.energia.repository.UserRepository;

/**
 * Servicio que contiene la lógica de negocio para gestionar usuarios.
 *
 * 
 */
@Service
public class UserService {

    // Repositorio para interactuar con la tabla de usuarios en la base de datos
    private final UserRepository userRepository;

    // Herramienta para encriptar y verificar contraseñas de forma segura (ej: BCrypt)
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor: Spring inyecta automáticamente las dependencias
     * (Inyección de dependencias por constructor, práctica recomendada).
     */
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Crea y guarda un nuevo usuario en la base de datos.
     * Antes de guardarlo, encripta su contraseña para no almacenarla en texto plano.
     */
    public User crearUsuario(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // encripta la contraseña
        return userRepository.save(user); // guarda el usuario y lo retorna con su ID generado
    }

    /**
     * Retorna la lista completa de usuarios registrados en la base de datos.
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Busca un usuario por su ID.
     * Retorna Optional<User> porque el usuario puede o no existir.
     */
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Actualiza los datos de un usuario existente.
     * Solo actualiza los campos que vienen con valor (no sobreescribe con datos vacíos).
     */
    public User update(long id, User userDetails) {

        // Busca el usuario; si no existe lanza una excepción en lugar de retornar null
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Solo actualiza el username si viene con un valor no vacío
        if (userDetails.getUsername() != null && !userDetails.getUsername().trim().isEmpty()) {
            user.setUsername(userDetails.getUsername());
        }

        // Solo actualiza el email si viene con un valor no vacío
        if (userDetails.getEmail() != null && !userDetails.getEmail().trim().isEmpty()) {
            user.setEmail(userDetails.getEmail());
        }

        // Solo actualiza la contraseña si viene con valor, y la encripta antes de guardarla
        if (userDetails.getPassword() != null && !userDetails.getPassword().trim().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }

        // Solo actualiza el rol si viene con valor
        if (userDetails.getRole() != null) {
            user.setRole(userDetails.getRole());
        }

        // Guarda los cambios en la base de datos y retorna el usuario actualizado
        return userRepository.save(user);
    }

    /**
     * Verifica las credenciales de un usuario para el inicio de sesión.
     * 
     * ⚠️ Nota: en una app real esto debería retornar un token JWT
     * en lugar del String "Login correcto".
     */
    public String login(LoginRequest request) {

        // Busca el usuario por su username usando el DTO recibido
        Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());

        // Si no existe, lanza excepción
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        User user = optionalUser.get(); // extrae el usuario del Optional

        // Compara la contraseña ingresada con la contraseña encriptada almacenada
        // passwordEncoder.matches() encripta la ingresada y las compara de forma segura
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResourceNotFoundException("Contraseña incorrecta");
        }

        return "Login correcto"; // ⚠️ idealmente aquí se retornaría un token JWT
    }
}