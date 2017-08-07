import Util.Util;
import entity.Laptop;
import service.LaptopService;
import service.LaptopServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Spring on 25.07.2017.
 */
public class LaptopTest  {

    public static void main(String[] args)throws ParseException {

        SimpleDateFormat fm = new SimpleDateFormat("dd.MM.yyyy");
        LaptopService service = new LaptopServiceImpl();
        Laptop laptop = new Laptop("ff","ff","ff",new Date(),111.11);
        laptop.setVendor("gs");
        laptop.setModel("gs");
        laptop.setPrice(23.22);
        service.update(laptop);
    }
}
