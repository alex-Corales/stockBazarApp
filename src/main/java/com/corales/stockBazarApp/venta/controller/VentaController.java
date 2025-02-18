package com.corales.stockBazarApp.venta.controller;

import com.corales.stockBazarApp.producto.model.Producto;
import com.corales.stockBazarApp.venta.dto.VentaMayorDTO;
import com.corales.stockBazarApp.venta.model.Venta;
import com.corales.stockBazarApp.venta.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService iVentaService;

    @PostMapping("/crear")
    public ResponseEntity<?> saveVenta(@RequestBody Venta venta){
        iVentaService.saveVenta(venta);
        return ResponseEntity.ok("La venta se guardo correctamente");
    }

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas(){
        return ResponseEntity.ok(iVentaService.getAllVentas());
    }

    @GetMapping("/{codigoVenta}")
    public ResponseEntity<Venta> getVentaByCodigo(@PathVariable Long codigoVenta){
        return ResponseEntity.ok(iVentaService.getVentaByCodigo(codigoVenta));
    }

    @DeleteMapping("/eliminar/{codigoVenta}")
    public ResponseEntity<?> deleteVentaByCodigo(@PathVariable Long codigoVenta){
        iVentaService.deleteVenta(codigoVenta);
        return ResponseEntity.ok("La venta se elimino con exito");
    }

    @PutMapping("/editar/{codigoVenta}")
    public ResponseEntity<?> updateVenta(@RequestBody Venta venta, @PathVariable Long codigoVenta){
        iVentaService.updateVenta(venta, codigoVenta);
        return ResponseEntity.ok("La venta se actualizo con exito");
    }

    @GetMapping("/productos/{codigoVenta}")
    public ResponseEntity<List<Producto>> getAllVentaProductos(@PathVariable Long codigoVenta){
         return ResponseEntity.ok(iVentaService.getAllVentaProducto(codigoVenta));
    }

    @GetMapping("/fecha/{fechaVenta}")
    public ResponseEntity<?> sumatoriaMontoYCantidadTotalVentas(@PathVariable LocalDate fechaVenta){
        return ResponseEntity.ok("La suma total del monto es: "+iVentaService.sumatoriaMonto(fechaVenta)+ " y la cantidad total de ventas es de: "+iVentaService.cantidadTotal(fechaVenta));
    }

    @GetMapping("/mayor_venta")
    public ResponseEntity<VentaMayorDTO> ventaMayorInfo(){
        return ResponseEntity.ok(iVentaService.ventaMayorInfo());
    }

}
