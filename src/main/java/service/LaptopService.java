package service;

import entity.Laptop;

import java.util.Date;
import java.util.List;

/**
 * Created by Spring on 25.07.2017.
 */
public interface LaptopService {

    void create(Laptop laptop);

    Laptop read(Long id);

    boolean update(Laptop laptopUpdate);

    boolean delete(Laptop laptopDelete);

    List<Laptop> findAll();

    List<Laptop> showByModel(String model);

    List<Laptop> showByPriceManufDate(Double price, Date date);

    List<Laptop> showByVendor(String vendor);

    List<Laptop> showBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date manufactureDate, String vendor);

    void deleteById(Long id);
}
