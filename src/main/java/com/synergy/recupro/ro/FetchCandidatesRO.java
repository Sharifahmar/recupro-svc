package com.synergy.recupro.ro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.synergy.recupro.model.Candidate;
import com.synergy.recupro.model.Document;
import com.synergy.recupro.model.Requirements;

public class FetchCandidatesRO {

	     private Candidate candidate;
	     private CandidateMatchRO candidateMatchRo;
	
	     public Candidate getCandidate() {
			return candidate;
		}
		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}
		public CandidateMatchRO getCandidateMatchRo() {
			return candidateMatchRo;
		}
		public void setCandidateMatchRo(CandidateMatchRO candidateMatchRo) {
			this.candidateMatchRo = candidateMatchRo;
		}
}