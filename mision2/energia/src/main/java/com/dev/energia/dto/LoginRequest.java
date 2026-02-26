// Paquete donde se organiza este archivo dentro del proyecto
package com.dev.energia.dto;

/**
 * DTO (Data Transfer Object) para la solicitud de inicio de sesión.
 * 
 * No representa una tabla en la base de datos (no es una @Entity).
 * Su único rol es recibir los datos del login que llegan desde el cliente
 * (frontend, app, Postman, etc.) en formato JSON y mapearlos a un objeto Java.
 */
public class LoginRequest {

    // Almacena el nombre de usuario enviado en la petición
    private String username;

    // Almacena la contraseña enviada en la petición
    private String password;

    // ── Getters y Setters ──────────────────────────────────────────────────
    // Spring necesita estos métodos para poder leer y escribir los valores
    // al momento de deserializar el JSON entrante al objeto Java.

    // Getter: permite leer el valor de username desde otras clases
    public String getUsername() {
        return this.username;
    }

    // Setter: permite asignar el valor de username (lo usa Spring internamente)
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter: permite leer el valor de password desde otras clases
    public String getPassword() {
        return this.password;
    }

    // Setter: permite asignar el valor de password (lo usa Spring internamente)
    public void setPassword(String password) {
        this.password = password;
    }
}
