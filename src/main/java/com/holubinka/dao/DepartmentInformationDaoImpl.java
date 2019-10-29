package com.holubinka.dao;

import com.holubinka.model.Departs;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DepartmentInformationDaoImpl implements DepartmentInformationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Departs> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Departs d", Departs.class)
                .list();
    }

    @Override
    public Departs getHeadOfDepartment(String headOfDepart) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Departs d where d.headOfDepart =: headOfDepart", Departs.class)
                .setParameter("headOfDepart", headOfDepart)
                .uniqueResult();
    }

    @Override
    public Long getDepartDegreeCount(String degree, String departName) {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(l.name) from Lectors as l inner join l.degree d inner join l.departs dep where d.degree =: degree and dep.departName =:departName")
                .setParameter("degree", degree)
                .setParameter("departName", departName)
                .uniqueResult();
    }

    @Override
    public Double getAverageSalary(String departName) {
        return (Double) sessionFactory.getCurrentSession()
                .createQuery("select avg(l.salary) from Lectors as l inner join l.departs d where d.departName =: departName")
                .setParameter("departName", departName)
                .uniqueResult();
    }

    @Override
    public Long getEmployeesCount(String departName) {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(l.name) from Lectors as l inner join l.departs d where d.departName =: departName")
                .setParameter("departName", departName)
                .uniqueResult();
    }

    @Override
    public List<String> search(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("select l.name from Lectors as l where upper(l.name) like concat('%', :name, '%')")
                .setParameter("name", name.toUpperCase())
                .list();
    }
}
