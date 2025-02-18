package com.corales.stockBazarApp.venta.service;

import com.corales.stockBazarApp.producto.model.Producto;
import com.corales.stockBazarApp.venta.dto.VentaMayorDTO;
import com.corales.stockBazarApp.venta.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    void saveVenta(Venta venta);
    List<Venta> getAllVentas();
    Venta getVentaByCodigo(Long codigoVenta);
    void deleteVenta(Long codigoVenta);
    void updateVenta(Venta venta, Long codigoVenta);
    List<Producto> getAllVentaProducto(Long codigoProducto);
    double sumatoriaMonto(LocalDate fechaVenta);
    long cantidadTotal(LocalDate fechaVenta);
    VentaMayorDTO ventaMayorInfo();
}
