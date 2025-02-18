package com.corales.stockBazarApp.producto.service;

import com.corales.stockBazarApp.producto.model.Producto;
import com.corales.stockBazarApp.producto.repository.IProductoRepository;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public void saveProducto(Producto producto) {
        iProductoRepository.save(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return iProductoRepository.findAll();
    }

    @Override
    public Producto getProductoByCodigo(Long codigoProducto) {
        return iProductoRepository.findById(codigoProducto).orElse(null);
    }

    @Override
    public void deleteProducto(Long codigoProducto) {
        iProductoRepository.deleteById(codigoProducto);
    }

    @Override
    public void updateProducto(Producto producto, Long codigoProducto) {
        Producto productoAux = this.getProductoByCodigo(codigoProducto);
        productoAux.setNombre(producto.getNombre());
        productoAux.setMarca(producto.getMarca());
        productoAux.setCosto(producto.getCosto());
        productoAux.setCantidadDisponible(producto.getCantidadDisponible());
        this.saveProducto(productoAux);
    }

    @Override
    public List<Producto> faltaStock() {
        return this.getAllProductos()
                .stream()
                .filter(prod -> prod.getCantidadDisponible() < 5)
                .collect(Collectors.toList());
    }
}
