package org.skravchenko.clicker.db.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.skravchenko.clicker.db.dao.IpAddressDao;
import org.skravchenko.clicker.db.entites.IPAddress;

import java.util.List;


public class IpAddressDaoImpl implements IpAddressDao {

    private static Logger _log = Logger.getLogger(IpAddressDaoImpl.class);
    private SessionFactory sesionFactory;

    public void addIpAddressEntity(IPAddress entity) {
        sesionFactory.openSession().save(entity);
    }

    public IPAddress getById(int id) {
        IPAddress result;
        Session session = sesionFactory.openSession();
        result = (IPAddress) session.createCriteria(IPAddress.class)
                .add(Restrictions.eq("Id", id)).uniqueResult();
        session.close();
        return result;
    }

    public List<IPAddress> getByIp(String ipAddress) {
       List<IPAddress> result;
        Session session = sesionFactory.openSession();
        result = (List<IPAddress>) session.createCriteria(IPAddress.class)
                .add(Restrictions.eq("IpAddress", ipAddress)).list();
        session.close();
        return result;
    }

    public void updateIpAddressById(IPAddress entity) {
        Session session = sesionFactory.openSession();
        session.saveOrUpdate(entity);
        session.close();
    }

    public void setSesionFactory(SessionFactory sesionFactory) {
        this.sesionFactory = sesionFactory;
    }

    public SessionFactory getSesionFactory() {
        return sesionFactory;
    }
}
