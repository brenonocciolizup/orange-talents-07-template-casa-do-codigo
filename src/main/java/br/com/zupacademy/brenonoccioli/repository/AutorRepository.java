package br.com.zupacademy.brenonoccioli.repository;

import br.com.zupacademy.brenonoccioli.controller.form.AutorForm;
import br.com.zupacademy.brenonoccioli.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);
}
