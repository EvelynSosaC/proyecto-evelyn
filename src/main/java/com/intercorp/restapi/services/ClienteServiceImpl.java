package com.intercorp.restapi.services;

import com.intercorp.restapi.api.v1.mapper.ClienteMapper;
import com.intercorp.restapi.api.v1.model.ClienteDTO;
import com.intercorp.restapi.controllers.v1.ClienteController;
import com.intercorp.restapi.domain.Cliente;
import com.intercorp.restapi.exceptions.ResourceNotFoundException;
import com.intercorp.restapi.exceptions.RestResponseEntityExceptionHandler;
import com.intercorp.restapi.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Cliente service implementation class
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    /**
     * Injecting dependencies
     */
    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    /**
     * Constructor
     * @param ClienteRepository
     * @param ClienteMapper
     */
    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    /**
     * Method implementation for getting all Clientes from the database
     * @return
     */
    @Override
    public List<ClienteDTO> getClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(cliente -> {
                    ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(cliente);
                    clienteDTO.setClienteUrl(getClienteUrl(cliente.getClienteId()));
                    return clienteDTO;
                })
                .collect(Collectors.toList());
    }


    /**
     * Method implementation for getting Cliente by provided Cliente Id
     * @param ClienteId
     * @return
     */
    @Override
    public ClienteDTO getClienteById(Long clienteId) {

        return clienteRepository.findById(clienteId.intValue())
                .map(clienteMapper::clienteToClienteDTO)
                .map(clienteDTO -> {
                    clienteDTO.setClienteUrl(getClienteUrl(clienteId));
                    return clienteDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }
    /**
     * Method implementation for creating a new Cliente by provided Promedio
     * @param ClienteDTO
     * @return
     */
    @Override
    public long getPromedioCliente() {

        return clienteRepository.count();
               
    }
    /**
     * Method implementation for creating a new Cliente by provided Desviacion Estandar
     * @param ClienteDTO
     * @return
     */
    @Override
    public double getDesviacionCliente() {
    	double mean = 0.0;
    	 double standardDeviation = 0.0;
    	 double sq = 0.0;
    	 double res = 0.0;
    	List<ClienteDTO> x = clienteRepository.findAll()
                 .stream()
                 .map(cliente -> {
                     ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(cliente);
                     clienteDTO.setClienteUrl(getClienteUrl(cliente.getClienteId()));
                     return clienteDTO;
                 })
                 .collect(Collectors.toList());
    	long sumaedad = x.stream()
    	.mapToLong(ClienteDTO::getEdad)
    	.sum();  
    	long cantidad=x.stream()
    	.count();
    	
    	mean = sumaedad / (cantidad);
		for (ClienteDTO cliente:x) {
		           long edad=cliente.getEdad(); 
		            standardDeviation
		                = standardDeviation + Math.pow((edad - mean), 2);
		            
		        }
		 sq = standardDeviation / cantidad;
	        res = Math.sqrt(sq);
    	return res;
               
    }
    /**
     * Method implementation for creating a new Cliente by provided Cliente post data
     * @param ClienteDTO
     * @return
     */
    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {

        Cliente cliente = clienteMapper.clienteDTOToCliente(clienteDTO);

        return createOrUpdateClienteHelper(cliente);
    }

    /**
     * Helper method for create or update Cliente
     * @param Cliente
     * @return ClienteDTO
     */
    private ClienteDTO createOrUpdateClienteHelper(Cliente Cliente) {

        Cliente saveCliente = clienteRepository.save(Cliente);

        ClienteDTO saveClienteDTO = clienteMapper.clienteToClienteDTO(saveCliente);

        saveClienteDTO.setClienteUrl(getClienteUrl(saveCliente.getClienteId()));

        return saveClienteDTO;
    }

    /**
     * Method implementation for deleting Cliente by provided Cliente Id
     * @param ClienteId
     */
    @Override
    public void deleteClienteById(Long clienteId) {
        clienteRepository.deleteById(clienteId.intValue());
    }

    /**
     * Helper method for generating Cliente url
     * @param ClienteId
     * @return
     */
    private String getClienteUrl(long clienteId) {

        return ClienteController.BASE_URL + "/" + clienteId;
    }
}
