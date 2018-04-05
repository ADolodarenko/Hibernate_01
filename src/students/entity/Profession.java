/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dolodarenko
 */
public class Profession
{
    private Long professionId;
    private String professionName;
    private Set<Subject> subjectList = new HashSet<Subject>();

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }    

    public Set<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Set<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
