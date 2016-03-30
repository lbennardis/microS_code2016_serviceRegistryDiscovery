package it.luigibennardis.microservice.web;

import it.luigibennardis.microservice.domain.MatchRequest;

import java.util.Optional;

interface OpenMatchFinder {

    Optional<MatchRequest> firstOpenMatchRequest(String id);

}
