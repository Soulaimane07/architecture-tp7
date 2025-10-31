package ma.ws.jaxrs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ws.jaxrs.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
