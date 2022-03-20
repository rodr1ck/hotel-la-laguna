package com.hotelresort.lalaguna.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@ApiModel(description = "Información o propiedades del pasajero")
@Entity
@Table(name = "Pasajero")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer pasajeroId;

    @ApiModelProperty(notes = "pasajeroNombre debe tener como minimo 3 caracteres y un maximo de 150 caracteres")
    @Column(name = "pasajero_nombre", length = 150)
    @Size(min = 3, max = 150, message = "El nombre del pasajero tiene un minimo de 3 y un maximo de 150 caracteres")
    @NotNull(message= "pasajeroNombre: no puede ser nulo")
    private String pasajero_nombre;

    @ApiModelProperty(notes = "nacionalidad debe tener como minimo 3 caracteres y un maximo de 150 caracteres")
    @Column(name = "nacionalidad", length = 150)
    @Size(min = 3, max = 150, message = "La nacionalidad del pasajero tiene un minimo de 3 y un maximo de 150 caracteres")
    private String nacionalidad;

    @ApiModelProperty(notes = "fechaIngreso se requiere un valor mayor a cero")
    @Column(name = "fecha_ingreso", length = 150)
    @NotNull(message= "fechaIngreso: se requiere un valor mayor a cero")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_ingreso;


    @ApiModelProperty(notes = "fecha_salida se requiere un valor mayor a cero")
    @Column(name = "fecha_salida", length = 150)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_salida;

    @ApiModelProperty(notes = "numero_habitacion se requiere un valor mayor a cero")
    @Column(name = "numero_habitacion", length = 150)
    @NotNull(message= "numero_habitacion: se requiere un valor mayor a cero")
    @Min(value=1, message="numero_habitacion: se requiere un valor mayor a cero")
    private Integer numero_habitacion;

    @ApiModelProperty(notes = "tipo_paquete se requiere un valor mayor a cero")
    @Column(name = "tipo_paquete", length = 150)
    @NotNull(message= "tipo_paquete: se requiere un valor mayor a cero")
    @Min(value=1, message="tipo_paquete: se requiere un valor mayor a cero")
    private Integer tipo_paquete;


    public Integer getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Integer pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPasajero_nombre() {
        return pasajero_nombre;
    }

    public void setPasajero_nombre(String pasajero_nombre) {
        this.pasajero_nombre = pasajero_nombre;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Integer getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(Integer numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public Integer getTipo_paquete() {
        return tipo_paquete;
    }

    public void setTipo_paquete(Integer tipo_paquete) {
        this.tipo_paquete = tipo_paquete;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
}
