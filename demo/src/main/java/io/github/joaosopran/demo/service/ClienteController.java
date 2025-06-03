package io.github.joaosopran.demo.service;

import io.github.joaosopran.demo.model.Cliente;
import io.github.joaosopran.demo.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody @Valid Cliente cliente) {
        if (repository.existsByCpf(cliente.getCpf())) {
            return ResponseEntity
                    .badRequest()
                    .body("Já existe um cliente com o CPF informado.");
        }
        Cliente salvo = repository.save(cliente);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<?> listarClientes() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody @Valid Cliente clienteAtualizado) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = repository.findById(id).orElseThrow();

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setCep(clienteAtualizado.getCep());

        Cliente salvo = repository.save(cliente);
        return ResponseEntity.ok(salvo);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Cliente deletado com sucesso.");
    }
}
