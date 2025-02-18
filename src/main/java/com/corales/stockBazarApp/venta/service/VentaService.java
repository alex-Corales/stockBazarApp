package com.corales.stockBazarApp.venta.service;

import com.corales.stockBazarApp.producto.model.Producto;
import com.corales.stockBazarApp.venta.dto.VentaMayorDTO;
import com.corales.stockBazarApp.venta.model.Venta;
import com.corales.stockBazarApp.venta.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository iVentaRepository;

    @Override
    public void saveVenta(Venta venta) {
        iVentaRepository.save(venta);
    }

    @Override
    public List<Venta> getAllVentas() {
        return iVentaRepository.findAll();
    }

    @Override
    public Venta getVentaByCodigo(Long codigoVenta) {
        return iVentaRepository.findById(codigoVenta).orElse(null);
    }

    @Override
    public void deleteVenta(Long codigoVenta) {
        iVentaRepository.deleteById(codigoVenta);
    }

    @Override
    public void updateVenta(Venta venta, Long codigoVenta) {
        Venta ventaAux = this.getVentaByCodigo(codigoVenta);
        ventaAux.setFechaVenta(venta.getFechaVenta());
        ventaAux.setTotal(venta.getTotal());
        this.saveVenta(ventaAux);
    }

    @Override
    public List<Producto> getAllVentaProducto(Long codigoProducto) {
        return iVentaRepository.getProductosDeVenta(codigoProducto);
    }

    public double sumatoriaMonto(LocalDate fechaVenta){
        return iVentaRepository.getVentaFecha(fechaVenta)
                .stream()
                .mapToDouble(Venta::getTotal)
                .sum();
    }

    public long cantidadTotal(LocalDate fechaVenta){
        return iVentaRepository.getVentaFecha(fechaVenta).stream().count();
    }

    public VentaMayorDTO ventaMayorInfo(){

        Venta venta = iVentaRepository.findTopByOrderByTotalDesc();
        VentaMayorDTO ventaMayorDTO = new VentaMayorDTO();

        ventaMayorDTO.setCodigoVenta(venta.getCodigoVenta());
        ventaMayorDTO.setTotal(venta.getTotal());
        ventaMayorDTO.setCatidadProductos(venta.getListaProductos().size());
        ventaMayorDTO.setNombreCliente(venta.getCliente().getNombre());
        ventaMayorDTO.setApellidoCliente(venta.getCliente().getApellido());

        return ventaMayorDTO;
    }

}
