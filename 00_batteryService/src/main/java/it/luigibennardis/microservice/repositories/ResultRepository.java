package it.luigibennardis.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.luigibennardis.microservice.domain.Result;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, String> {
    List<Result> findAllByWinnerIdOrLoserId(String winnerId, String loserId);
}
