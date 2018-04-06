/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author dolodarenko
 */

@Entity
@Table(name = "SUBJECT")
public class Subject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID")
    private Long subjectId;
    
    @Column(name = "SUBJECT_NAME")
    private String subjectName;
    
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "SPECIALITY_SUBJECT",
            joinColumns = @JoinColumn(name = "SUBJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROFESSION_ID"))
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
