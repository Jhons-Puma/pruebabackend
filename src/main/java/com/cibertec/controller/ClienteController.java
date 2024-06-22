package com.cibertec.controller;

import com.cibertec.model.Cliente;
import com.cibertec.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(service.listarClientes());
    }

    @PostMapping
    public ResponseEntity<Cliente> agregarProducto(@RequestBody Cliente cliente) {
        Cliente nuevo = service.registrarCliente(cliente);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable String id) {
        Cliente cliente = service.buscarCliente(id);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente) {
        Cliente actualizado = service.actualizarCliente(cliente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable String id) {
        service.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
