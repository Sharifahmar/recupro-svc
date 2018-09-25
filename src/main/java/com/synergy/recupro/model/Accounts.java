package com.synergy.recupro.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "ACCOUNTS")
public class Accounts extends AuditModel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(generator = "accounts_generator")
    @SequenceGenerator(
            name = "accounts_generator",
            sequenceName = "accounts_sequence",
            initialValue = 1000
    )
    private Long id;
	
    @Column(columnDefinition = "text", nullable = false, name = "ACCOUNT_NAME")
    @Size(min = 3, max = 25)
    private String accountName;
    
    @Column(columnDefinition = "text", name = "CONTACT_NAME")
    @Size(min = 3, max = 35)
    private String contactName;
    
    @Column(columnDefinition = "text", nullable = false, name = "OPENING_TITLE")
    @Size(min = 3, max = 25)
    private String openingTitle;
    
    @Column(columnDefinition = "text", nullable = false, name = "OPENING_ID")
    private String openingId;
    
    @Column(columnDefinition = "text", name = "ACCOUNT_OWNER")
    @Size(min = 3, max = 35)
    private String accountOwner;
    
    @Column(columnDefinition = "text", name = "PRIMARY_RECRUITER")
    @Size(min = 3, max = 35)
    private String primaryRecruiter;
    
    @Column(columnDefinition = "text", name = "ACCESS")
    @Size(min = 3, max = 15)
    private String access;
    
    @Column(columnDefinition = "text", name = "ASGN_MRE_RECRUITERS")
    @Size(min = 3, max = 35)
    private String assignMoreRecruiter;
    
    @Column(columnDefinition = "text", name = "END_CLIENT")
    @Size(min = 3, max = 15)
    private String endClient;
    
    @Column(columnDefinition = "int", name = "REQ_EXP")
    private String requiredExperience;
    
    @Column(columnDefinition = "int", name = "BILL_RATE")
    private int billRate;
    
    @Column(columnDefinition = "int", name = "PAY_RATE")
    private String payRate;
    
    @Column(columnDefinition = "text", name = "COUNTRY")
    @Size(max = 75)
    private String country;
    
    @Column(columnDefinition = "text", name = "STATE")
    @Size(max = 75)
    private String state;
    
    @Column(columnDefinition = "text", name = "CITY")
    @Size(max = 75)
    private String city;
    
    @Column(columnDefinition = "int", name = "ZIP_CODE")
    private int zipCode;
    
    @Column(columnDefinition = "int", name = "NO_OF_OPENINGS")
    @Size(max = 6)
    private long numberOfOpenings;
    
    @Column(columnDefinition = "int", name = "MAX_RES_ALLOWED")
    @Size(max = 6)
    private long maxResumesAllowed;
    
    @Column(columnDefinition = "boolean", name = "LOCAL_INDICATOR")
    private boolean localIndicator;
    
    @Column(columnDefinition = "text", nullable = false, name = "BRIEF_DESCRIPTION")
    @Size(min = 10, max = 1000)
    private String briefDescription;
    
    @Column(columnDefinition = "text", name = "DESCRIPTION")
    @Size(min = 10, max = 1000)
    private String description;
    
    @Column(columnDefinition = "int", name = "DURATION")
    private int duration;
    
    @Column(columnDefinition = "text", name = "DUR_CATEGORY")
    @Size(max = 25)
    private String durationCategory;
    
    @Column(columnDefinition = "text", name = "DUR_SUB_CATEGORY")
    @Size(max = 25)
    private String durationSubCategory;
    
    @Column(columnDefinition = "text", name = "DUR_EMP_TYPE")
    @Size(max = 25)
    private String durationEmpType;
    
    @Column(columnDefinition = "text", name = "DUR_STATUS")
    @Size(max = 25)
    private String durationStatus;
    
    @Column(columnDefinition = "text", name = "DUR_EXPR_LEVEL")
    @Size(max = 25)
    private String durationExperienceLevel;
    
    @Column(columnDefinition = "text", name = "DUR_POS_TYPE")
    @Size(max = 25)
    private String durationPositionType;
    
    @Column(columnDefinition = "text", name = "DUR_INTERVIEW_TYPE")
    @Size(max = 25)
    private String durationInterviewType;
    
    @Column(columnDefinition = "text", name = "DUR_VISA_TYPE")
    @Size(max = 25)
    private String durationVisaType;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DUR_PROJ_START_DATE")
    private Date durationProjectStartDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DUR_PROJ_CLOSE_DATE")
    private Date durationProjectCloseDate;
    
    @Column(columnDefinition = "text", name = "NOTES")
    @Size(min = 10, max = 500)
    private String notes;
    
    @Lob
    @Column(columnDefinition = "text", name = "ATTACHMENTS")
    private byte[] attachment;
    
    @Column(columnDefinition = "boolean", name = "ATTACH_MAKE_DEFAULT")
    private boolean localAttchMakeDefault;
    
    public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDurationCategory() {
		return durationCategory;
	}

	public void setDurationCategory(String durationCategory) {
		this.durationCategory = durationCategory;
	}

	public String getDurationSubCategory() {
		return durationSubCategory;
	}

	public void setDurationSubCategory(String durationSubCategory) {
		this.durationSubCategory = durationSubCategory;
	}

	public String getDurationEmpType() {
		return durationEmpType;
	}

	public void setDurationEmpType(String durationEmpType) {
		this.durationEmpType = durationEmpType;
	}

	public String getDurationStatus() {
		return durationStatus;
	}

	public void setDurationStatus(String durationStatus) {
		this.durationStatus = durationStatus;
	}

	public String getDurationExperienceLevel() {
		return durationExperienceLevel;
	}

	public void setDurationExperienceLevel(String durationExperienceLevel) {
		this.durationExperienceLevel = durationExperienceLevel;
	}

	public String getDurationPositionType() {
		return durationPositionType;
	}

	public void setDurationPositionType(String durationPositionType) {
		this.durationPositionType = durationPositionType;
	}

	public String getDurationInterviewType() {
		return durationInterviewType;
	}

	public void setDurationInterviewType(String durationInterviewType) {
		this.durationInterviewType = durationInterviewType;
	}

	public String getDurationVisaType() {
		return durationVisaType;
	}

	public void setDurationVisaType(String durationVisaType) {
		this.durationVisaType = durationVisaType;
	}

	public Date getDurationProjectStartDate() {
		return durationProjectStartDate;
	}

	public void setDurationProjectStartDate(Date durationProjectStartDate) {
		this.durationProjectStartDate = durationProjectStartDate;
	}

	public Date getDurationProjectCloseDate() {
		return durationProjectCloseDate;
	}

	public void setDurationProjectCloseDate(Date durationProjectCloseDate) {
		this.durationProjectCloseDate = durationProjectCloseDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public boolean isLocalAttchMakeDefault() {
		return localAttchMakeDefault;
	}

	public void setLocalAttchMakeDefault(boolean localAttchMakeDefault) {
		this.localAttchMakeDefault = localAttchMakeDefault;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	//-------------------------------------------------
    		//DELETE FROM HERE TILL END
    //-------------------------------------------------
    public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getOpeningTitle() {
		return openingTitle;
	}

	public void setOpeningTitle(String openingTitle) {
		this.openingTitle = openingTitle;
	}

	public String getOpeningId() {
		return openingId;
	}

	public void setOpeningId(String openingId) {
		this.openingId = openingId;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getPrimaryRecruiter() {
		return primaryRecruiter;
	}

	public void setPrimaryRecruiter(String primaryRecruiter) {
		this.primaryRecruiter = primaryRecruiter;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getAssignMoreRecruiter() {
		return assignMoreRecruiter;
	}

	public void setAssignMoreRecruiter(String assignMoreRecruiter) {
		this.assignMoreRecruiter = assignMoreRecruiter;
	}

	public String getEndClient() {
		return endClient;
	}

	public void setEndClient(String endClient) {
		this.endClient = endClient;
	}

	public String getRequiredExperience() {
		return requiredExperience;
	}

	public void setRequiredExperience(String requiredExperience) {
		this.requiredExperience = requiredExperience;
	}

	public int getBillRate() {
		return billRate;
	}

	public void setBillRate(int billRate) {
		this.billRate = billRate;
	}

	public String getPayRate() {
		return payRate;
	}

	public void setPayRate(String payRate) {
		this.payRate = payRate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getNumberOfOpenings() {
		return numberOfOpenings;
	}

	public void setNumberOfOpenings(long numberOfOpenings) {
		this.numberOfOpenings = numberOfOpenings;
	}

	public long getMaxResumesAllowed() {
		return maxResumesAllowed;
	}

	public void setMaxResumesAllowed(long maxResumesAllowed) {
		this.maxResumesAllowed = maxResumesAllowed;
	}

	public boolean isLocalIndicator() {
		return localIndicator;
	}

	public void setLocalIndicator(boolean localIndicator) {
		this.localIndicator = localIndicator;
	}

	private String type;
    @Column(columnDefinition = "text")
    private String address;
    @Column(columnDefinition = "text")
    private String phone;
    @Column(columnDefinition = "text")
    private String team;
    // added JsonMangedReference to add the client and requirement association via Spring data rest call
    // ref : https://stackoverflow.com/questions/29876978/spring-data-rest-one-to-many-cascade-all
    @JsonManagedReference
    @OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="accounts")
    @JsonIgnoreProperties("accounts")
    private List<Requirements> requirements;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return accountName;
	}

	public void setName(String name) {
		this.accountName = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public List<Requirements> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirements> requirements) {
		this.requirements = requirements;
	}
	
}
