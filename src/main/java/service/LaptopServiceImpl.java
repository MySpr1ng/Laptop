package service;

import dao.LaptopDAO;
import dao.LaptopDAOImpl;
import entity.Laptop;

import java.util.Date;
import java.util.List;

/**
 * Created by Spring on 26.07.2017.
 */
public class LaptopServiceImpl implements LaptopService {

    private LaptopDAO dao;

    public LaptopServiceImpl() {
        dao = new LaptopDAOImpl();
    }

    public void create(Laptop laptop) {
     if(laptop !=null){
         laptop.setId(dao.create(laptop));
     }
    }

    public Laptop read(Long id) {
        if(id !=0 ){
            return dao.read(id);
        }
        return null;
    }

    public boolean update(Laptop laptopUpdate) {
        dao.update(laptopUpdate);
        return true;
    }

    public boolean delete(Laptop laptopDelete)
    {
        dao.delete(laptopDelete);
        return true;
    }

    public List<Laptop> findAll()
    {
        return dao.getAll();
    }

    public List<Laptop> showByModel(String model){
        return dao.findByModel(model);
    }

    public List<Laptop> showByPriceManufDate(Double price, Date date){
        return dao.findByPriceManufDate(price,date);
    }

    public List<Laptop> showByVendor(String vendor){
        return dao.findByVendor(vendor);
    }

    public List<Laptop> showBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date manufactureDate, String vendor) {
        return dao.findBetweenPriceLtDateByVendor(priceFrom,priceTo,manufactureDate,vendor);
    }

    public void deleteById(Long id){
        dao.deleteLaptopById(id);
    }

}
