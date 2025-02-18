package com.corales.stockBazarApp.producto.service;

import com.corales.stockBazarApp.producto.model.Producto;

import java.util.List;

public interface IProductoService {
    void saveProducto(Producto producto);
    List<Producto> getAllProductos();
    Producto getProductoByCodigo(Long codigoProducto);
    void deleteProducto(Long codigoProducto);
    void updateProducto(Producto producto, Long codigoProducto);
    List<Producto> faltaStock();
}
