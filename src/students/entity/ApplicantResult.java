/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.entity;

/**
 *
 * @author dolodarenko
 */
public class ApplicantResult
{
    private Long applicantResultId;
    private Applicant applicant;
    private Subject subject;
    private Integer mark;

    public Long getApplicantResultId() {
        return applicantResultId;
    }

    public void setApplicantResultId(Long applicantResultId) {
        this.applicantResultId = applicantResultId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
