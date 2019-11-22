/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.dao;

import java.io.Serializable;
import java.util.List;
import students.entity.Profession;

/**
 *
 * @author dolodarenko
 */
public interface ProfessionDAO
{
    public Serializable addProfession(Profession p);
    public void updateProfession(Profession p);
    public void deleteProfession(Profession p);
    public List<Profession> findProfession();
}
