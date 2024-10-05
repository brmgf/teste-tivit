package org.tivit.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tivit.domain.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {
}
