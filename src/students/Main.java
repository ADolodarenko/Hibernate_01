/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.context.support.FileSystemXmlApplicationContext;
//import students.dao.StudentDAO;
//import students.entity.Applicant;
import students.entity.Profession;
//import students.entity.Subject;
import students.utils.HibernateUtil;
import students.facade.ProfessionFacade;
import students.view.ProfessionView;

/**
 *
 * @author dolodarenko
 */
public class Main
{    
    public static void main(String[] args)
    {
        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext(
                new String[]{"src/StudentExample.xml", "src/StudentDatabase.xml"});
 
        ProfessionFacade pf = (ProfessionFacade)context.getBean("professionFacade");
        ProfessionView pv = new ProfessionView();
        pv.setProfessionName("Java Developer");
        Long id = pf.addProfession(pv);
        pv.setProfessionId(id);
        pf.updateProfession(pv);
        pf.deleteProfession(pv);
        pf.findProfession();
        
        /*
        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext(
                new String[]{"src/StudentExample.xml"});
 
        ProfessionFacade pf = (ProfessionFacade)context.getBean("professionFacadeProxy");
        ProfessionView pv = new ProfessionView();
        pf.addProfession(pv);
        pf.updateProfession(pv);
        pf.deleteProfession(pv);
        pf.findProfession();
        */
        
        
        /*
        StudentDAO dao = new StudentDAO();
 
        // Добавление новых предметов
        Subject subject = new Subject();
        subject.setSubjectName("Mathematics");
        dao.addSubject(subject);
        subject = new Subject();
        subject.setSubjectName("Chemistry");
        dao.addSubject(subject);
        subject = new Subject();
        subject.setSubjectName("Logic");
        dao.addSubject(subject);
 
        System.out.println("List of SUBJECTS");
        System.out.println("----------------");
        List<Subject> sbList = dao.findSubject();
        // В списке вы увидите, что предметы пока не привязаны к профессиям - количество = 0
        for (Subject a : sbList)
            System.out.println(a.getSubjectId() + ":" + a.getSubjectName() +
                    ". Number of profession:" + a.getProfessionList().size());
 
        // Теперь добавим профессии
        Profession profession = new Profession();
        profession.setProfessionName("Programmer");
        // Список предметов, которые надо сдавать для этой профессии
        // Обратите внимание, что в классе Profession мы создаем пустой список
        // чтобы не было NullPointerException
        profession.getSubjectList().add(sbList.get(0));
        profession.getSubjectList().add(sbList.get(2));
        dao.addProfession(profession);
        profession = new Profession();
        profession.setProfessionName("Biologist");
        profession.getSubjectList().add(sbList.get(1));
        profession.getSubjectList().add(sbList.get(2));
        // Получим профессию по ID и добавим еще один предмет для сдачи
        Long id = dao.addProfession(profession);
        profession = dao.getProfession(id);
        profession.getSubjectList().add(sbList.get(0));
        dao.updateProfession(profession);
 
        // Смотрим список профессий
        System.out.println();
        System.out.println("List of PROFESSIONS");
        System.out.println("-------------------");
        List<Profession> prList = dao.findProfession();
        for (Profession a : prList)
            System.out.println(a.getProfessionId() + ":" + a.getProfessionName());
         
        System.out.println();
        System.out.println("List of SUBJECTS");
        System.out.println("----------------");
        sbList = dao.findSubject();
        // В списке вы увидите, что предметы теперь привязаны к профессиям - количество > 0
        for (Subject a : sbList)
            System.out.println(a.getSubjectId() + ":" + a.getSubjectName() +
                    ". Number of profession:" + a.getProfessionList().size());
 
        // А теперь создадим новых абитуриентов
        Applicant applicant = new Applicant();
        applicant.setFirstName("John");
        applicant.setMiddleName("M");
        applicant.setLastName("Danny");
        // Задаем профессию
        applicant.setProfession(prList.get(0));
        applicant.setEntranceYear(2009);
        dao.addApplicant(applicant);
        applicant = new Applicant();
        applicant.setFirstName("Poul");
        applicant.setMiddleName("H");
        applicant.setLastName("Tride");
        // Задаем профессию
        applicant.setProfession(prList.get(1));
        applicant.setEntranceYear(2009);
        dao.addApplicant(applicant);
 
        System.out.println();
        System.out.println("List of APPLICANTS");
        System.out.println("------------------");
        List<Applicant> apList = dao.findApplicant();
        for (Applicant a : apList) {
            System.out.println(a.getFirstName() + ":" + a.getLastName() + " - " + a.getProfession().getProfessionName());
        // Если убрать комментарий, то получим сообщене об ошибке - коллекция не инициализирована
        // Но еще можно посмотреть комментарий в StudentDAO (метод findApplicant()).
            System.out.println(a.getProfession().getSubjectList().size());
        }
        */
    }
    
    // Данный метод просто показывает, как делается запрос при работе на уровне JDBC
    private void oldJDBC()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.62:3306/db_applicant", "dolodarenko", "luisiana969");
            statement = connection.createStatement();
            
            List<Profession> list = new ArrayList<Profession>();
            
            rs = statement.executeQuery("select PROFESSION_ID, PROFESSION_NAME from PROFESSION " +
                    "order by PROFESSION_NAME");
            while (rs.next())
            {
                Profession r = new Profession();
                r.setProfessionId(rs.getLong("PROFESSION_ID"));
                r.setProfessionName(rs.getString("PROFESSION_NAME"));
                list.add(r);
                System.out.println(r.getProfessionId() + ":" + r.getProfessionName());
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            System.err.println("Error SQL execution: " + ex.getMessage());
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            System.err.println("Error SQL execution: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if (rs != null)
                    rs.close();
               
                if (statement != null)
                    statement.close();
                
                if (connection != null)
                    connection.close();
                
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }
    
    // Метод добавляет новую запись в таблицу PROFESSION
    private void addProfession(String name)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Profession r = new Profession();
        r.setProfessionName(name);
        session.save(r);
        session.getTransaction().commit();
    }
 
    // Метод возвращает список профессий
    private List<Profession> listProfession()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Profession> result = session.createQuery("from Profession order by professionName").list();
        session.getTransaction().commit();
        return result;
    }
 
    // Метод удаляет по очереди все записи, которые ему переданы в виде списка
    private void deleteProfessions(List<Profession> result)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        for (Profession p : result)
        {
            System.out.println("Delete: " + p.getProfessionId() + ":" + p.getProfessionName());
            session.delete(p);
            //session.flush();
        }
        session.getTransaction().commit();
    }
 
    // Метод удаляет одну запись
    private void deleteEntity(Object o)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
    }
}
