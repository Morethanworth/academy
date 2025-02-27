package com.ctw.workstation.team.boundary;

import com.ctw.workstation.config.CtwAcademyTestProfile;
import com.ctw.workstation.team.controller.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRepository;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import com.ctw.workstation.team.entity.TeamResponseDTO;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
@TestProfile(CtwAcademyTestProfile.class)
class TeamServiceTest {

    @Inject
    TeamService teamService;

    //this applies the mock for all tests
    @Inject
    TeamRepository teamRepository;

    @Test
    void create_team_pode_nao(){
        TeamRepository teamRepositoryMock = Mockito.mock(TeamRepository.class);
        QuarkusMock.installMockForType(teamRepositoryMock, TeamRepository.class);

        Mockito.doThrow(new IllegalArgumentException("*BUZZER SOUND*"))
                .when(teamRepositoryMock)
                .persistAndFlush(Mockito.any(Team.class));

        //given
        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("TESTE","teste","teste");

        //when then
        Assertions.assertThatThrownBy(()-> teamService.create(teamRequestDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("*BUZZER SOUND*");

    }

    @Test
    void create_team(){
        //given
        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("TESTE","teste","teste");

        //when
        TeamResponseDTO createdTeam = teamService.create(teamRequestDTO);

        //then
        Assertions.assertThat(createdTeam)
                .as("DTO has no null fields")
                .hasNoNullFieldsOrProperties()
                .usingRecursiveComparison()
                .ignoringFields("id","created_at","modified_at")
                .as("DTO return matches request")
                .isEqualTo(teamRequestDTO);

        Assertions.assertThat(teamRepository.findById(createdTeam.getId()))
                .isNotNull();
    }

    

}