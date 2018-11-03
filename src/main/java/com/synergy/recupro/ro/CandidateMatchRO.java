package com.synergy.recupro.ro;

public class CandidateMatchRO {
	
	private float percentageMatch;

	private int totalSkillsRequired;
	
	private int totalSkillsAcquired;
	
	private int matchedSkills;
	
	private String noticePeriodMatch;
	
	private String locationMatch;

	public float getPercentageMatch() {
		return percentageMatch;
	}

	public void setPercentageMatch(float percentageMatch) {
		this.percentageMatch = percentageMatch;
	}

	public int getTotalSkillsRequired() {
		return totalSkillsRequired;
	}

	public void setTotalSkillsRequired(int totalSkillsRequired) {
		this.totalSkillsRequired = totalSkillsRequired;
	}

	public int getTotalSkillsAcquired() {
		return totalSkillsAcquired;
	}

	public void setTotalSkillsAcquired(int totalSkillsAcquired) {
		this.totalSkillsAcquired = totalSkillsAcquired;
	}

	public int getMatchedSkills() {
		return matchedSkills;
	}

	public void setMatchedSkills(int matchedSkills) {
		this.matchedSkills = matchedSkills;
	}

	public String getNoticePeriodMatch() {
		return noticePeriodMatch;
	}

	public void setNoticePeriodMatch(String noticePeriodMatch) {
		this.noticePeriodMatch = noticePeriodMatch;
	}

	public String getLocationMatch() {
		return locationMatch;
	}

	public void setLocationMatch(String locationMatch) {
		this.locationMatch = locationMatch;
	}
}
