package com.example.FutsalTournament.Service;

import com.example.FutsalTournament.Model.Tournament;
import com.example.FutsalTournament.Repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    // Method to retrieve all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // Method to retrieve a tournament by ID
    public Tournament getTournamentById(Long id) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
        return optionalTournament.orElse(null);
    }

    // Method to create a new tournament
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // Method to update an existing tournament
    public Tournament updateTournament(Long id, Tournament tournament) {
        if (tournamentRepository.existsById(id)) {
            tournament.setId(id);
            return tournamentRepository.save(tournament);
        }
        return null;
    }

    // Method to delete an existing tournament
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
}