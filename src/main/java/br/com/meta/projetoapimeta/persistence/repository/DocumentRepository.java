package br.com.meta.projetoapimeta.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meta.projetoapimeta.persistence.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

}
