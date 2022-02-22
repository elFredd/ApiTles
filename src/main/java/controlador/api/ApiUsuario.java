package controlador.api;

import controlador.core.AES.EncripAES;
import controlador.servicios.Servicios;
import controlador.servicios.TipoUsuario;
import modelo.DTO.TiendaDTO;
import modelo.DTO.UsuarioDTO;
import modelo.db.Tienda;
import modelo.db.Usuario;
import org.json.JSONObject;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @created 11/11/2021 - 08:27 p. m.
 * @project ApiTles
 * @autor alfre
 */

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationPath("/api")
@Path("/usuario")
public class ApiUsuario {


    @POST
    @Path("/ConsultaUsuarioInicio")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ConsultaUsuarioInicio(@QueryParam("usuarioId")int idUsuario) {

        JSONObject jo = new JSONObject();
        Servicios servicios = new Servicios();
        Usuario usuario = (Usuario) servicios.buscarUnicoValor("FROM Usuario where idUsuario="+idUsuario+ " and status=1");
        if(usuario!=null){
            jo.put("Usuario",new UsuarioDTO(usuario));
        }else{
            //El usuario fue dado de baja
            jo.put("Error",1);
        }


        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }

    @POST
    @Path("/ConsultaTiendaInicio")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ConsultaTiendaInicio(@QueryParam("usuarioId")int idUsuario) {


        Servicios servicios = new Servicios();
        Tienda tienda = (Tienda) servicios.buscarUnicoValor("FROM Tienda where usuarioByIdUsuario="+idUsuario+ " and status=1");
        servicios.CerrarConexion();
        TiendaDTO tiendaDTO =new TiendaDTO(tienda);
        return Response.ok(tiendaDTO).build();
    }

    @POST
    @Path("/AbrirCerrarTienda")
    public Response AbrirCerrarTienda(@QueryParam("idTienda")int idTienda) {
        Servicios servicios = new Servicios();
        Tienda tienda = (Tienda) servicios.encontrar(idTienda,Tienda.class);
        tienda.setActivaJornada(tienda.getActivaJornada()==1?0:1);
        servicios.actualizar(tienda);
        servicios.CerrarConexion();
        return Response.ok().build();
    }
}
