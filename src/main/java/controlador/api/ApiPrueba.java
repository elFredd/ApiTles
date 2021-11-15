package controlador.api;

import controlador.servicios.Servicios;
import modelo.db.Estado;
import org.json.JSONObject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationPath("/api")
@Path("/prueba")
public class ApiPrueba {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        Estado estado=new Estado();
        estado.setNombre("Guerrero");
        Servicios servicios=new Servicios();
        servicios.insertar(estado);
        servicios.CerrarConexion();

        JSONObject obj=new JSONObject();
        obj.put("Hola123", "asjdnkajs151");
        obj.put("Hola365", "asjdnkaj545s");
        return Response.ok(obj.toString()).build();
    }

}
