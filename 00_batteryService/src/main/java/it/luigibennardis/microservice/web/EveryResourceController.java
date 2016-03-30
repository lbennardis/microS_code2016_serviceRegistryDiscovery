package it.luigibennardis.microservice.web;

import it.luigibennardis.microservice.repositories.MatchRepository;
import it.luigibennardis.microservice.repositories.MatchRequestRepository;
import it.luigibennardis.microservice.repositories.ResultRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class EveryResourceController {

    private final MatchRequestRepository matchRequestRepository;

    private final MatchRepository matchRepository;

    private final ResultRepository resultRepository;

    @Autowired
    EveryResourceController(MatchRequestRepository matchRequestRepository, MatchRepository matchRepository,
                            ResultRepository resultRepository) {
        this.matchRequestRepository = matchRequestRepository;
        this.matchRepository = matchRepository;
        this.resultRepository = resultRepository;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, value = "/all")
    void delete() {
        matchRequestRepository.deleteAll();
        matchRepository.deleteAll();
        resultRepository.deleteAll();
    }
}

