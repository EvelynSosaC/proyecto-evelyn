package com.intercorp.restapi.api.v1.model;

import io.swagger.annotations.ApiModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Cliente list data transfer object model
 */
@ApiModel(value = "Cliente List", description = "cliente list")
@Data


public class ClienteListDTO {

    private List<ClienteDTO> clientes;

	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
	}

	public ClienteListDTO(List<ClienteDTO> clientes) {
		super();
		this.clientes = clientes;
	}

	public ClienteListDTO() {
		super();
	}
	
    
}
