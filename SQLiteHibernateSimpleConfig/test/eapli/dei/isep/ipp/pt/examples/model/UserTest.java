/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.dei.isep.ipp.pt.examples.model;

import eapli.dei.isep.ipp.pt.examples.hibernate.util.HibernateUtil;
import junit.framework.Assert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nuno
 */
public class UserTest {

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("AfterClass");
    }

    @Before
    public void setUp() {
        System.out.println("BeforeTest");
    }

    @After
    public void tearDown() {
        System.out.println("AfterTest");
    }

    @Test
    public void testSave() {
        try {

            User user = new User();
            user.setName("John");
            user.setAge(25);

            Session session = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();

            //Find by id
            User userDB = (User) session.load(User.class, user.getId());

            Assert.assertEquals(user.getName(), userDB.getName());

        } catch (Throwable e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
