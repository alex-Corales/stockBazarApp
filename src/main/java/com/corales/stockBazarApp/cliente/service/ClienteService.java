package com.corales.stockBazarApp.cliente.service;

import com.corales.stockBazarApp.cliente.model.Cliente;
import com.corales.stockBazarApp.cliente.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public void saveCliente(Cliente cliente) {
        iClienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return iClienteRepository.findAll();
    }

    @Override
    public Cliente getClienteByCodigo(Long codigoCliente) {
        return iClienteRepository.findById(codigoCliente).orElse(null);
    }

    @Override
    public void deleteCliente(Long codigoCliente) {
        iClienteRepository.deleteById(codigoCliente);
    }

    @Override
    public void updateCliente(Cliente cliente, Long codigoCliente) {
        Cliente clienteAux = this.getClienteByCodigo(codigoCliente);
        clienteAux.setNombre(cliente.getNombre());
        clienteAux.setApellido(cliente.getApellido());
        clienteAux.setDni(cliente.getDni());
        this.saveCliente(clienteAux);
    }
}
