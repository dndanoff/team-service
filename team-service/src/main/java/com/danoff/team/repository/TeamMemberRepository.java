package com.danoff.team.repository;

import java.util.List;

import com.danoff.team.model.TeamMember;

public interface TeamMemberRepository {

	public int count();
	public List<TeamMember> findAll();
	public List<TeamMember> findPaginated(int pageSize, int pageNumber);
	public TeamMember findMember(Long id);
	public Long createMember(TeamMember member);
	public void updateMember(TeamMember member);
	public void deleteMember(Long id);
}
