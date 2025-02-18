package com.corales.stockBazarApp.cliente.controller;

import com.corales.stockBazarApp.cliente.model.Cliente;
import com.corales.stockBazarApp.cliente.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/crear")
    public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente){
        iClienteService.saveCliente(cliente);
        return ResponseEntity.ok("El cliente se creo con exito");
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(iClienteService.getAllClientes());
    }

    @GetMapping("/{codigoCliente}")
    public ResponseEntity<Cliente> getClienteByCodigo(@PathVariable Long codigoCliente){
        return ResponseEntity.ok(iClienteService.getClienteByCodigo(codigoCliente));
    }

    @DeleteMapping("/eliminar/{codigoCliente}")
    public ResponseEntity<?> deteleClieteByCodigo(@PathVariable Long codigoCliente){
        iClienteService.deleteCliente(codigoCliente);
        return ResponseEntity.ok("El cliente se elimino con exito");
    }

    @PutMapping("/editar/{codigoCliente}")
    public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente, @PathVariable Long codigoCliente){
        iClienteService.updateCliente(cliente, codigoCliente);
        return ResponseEntity.ok("El cliente se actualizo con exito");
    }

}
