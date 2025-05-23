package com.example.tfp.Service;

import com.example.tfp.Api.ApiException;
import com.example.tfp.DTO.TeamA_DTO;
import com.example.tfp.Model.PublicMatch;
import com.example.tfp.Model.TeamA;
import com.example.tfp.Repository.PublicMatchRepository;
import com.example.tfp.Repository.TeamARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamAService {

    private final TeamARepository teamARepository;
    private final PublicMatchRepository publicMatchRepository;

    public void addTeamA(Integer publicMatchId, TeamA teamA){

        PublicMatch publicMatch= publicMatchRepository.findPublicMatchById(publicMatchId);
        if(publicMatch== null){
            throw new ApiException("PublicMatch not found");
        }

        publicMatch.setTeamA(teamA);
    }

    public void updateTameA(PublicMatch publicMatch, Integer tameAId,TeamA teamA) {

        TeamA oldTeam = teamARepository.findTeamAById(tameAId);
        if (oldTeam == null) {
            throw new ApiException("TeamA not found");

        }

        if (!oldTeam.getPublicMatch().getId().equals(publicMatch.getId())) {
            throw new ApiException("You are not allowed to update another Team data");
        }
        oldTeam.setTeamName(teamA.getTeamName());
        oldTeam.setPlayersCount(teamA.getPlayersCount());
        teamARepository.save(oldTeam);
    }

    public void deleteTeamA(PublicMatch publicMatch, Integer teamAId){

        TeamA teamA= teamARepository.findTeamAById(teamAId);

        if (teamA==null){
            throw new ApiException("Team not found");
        }
        if (!teamA.getPublicMatch().getId().equals(publicMatch.getId()));
        throw new ApiException("You are not allowed to delete another team data");

    }
}
