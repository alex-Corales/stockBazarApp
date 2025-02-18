package com.corales.stockBazarApp.producto.controller;

import com.corales.stockBazarApp.producto.model.Producto;
import com.corales.stockBazarApp.producto.service.IProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    @PostMapping("/crear")
    public ResponseEntity<?> saveProducto(@RequestBody @Valid Producto producto){
        iProductoService.saveProducto(producto);
        return ResponseEntity.ok("El producto se creo correctamente");
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos(){
        return ResponseEntity.ok(iProductoService.getAllProductos());
    }

    @GetMapping("/{codigoProducto}")
    public ResponseEntity<Producto> getProductoByCodigo(@PathVariable Long codigoProducto){
        return ResponseEntity.ok(iProductoService.getProductoByCodigo(codigoProducto));
    }

    @DeleteMapping("/eliminar/{codigoProducto}")
    public ResponseEntity<?> deleteProductoByCodigo(@PathVariable Long codigoProducto){
        iProductoService.deleteProducto(codigoProducto);
        return ResponseEntity.ok("El producto se elimino correctamente");
    }

    @PutMapping("/editar/{codigoProducto}")
    public ResponseEntity<?> updateProductoByCodigo(@RequestBody Producto producto, @PathVariable Long codigoProducto){
        iProductoService.updateProducto(producto, codigoProducto);
        return ResponseEntity.ok("El producto se actualizo con exito");
    }

    @GetMapping("/falta_stock")
    public ResponseEntity<?> faltaStock(){
        return ResponseEntity.ok(iProductoService.faltaStock());
    }

}
