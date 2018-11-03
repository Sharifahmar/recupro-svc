package com.synergy.recupro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.kms.model.NotFoundException;
import com.synergy.recupro.exception.ResourceNotFoundException;
import com.synergy.recupro.helper.FetchCandidatesHelper;
import com.synergy.recupro.model.Candidate;
import com.synergy.recupro.model.Requirements;
import com.synergy.recupro.repository.AccountsRepository;
import com.synergy.recupro.repository.CandidateRepository;
import com.synergy.recupro.repository.RequirementRepository;
import com.synergy.recupro.ro.FetchCandidatesRO;

@RestController
public class FetchCandidatesController {
	
	public static final Logger logger = LogManager.getLogger(FetchCandidatesController.class);
	

	@Autowired
	private RequirementRepository requirementRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
    @Autowired
    private FetchCandidatesHelper fetchCandidatesHelper;
    
	 @CrossOrigin(origins = "*")
     @PreAuthorize("hasAnyRole('RECRUITMENT_LEAD', 'ADMIN')")
	 @GetMapping("/fetchmatchingcandidates/{requirementId}")
	 public ResponseEntity<List<FetchCandidatesRO>> fetchMatchingCandidatesForAReuirement(@PathVariable Long requirementId) {
		 List<FetchCandidatesRO> fetchCandidatesList = new ArrayList<FetchCandidatesRO>();
		 
		 System.err.println("srini requirement id"+requirementId);
		 
		 Optional<Requirements> requirements  = requirementRepository.findById(requirementId);
		 
		 if(!requirements.isPresent())
		 {
			 System.err.println("srni inside no requirement found ");
			 throw new ResourceNotFoundException("FetchCandidatesController :" , "requirementId",requirementId);
		 }
		 
		 List<Candidate> allAvailableCandidates = candidateRepository.findAll();
		 
		 if(allAvailableCandidates.isEmpty())
		 {
			 System.err.println("srni inside no candidates found ");
			 throw new NotFoundException("No Candidates Available");
		 }
		 
		 fetchCandidatesList = fetchCandidatesHelper.mapCandidatesForRequirements(requirements,allAvailableCandidates);
		 
		 return new ResponseEntity<List<FetchCandidatesRO>>(fetchCandidatesList, HttpStatus.OK);
	 }
	 
	 
	 @CrossOrigin(origins = "*")
     @PreAuthorize("hasAnyRole('RECRUITMENT_LEAD', 'ADMIN')")
	 @RequestMapping("/fetchmatchingcandidates")
	 public ResponseEntity<List<FetchCandidatesRO>> fetchMatchingCandidatesForSkills(@RequestParam(value="skills") String skills) {

		 List<FetchCandidatesRO> fetchCandidatesList = new ArrayList<FetchCandidatesRO>();
		 
		 List<Candidate> allAvailableCandidates = candidateRepository.findAll();
		 
		 if(allAvailableCandidates.isEmpty())
		 {
			 System.err.println("srni inside no candidates found ");
			 throw new NotFoundException("No Candidates Available");
		 }
		 
		 fetchCandidatesList = fetchCandidatesHelper.mapCandidatesForSkills(skills,allAvailableCandidates);
		 
		 
		 return new ResponseEntity<List<FetchCandidatesRO>>(fetchCandidatesList, HttpStatus.OK);
	 }
}
