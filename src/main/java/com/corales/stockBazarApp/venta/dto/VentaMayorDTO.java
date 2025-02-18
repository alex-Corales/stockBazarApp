package com.corales.stockBazarApp.venta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaMayorDTO {
    private Long codigoVenta;
    private double total;
    private int catidadProductos;
    private String nombreCliente;
    private String apellidoCliente;
}
