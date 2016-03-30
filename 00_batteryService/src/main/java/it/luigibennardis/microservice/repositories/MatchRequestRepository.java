package it.luigibennardis.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.luigibennardis.microservice.domain.MatchRequest;

import java.util.List;

public interface MatchRequestRepository extends JpaRepository<MatchRequest, String> {

    MatchRequest findByUuid(String uuid);
    List<MatchRequest> findByOrderByIdAsc();

}
