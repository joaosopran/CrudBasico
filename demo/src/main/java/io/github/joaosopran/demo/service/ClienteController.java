package io.github.joaosopran.demo.service;

import io.github.joaosopran.demo.model.Cliente;
import io.github.joaosopran.demo.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }



}
