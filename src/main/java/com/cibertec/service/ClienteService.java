package com.cibertec.service;

import com.cibertec.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClienteService {
    List<Cliente> listarClientes();
    Cliente registrarCliente(Cliente c);
    Cliente buscarCliente(String id);
    Cliente actualizarCliente(Cliente c);
    void eliminarCliente(String id);
}
