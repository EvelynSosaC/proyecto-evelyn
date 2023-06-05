package com.intercorp.restapi.controllers.v1;

import com.intercorp.restapi.api.v1.model.ClienteDTO;
import com.intercorp.restapi.api.v1.model.ClienteListDTO;
import com.intercorp.restapi.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for Cliente
 * GET POST PUT PATCH DELETE HTTP Methods are supported currently
 */
@Api(description ="Supports GET, POST, PATCH, PUT, DELETE operations", tags = {"clientes"})
@RestController
@RequestMapping(ClienteController.BASE_URL)
public class ClienteController {

    /**
     * Cliente Controller Base URL
     */
    public static final String BASE_URL = "/api/v1/clientes";

    /**
     * Inject dependencies
     */
    @Autowired
    private ClienteService clienteService;

    /**
     * Constructor
     * @param clienteService
     */
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Method for getting all clientes
     * @return
     */
    @ApiOperation(value = "Lists all the clientes", notes = "")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ClienteListDTO getClientes() {

        return new ClienteListDTO(clienteService.getClientes());
    }

    /**
     * Method for KPI clientes
     * @return
     */
    @ApiOperation(value = "KPI clientes", notes = "")
    @GetMapping(value = {"/kpi_clientes"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public long getKpiClientes() {

        return clienteService.getPromedioCliente();
    }
    
    /**
     * Method for getting cliente by cliente Id
     * @param clienteId
     * @return
     */
    @ApiOperation(value = "Get a cliente by id", notes = "")
    @GetMapping(value = {"/{clienteId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ClienteDTO getClienteById(@PathVariable Long clienteId) {

        return clienteService.getClienteById(clienteId);
    }

    /**
     * Method for creating new cliente
     * @param clienteDTO
     * @return
     */
    @ApiOperation(value = "Create a cliente", notes = "")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO createCliente(@Validated @RequestBody ClienteDTO clienteDTO) {

        return clienteService.createCliente(clienteDTO);
    }


    /**
     * Method for deleting cliente
     * @param clienteId
     */
    @ApiOperation(value = "Delete a cliente", notes = "")
    @DeleteMapping(value = {"/{clienteId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCliente(@PathVariable Long clienteId) {

        clienteService.deleteClienteById(clienteId);

    }
}
