package br.com.meta.projetoapimeta.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meta.projetoapimeta.persistence.entity.TextoPadrao;

@Repository
public interface TextoPadraoRepository extends JpaRepository<TextoPadrao, Integer> {

}
