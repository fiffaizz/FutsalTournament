package com.example.FutsalTournament.Service;

import com.example.FutsalTournament.Model.Team;
import com.example.FutsalTournament.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    // Method to retrieve all teams
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    // Method to retrieve a team by ID
    public Team getTeamById(Long id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        return optionalTeam.orElse(null);
    }

    // Method to create a new team
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    // Method to update an existing team
    public Team updateTeam(Long id, Team team) {
        if (teamRepository.existsById(id)) {
            team.setId(id);
            return teamRepository.save(team);
        }
        return null;
    }

    // Method to delete an existing team
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
