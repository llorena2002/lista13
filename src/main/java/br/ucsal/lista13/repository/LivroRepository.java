package br.ucsal.lista13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.lista13.model.Livro;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}