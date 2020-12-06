package ejbdemo;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

@Remote
public interface ejbInterface {
    public void AddObject(Integer id);
    public void RemoveObject(Integer id);
    public String GetsObjects();
    public String GetsObjectsInPanier();
}
