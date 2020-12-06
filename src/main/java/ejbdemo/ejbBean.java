package ejbdemo;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.*;

@Stateless
@LocalBean
@Path("/magasin")
public class ejbBean implements ejbInterface {

    private List<String> magasin = new ArrayList<>();
    private List<Double> prix = new ArrayList<>();

    private List<Integer> panier = new ArrayList<>();

    public ejbBean(){
        magasin.add(0,"pain");
        magasin.add(1,"chose");
        magasin.add(2,"truc");
        magasin.add(3,"mandarine");
        magasin.add(4,"banana");

        prix.add(0,200.0);
        prix.add(1,5.0);
        prix.add(2,40.0);
        prix.add(3,20.0);
        prix.add(4,25.0);
    }

    @PUT
    @Consumes("text/plain")
    @Override
    public void AddObject(@QueryParam("id") Integer id) {
        panier.add(id);
    }

    @DELETE
    @Consumes("text/plain")
    @Override
    public void RemoveObject(@QueryParam("id") Integer id) {
        int theId = id;
        panier.remove(theId);
    }

    @GET
    @Produces("text/html")
    @Override
    public String GetsObjects() {
        String html = "<table>";
        html += "<tr><th>ID</th> <th>Nom</th> <th>Prix</th> <th>action</th></tr>";
        for (Integer i = 0; i < magasin.size(); i++ ) {
            html += "<tr>";
            html += "<td>" + i.toString() +"</td>";
            html += "<td>" + magasin.get(i) +"</td>";
            html += "<td>" + prix.get(i) +"</td>";
            html += "<td><button style=\"width:45px;height:25px;\" onclick=\"AddToPanier("+i+")\">Add</button></td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }

    @POST
    @Produces("text/html")
    @Override
    public String GetsObjectsInPanier() {
        String html = "<table>";
        html += "<tr><th>ID</th> <th>Nom</th> <th>Prix</th> <th>action</th></tr>";
        for (Integer i = 0; i < panier.size(); i++ ) {
            html += "<tr>";
            html += "<td>" + panier.get(i) +"</td>";
            html += "<td>" + magasin.get(panier.get(i)) +"</td>";
            html += "<td>" + prix.get(panier.get(i)) +"</td>";
            html += "<td><button style=\"width:45px;height:25px;\" onclick=\"RemoveToPanier("+i+")\">Suppr.</button></td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }
}
