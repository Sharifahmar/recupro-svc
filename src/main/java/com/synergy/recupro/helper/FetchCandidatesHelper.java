package com.synergy.recupro.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Service;

import com.synergy.recupro.model.Candidate;
import com.synergy.recupro.model.Requirements;
import com.synergy.recupro.repository.CandidateRepository;
import com.synergy.recupro.ro.CandidateMatchRO;
import com.synergy.recupro.ro.FetchCandidatesRO;

import io.jsonwebtoken.lang.Collections;

@Service
public class FetchCandidatesHelper {

	public static List<FetchCandidatesRO> mapCandidatesForRequirements(Optional<Requirements> requirements,
			List<Candidate> allAvailableCandidates) {
         
		System.err.println("srini inside mapCandidatesForRequirements");
		List<FetchCandidatesRO> fetchCandidateRoList = new ArrayList<FetchCandidatesRO>();
		
		String[] acquiredSkillsArray ;
		
		String[] requiredSkillsArray = requirements.get().getRequiredSkills().split(";");
		
		
		for(Candidate candidate: allAvailableCandidates)
		{
			acquiredSkillsArray = candidate.getAcquiredSkills().split(";");
			
			FetchCandidatesRO fetchCandidatesRO  = new FetchCandidatesRO();
			
			fetchCandidatesRO.setCandidate(candidate);
			
			fetchCandidatesRO.setCandidateMatchRo(getMatchedRo(requiredSkillsArray,acquiredSkillsArray));
			
			fetchCandidateRoList.add(fetchCandidatesRO);
			
 		}
		System.err.println("srini returning list"+fetchCandidateRoList.size());
		return fetchCandidateRoList;
	}
	
	public List<FetchCandidatesRO> mapCandidatesForSkills(String skills, List<Candidate> allAvailableCandidates) {
			
		List<FetchCandidatesRO> fetchCandidateRoList = new ArrayList<FetchCandidatesRO>();
		
		String[] acquiredSkillsArray ;
		
		String[] requiredSkillsArray = skills.split(";");
		
		
		for(Candidate candidate: allAvailableCandidates)
		{
			acquiredSkillsArray = candidate.getAcquiredSkills().split(";");
			
			FetchCandidatesRO fetchCandidatesRO  = new FetchCandidatesRO();
			
			fetchCandidatesRO.setCandidate(candidate);
			
			fetchCandidatesRO.setCandidateMatchRo(getMatchedRo(requiredSkillsArray,acquiredSkillsArray));
			
			fetchCandidateRoList.add(fetchCandidatesRO);
			
 		}
		System.err.println("srini returning list"+fetchCandidateRoList.size());
		return fetchCandidateRoList;	
	}

	public static CandidateMatchRO getMatchedRo(String[] requiredSkillsArray, String[] acquiredSkillsArray)
	{
		System.err.println("srini inside getMatchedRo");
		int skillsMatched = 0;
		CandidateMatchRO candidateMatchRo = new CandidateMatchRO();
		candidateMatchRo.setTotalSkillsRequired(requiredSkillsArray.length);
		candidateMatchRo.setTotalSkillsAcquired(acquiredSkillsArray.length);
		
		Set<String> acquiredSkillsSet = new HashSet<>(Arrays.asList(acquiredSkillsArray));
		for (String requiredSkill : requiredSkillsArray)
			if (acquiredSkillsSet.contains(requiredSkill))
				skillsMatched++;
		
		candidateMatchRo.setMatchedSkills(skillsMatched);
		
		setPercentageMatch(candidateMatchRo);
		
		return candidateMatchRo;
	}
	
	public static void setPercentageMatch(CandidateMatchRO candidateMatchRo)
	{
		System.err.println("srini inside setPercentageMatch");
		float percentMatched = (float)((candidateMatchRo.getMatchedSkills()*100)/candidateMatchRo.getTotalSkillsRequired());
		candidateMatchRo.setPercentageMatch(percentMatched);
		System.err.println("srini precentage matched "+ percentMatched);
	}
}