package com.corales.stockBazarApp.venta.repository;

import com.corales.stockBazarApp.producto.model.Producto;
import com.corales.stockBazarApp.venta.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT p FROM Venta v JOIN v.listaProductos p WHERE v.codigoVenta = :codigoVenta")
    List<Producto> getProductosDeVenta(@Param("codigoVenta") Long codigoVenta);

    @Query("SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta")
    List<Venta> getVentaFecha(@Param("fechaVenta") LocalDate fechaVenta);

    Venta findTopByOrderByTotalDesc();

}
