package org.serratec.backend.repository;

import java.util.Optional;

import org.serratec.backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findByEmail(String email);
	Optional<Cliente> findById(Long id);
}
