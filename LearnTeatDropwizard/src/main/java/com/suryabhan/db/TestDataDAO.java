package com.suryabhan.db;

import com.suryabhan.core.TestDatabase;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by suryabhan on 22/04/16.
 */
public class TestDataDAO extends AbstractDAO<TestDatabase> {


    public TestDataDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<TestDatabase> findAll() {
        return list(namedQuery("com.suryabhan.core.TestDatabase.findAll"));
    }

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public int EnterDate(TestDatabase db)
    {
        try {
            //em.persist(db);

            return persist(db).getId();
        } catch (Exception e) {
           return 0;
        }
    }
}


