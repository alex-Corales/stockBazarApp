package com.corales.stockBazarApp.cliente.service;


import com.corales.stockBazarApp.cliente.model.Cliente;

import java.util.List;

public interface IClienteService {
    void saveCliente(Cliente cliente);
    List<Cliente> getAllClientes();
    Cliente getClienteByCodigo(Long codigoCliente);
    void deleteCliente(Long codigoCliente);
    void updateCliente(Cliente cliente, Long codigoCliente);
}
