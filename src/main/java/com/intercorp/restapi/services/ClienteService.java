package com.intercorp.restapi.services;

import com.intercorp.restapi.api.v1.model.ClienteDTO;


import java.util.List;

/**
 * Cliente Interface
 */
public interface ClienteService {

    // Get all Clientes
    List<ClienteDTO> getClientes();

    // Get Cliente by id
    ClienteDTO getClienteById(Long clienteId);

    // Create new Cliente
    ClienteDTO createCliente(ClienteDTO clienteDTO);


    void deleteClienteById(Long clienteId);
    long getPromedioCliente();
    double getDesviacionCliente();
    
}
