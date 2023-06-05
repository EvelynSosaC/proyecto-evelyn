package com.intercorp.restapi.bootstrap;

import com.intercorp.restapi.domain.Cliente;
import com.intercorp.restapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Bootstrap class to load default data in database on startup
 */
@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    public Bootstrap(
                     ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Load Clientes
        addCliente();

    }



    /**
     * Load clientes in db
     * @throws Exception 
     */
    private void addCliente() throws Exception {


        
        clienteRepository.deleteAll();

        Cliente one = new Cliente();
        one.setNombre("Halan");
        one.setApellido("Garzia");
        one.setEdad(30);
        one.setFechaNacimiento("11/11/2000");
        one.setFechaMuerte("11/11/2023");

        Cliente two = new Cliente();
        two.setNombre("Tholedo");
        two.setApellido("Manrique");
        two.setEdad(35);
        two.setFechaNacimiento("11/12/1990");
        two.setFechaMuerte("11/11/2025");

        Cliente three = new Cliente();
        three.setNombre("Queiko");
        three.setApellido("Fujimori");
        three.setEdad(40);
        three.setFechaNacimiento("11/12/1980");
        three.setFechaMuerte("11/11/2027");
//
//        Cliente four = new Cliente();
//        four.setNombre("Hollanta");
//        four.setApellido("Umala");
//        four.setEdad(46);
//        four.setFechaNacimiento("11/12/1990");
//        
//        Cliente five = new Cliente();
//        five.setNombre("Hbimael");
//        five.setApellido("Guzmhan");
//        five.setEdad(46);
//        five.setFechaNacimiento("11/12/1990");
//        
        clienteRepository.save(one);
        clienteRepository.save(two);
        clienteRepository.save(three);
//        clienteRepository.save(four);
//        clienteRepository.save(five);

        //System.out.println("Clientes data loaded in db " + clienteRepository.count());
    }


}
