package com.firedge.modelo;

import com.firedge.hibernate.NewHibernateUtil;
import com.firedge.hibernate.Fotos;
import com.firedge.hibernate.Inmueble;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ModeloFotos {

    public static List<Fotos> get() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Inmueble";
        Query q = session.createQuery(hql);
        List<Fotos> list = q.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    public static Fotos get(String id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Fotos o = (Fotos) session.get(Fotos.class, Integer.parseInt(id));

        session.getTransaction().commit();
        session.close();
        
        return o;
    }
    
    public static List<Fotos> get(Inmueble inmueble) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "select f from Fotos as f where f.inmueble=:inmueble";
        Query q = session.createQuery(hql).setParameter("inmueble", inmueble);
        List<Fotos> list = q.list();

        session.getTransaction().commit();
        session.close();
        
        return list;
    }
    
    public static void delete(String id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Fotos o = (Fotos) session.load(Fotos.class, Integer.parseInt(id));
        session.delete(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void insert(Fotos i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(i);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void edit(Fotos i){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(i);

        session.getTransaction().commit();
        session.flush();
        session.close();
    }
}
