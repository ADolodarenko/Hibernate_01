/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.entity;

import java.util.List;

/**
 *
 * @author dolodarenko
 */
public class Applicant
{
    private Long applicantId;
    private Profession profession;
    private List<ApplicantResult> applicantResultList;
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer entranceYear;

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public List<ApplicantResult> getApplicantResultList() {
        return applicantResultList;
    }

    public void setApplicantResultList(List<ApplicantResult> applicantResultList) {
        this.applicantResultList = applicantResultList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(Integer entranceYear) {
        this.entranceYear = entranceYear;
    }
}
