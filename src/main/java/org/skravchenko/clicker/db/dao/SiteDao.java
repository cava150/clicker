package org.skravchenko.clicker.db.dao;


import org.skravchenko.clicker.db.entites.Site;

public interface SiteDao {
    public void addSiteEntity(Site entity);
    public Site getById(int id);
    public Site getBySiteUrl(String siteUrl);
    public void UpdateSite(Site updatedEntity);
}
