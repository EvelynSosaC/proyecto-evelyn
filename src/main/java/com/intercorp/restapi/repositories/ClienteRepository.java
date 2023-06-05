package com.intercorp.restapi.repositories;

import com.intercorp.restapi.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Cliente repository class for database interaction
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    /**
     * Getting cliente by cliente Id
     * @param clienteId
     * @return
     */
//    Cliente getClienteByClienteId(Long clienteId);
}
