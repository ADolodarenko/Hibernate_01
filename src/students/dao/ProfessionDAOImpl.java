/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import students.entity.Profession;

/**
 *
 * @author dolodarenko
 */
public class ProfessionDAOImpl implements ProfessionDAO
{

    @Override
    public Serializable addProfession(Profession p) {
        System.out.println("addProfession called");
        return null;
    }

    @Override
    public void updateProfession(Profession p) {
        System.out.println("updateProfession called");
    }

    @Override
    public void deleteProfession(Profession p) {
        System.out.println("deleteProfession called");
    }

    @Override
    public List<Profession> findProfession() {
        System.out.println("findProfession called");
        List<Profession> list = new LinkedList<Profession>();
        list.add(new Profession());
        return list;
    }
}
