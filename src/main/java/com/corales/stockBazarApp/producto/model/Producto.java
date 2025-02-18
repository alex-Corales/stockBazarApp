package com.corales.stockBazarApp.producto.model;

import com.corales.stockBazarApp.venta.model.Venta;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoProducto;
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotEmpty(message = "La marca no puede estar vacia")
    private String marca;
    @Min(value = 0, message = "El costo debe ser mayor a 0")
    private double costo;
    @Min(value = 0, message = "La cantidad disponible no puede ser menor a 0")
    private double cantidadDisponible;
}
