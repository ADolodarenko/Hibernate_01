/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.entity;

import java.util.Set;

/**
 *
 * @author dolodarenko
 */
public class Subject
{
    private Long subjectId;
    private String subjectName;
    private Set<Profession> professionList;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<Profession> getProfessionList() {
        return professionList;
    }

    public void setProfessionList(Set<Profession> professionList) {
        this.professionList = professionList;
    }    
}
