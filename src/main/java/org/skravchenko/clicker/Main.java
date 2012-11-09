package org.skravchenko.clicker;


import org.apache.log4j.Logger;
import org.skravchenko.clicker.db.dao.impl.IpAddressDaoImpl;
import org.skravchenko.clicker.db.entites.IPAddress;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static Logger _log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("container/Main.xml");
        IpAddressDaoImpl ipAddressDao = (IpAddressDaoImpl) context.getBean("IpAddressDaoImpl");
        IPAddress entity = new IPAddress();
        entity.setIpAddress("http://www.fgoogle.com");
        //entity.setTime((Date) Calendar.getInstance().getTime());
        ipAddressDao.addIpAddressEntity(entity);
    }
}
