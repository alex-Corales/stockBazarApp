package com.corales.stockBazarApp.venta.model;

import com.corales.stockBazarApp.cliente.model.Cliente;
import com.corales.stockBazarApp.producto.model.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private Double total;
    @OneToMany
    private List<Producto> listaProductos;
    @OneToOne
    private Cliente cliente;
}
