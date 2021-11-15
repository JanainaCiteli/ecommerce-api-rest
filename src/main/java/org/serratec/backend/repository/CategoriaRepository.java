package org.serratec.backend.repository;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public Optional<Categoria> findById(Long id);

	public List<Categoria> findByNome(String nome);

	public List<Categoria> findByDescricao(String descricao);

}
