package io.github.joaosopran.demo.service;

import io.github.joaosopran.demo.model.Cliente;
import io.github.joaosopran.demo.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> criarCliente(@RequestBody @Valid Cliente cliente) {
        if (repository.existsByCpf(cliente.getCpf())) {
            return ResponseEntity
                    .badRequest()
                    .body("Já existe um cliente com o CPF informado.");
        }
        Cliente salvo = repository.save(cliente);
        return ResponseEntity.ok(salvo);
    }



}
