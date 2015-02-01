package com.firedge.modelo;

import com.firedge.hibernate.NewHibernateUtil;
import com.firedge.hibernate.Inmueble;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ModeloInmueble {

    public static List<Inmueble> get() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Inmueble";
        Query q = session.createQuery(hql);
        List<Inmueble> list = q.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    public static Inmueble get(String id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Inmueble o = (Inmueble) session.get(Inmueble.class, Integer.parseInt(id));

        session.getTransaction().commit();
        session.close();
        
        return o;
    }
    
    public static void delete(String id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Inmueble o = (Inmueble) session.load(Inmueble.class, Integer.parseInt(id));
        session.delete(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void insert(Inmueble i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(i);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void edit(Inmueble i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(i);

        session.getTransaction().commit();
        session.flush();
        session.close();
    }
}
