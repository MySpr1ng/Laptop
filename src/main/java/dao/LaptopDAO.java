package dao;

import entity.Laptop;

import java.util.Date;
import java.util.List;

/**
 * Created by Spring on 25.07.2017.
 */
public interface LaptopDAO {

    //crud

    Long create(Laptop laptop);
    Laptop read(Long id);
    boolean update(Laptop laptopUpdate);
    boolean delete(Laptop laptopDelete);
    void deleteLaptopById(Long id);

    List<Laptop> findByModel(String model);

    List<Laptop> findByVendor(String vendor);

    List<Laptop> findByPriceManufDate(Double price, Date manufactureDate);

    List<Laptop> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);

    List<Laptop> getAll();

}
