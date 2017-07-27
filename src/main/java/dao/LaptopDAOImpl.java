package dao;

import Util.Util;
import entity.Laptop;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;


/**
 * Created by Spring on 25.07.2017.
 */
public class LaptopDAOImpl implements LaptopDAO {

    private SessionFactory factory;

    public LaptopDAOImpl() {
        factory = Util.getFactory();
    }

    public Long create(Laptop laptop) {
        Session session = factory.openSession();
        session.beginTransaction();
        Long id = (Long) session.save(laptop);
        session.getTransaction().commit();
        session.close();
            return id;
    }

    public Laptop read(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Laptop laptop = session.get(Laptop.class, id);
        session.close();
        return laptop;
    }

    public boolean update(Laptop laptopUpdate) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("update Laptop set serial =:serial, vendor = :vendor, manufactureDate =:manufactureDate, price =:price");
            query.setParameter("serial", laptopUpdate.getSerial());
            query.setParameter("vendor",laptopUpdate.getVendor());
            query.setParameter("manufactureDate", laptopUpdate.getManufactureDate());
            query.setParameter("price",laptopUpdate.getPrice());

            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exc) {
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(Laptop laptopDelete) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Laptop where id =:id");
            query.setParameter("id", laptopDelete.getId());
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException exc) {
        session.getTransaction().rollback();
            return false;
        }
    }

    public List<Laptop> findByModel(String model) {

        return factory.openSession().createQuery("from Laptop where model = :model").setParameter("model",model).list();

    }
/*среди 1 2 3 4 моделей у нас 2 - это переменная, которой мы передадим значение с помощью setParameter("название переменной",
 какое значение передать).
*/
    public List<Laptop> findByVendor(String vendor) {
        return factory.openSession().createQuery("from Laptop  where vendor = :vendor").setParameter("vendor", vendor).list();
    }

    public List<Laptop> findByPriceManufDate(Double price, Date manufactureDate) {
        return factory.openSession().createQuery("from Laptop where price = :price AND manufactureDate = :dat").setParameter("price",price).setParameter("dat", manufactureDate).list();

    }

    public List<Laptop> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date manufactureDate, String vendor) {
        return factory.openSession().createQuery("from Laptop where price between :priceFrom and :priceTo").setParameter("priceFrom",priceFrom).setParameter("priceTo",priceTo).list();

    }

    public List<Laptop> getAll() {
        return factory.openSession().createQuery("from Laptop").list();
    }

    public void deleteLaptopById(Long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete Laptop where id =:id");
            query.setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
        catch (HibernateException exc) {
            session.getTransaction().rollback();
        }
    }

}
