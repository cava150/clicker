package org.skravchenko.clicker.db.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.skravchenko.clicker.db.dao.SiteDao;
import org.skravchenko.clicker.db.entites.IPAddress;
import org.skravchenko.clicker.db.entites.Site;

import java.util.List;

public class SiteDaoImpl implements SiteDao {

    private static Logger _log = Logger.getLogger(IpAddressDaoImpl.class);
    private SessionFactory sesionFactory;
    private Session session;

    public void addSiteEntity(Site entity) {
        session = sesionFactory.openSession();
        session.save(entity);
        session.close();
    }

    public Site getById(int id) {
        Site result;
        session = sesionFactory.openSession();
        result = (Site) session.createCriteria(Site.class)
                .add(Restrictions.eq("Id", id)).uniqueResult();
        session.close();
        return result;
    }

    public Site getBySiteUrl(String siteUrl) {
        Site result = null;
        session = sesionFactory.openSession();
        result = (Site) session.createCriteria(Site.class)
                .add(Restrictions.eq("url", siteUrl));
        session.close();
        return result;
    }

    public void UpdateSite(Site updatedEntity) {
        session = sesionFactory.openSession();
        session.saveOrUpdate(updatedEntity);
        session.close();
    }


    public void setSesionFactory(SessionFactory sesionFactory) {
        this.sesionFactory = sesionFactory;
    }

    public SessionFactory getSesionFactory() {
        return sesionFactory;
    }
}
