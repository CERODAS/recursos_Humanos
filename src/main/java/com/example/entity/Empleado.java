package com.example.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    public int persona_id;
    public int puesto_id;
    private boolean status;
    private int usuario_creacion;
    @Column(name = "usuario_modificacion", nullable = true)
    private Integer usuario_modificacion;  
    @Column(name = "fecha_creacion", updatable = false, nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "fecha_modificacion", nullable = false)
    private LocalDateTime fechaModificacion = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
    	fechaCreacion = LocalDateTime.now();
    	fechaModificacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
    	fechaModificacion = LocalDateTime.now();
    }

}
