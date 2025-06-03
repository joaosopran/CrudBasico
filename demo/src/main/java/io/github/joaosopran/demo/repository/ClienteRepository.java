package io.github.joaosopran.demo.repository;

import io.github.joaosopran.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
