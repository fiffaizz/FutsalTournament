package com.example.FutsalTournament.Service;

import com.example.FutsalTournament.Model.Match;
import com.example.FutsalTournament.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    // Method to retrieve all matches
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    // Method to retrieve a match by ID
    public Match getMatchById(Long id) {
        Optional<Match> optionalMatch = matchRepository.findById(id);
        return optionalMatch.orElse(null);
    }

    // Method to create a new match
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    // Method to update an existing match
    public Match updateMatch(Long id, Match match) {
        if (matchRepository.existsById(id)) {
            match.setId(id);
            return matchRepository.save(match);
        }
        return null;
    }

    // Method to delete an existing match
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
