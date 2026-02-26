package com.dev.energia.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

/**
 * Entidad que representa a un usuario del sistema.
 * <p>
 * Mapeada a la tabla {@code users} en la base de datos.
 * Gestiona la información de autenticación, autorización
 * y auditoría de cada usuario registrado en la plataforma.
 * </p>
 *
 * @author com.dev.energia
 * @version 1.0
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Identificador único del usuario, generado automáticamente
     * por la base de datos mediante una estrategia de autoincremento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de usuario único en el sistema.
     * No puede ser nulo ni repetirse entre usuarios.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Correo electrónico del usuario.
     * Debe ser único y no puede ser nulo.
     * Se utiliza como medio de contacto e identificación alternativa.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Contraseña del usuario almacenada de forma segura (hash).
     * Puede ser nula en casos donde el usuario se autentica
     * mediante un proveedor externo (OAuth, SSO, etc.).
     */
    @Column(nullable = true)
    private String password;

    /**
     * Rol asignado al usuario dentro del sistema.
     * Determina los permisos y accesos disponibles.
     * Se persiste como cadena de texto ({@link EnumType#STRING})
     * para mayor legibilidad en la base de datos.
     *
     * @see Role
     */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Marca de tiempo de creación del registro.
     * Asignada automáticamente por Hibernate al momento de la inserción.
     * Este campo es de solo lectura y no puede ser modificado posteriormente.
     */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Marca de tiempo de la última actualización del registro.
     * Actualizada automáticamente por Hibernate en cada modificación.
     */
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------

    /**
     * Constructor vacío requerido por la especificación JPA.
     * No debe utilizarse directamente en la lógica de negocio.
     */
    public User() {}

    // -------------------------------------------------------------------------
    // Getters y Setters
    // -------------------------------------------------------------------------

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return {@code Long} con el ID del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id ID a asignar al usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return {@code String} con el username del usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username Nombre de usuario a asignar.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return {@code String} con el email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email Correo electrónico a asignar.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}