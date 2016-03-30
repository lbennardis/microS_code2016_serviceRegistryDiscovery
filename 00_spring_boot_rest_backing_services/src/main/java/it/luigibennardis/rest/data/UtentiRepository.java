package it.luigibennardis.rest.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource
public interface UtentiRepository extends JpaRepository<Utenti, Long> {
	public List<Utenti> findAll();

}
