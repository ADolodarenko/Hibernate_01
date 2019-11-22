/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.view;

import students.entity.Profession;

/**
 *
 * @author dolodarenko
 */
public class ProfessionView
{
    private Long professionId;
    private String professionName;

    public ProfessionView() {
    }
    
    public ProfessionView(Profession p) {
        this.professionId = p.getProfessionId();
        this.professionName = p.getProfessionName();
    }

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
}
