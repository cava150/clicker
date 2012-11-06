package org.skravchenko.clicker.db.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.skravchenko.clicker.db.dao.IpAddressDao;
import org.skravchenko.clicker.db.entites.IPAddress;

import java.util.List;


public class IpAddressDaoImpl implements IpAddressDao {

    private static Logger _log = Logger.getLogger(IpAddressDaoImpl.class);
    private SessionFactory sesionFactory;

    public void addIpAddressEntity(IPAddress entity) {
        _log.info("Add IpAddress Entity started. Id = " + entity.getId());
        sesionFactory.openSession().save(entity);
        _log.info("Add IpAddress Entity finished. Id = " + entity.getId());
    }

    public IPAddress getById(int id) {
        IPAddress result;
        _log.info("Get IpAdreess entity started. Id = " + id);
        result = (IPAddress) sesionFactory.getCurrentSession().createCriteria(IPAddress.class)
                .add(Restrictions.eq("Id", id)).uniqueResult();
        _log.info("Get IpAdreess entity finished. Id = " + id);
        return result;
    }


    public List<IPAddress> getByIp(String ipAddress) {
       List<IPAddress> result;
        _log.info("Get IpAdreess entity by IpAddress started. ipAddress = " + ipAddress);
        result = (List<IPAddress>) sesionFactory.openSession().createCriteria(IPAddress.class)
                .add(Restrictions.eq("IpAddress", ipAddress)).list();
       _log.info("Get IpAdreess entity by IpAddress finished. ipAddress = " + ipAddress);
        return result;
    }

    public void updateIpAddressById(IPAddress entity) {
       _log.info("Update IpAdress entity by id started. Id = " + entity.getId());
        sesionFactory.getCurrentSession().saveOrUpdate(entity);
         _log.info("Update IpAdress entity by id finished. Id = " + entity.getId());
    }

    public void setSesionFactory(SessionFactory sesionFactory) {
        this.sesionFactory = sesionFactory;
    }

    public SessionFactory getSesionFactory() {
        return sesionFactory;
    }
}
