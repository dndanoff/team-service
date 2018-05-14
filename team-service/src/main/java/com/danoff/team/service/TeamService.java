package com.danoff.team.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.danoff.team.model.TeamMember;
import com.danoff.team.repository.TeamMemberRepository;

@Service
public class TeamService {
	private final TeamMemberRepository teamRepository;

	public TeamService(TeamMemberRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	public List<TeamMember> findMembers(int pageSize, int pageNumber) {
		if (pageSize > 0 && pageSize > 0) {
			return teamRepository.findPaginated(pageSize, pageNumber);
		}

		return teamRepository.findAll();
	}
	
	public TeamMember findMember(Long id) {
		return teamRepository.findMember(id);
	}

	public Long createMember(TeamMember member) {
		return teamRepository.createMember(member);
	}

	public void updateMember(TeamMember member) {
		teamRepository.updateMember(member);
	}

	public void deleteMember(Long id) {
		teamRepository.deleteMember(id);
	}

	public int count() {
		return teamRepository.count();
	}
}
