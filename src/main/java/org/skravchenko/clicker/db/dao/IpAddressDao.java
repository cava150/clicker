package org.skravchenko.clicker.db.dao;


import org.skravchenko.clicker.db.entites.IPAddress;

import java.util.List;

public interface IpAddressDao {
    public void addIpAddressEntity(IPAddress entity);
    public IPAddress getById(int id);
    public List<IPAddress> getByIp(String ipAddress);
    public void updateIpAddressById(IPAddress entity);
}
