package controlador.api.TlesStore;

import controlador.servicios.Servicios;
import controlador.servicios.TerminosCondiciones;
import controlador.servicios.UploadsFiles;
import modelo.db.Tienda;
import modelo.db.Usuario;
import org.json.JSONObject;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @created 12/11/2021 - 10:48 p. m.
 * @project ApiTles
 * @autor alfre
 */

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationPath("/api")
@Path("/store")
public class ApiStore {

    @POST
    @Path("/ConsultaStoreInicio")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ConsultaStoreInicio(@QueryParam("usuarioId")int idUsuario) {

        JSONObject jo = new JSONObject();
        Servicios servicios = new Servicios();
        Usuario usuario = (Usuario) servicios.buscarUnicoValor("FROM Usuario where idUsuario="+idUsuario+ " and status=1");
        if(usuario!=null){
            jo.put("Nombre",usuario.getNombre());
            jo.put("Puntos",usuario.getPuntos());

        }else{
            //El usuario fue dado de baja
            jo.put("Error",1);
        }
        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }

    @POST
    @Path("/TraerAcuerdoLegarStore")
    @Produces(MediaType.TEXT_PLAIN)
    public Response TraerAcuerdoLegarStore() {
        return Response.ok(TerminosCondiciones.ACUERDO_STORE).build();
    }

    @POST
    @Path("/AceptarAcuerdoLegal")
    @Produces(MediaType.APPLICATION_JSON)
    public Response AceptarAcuerdoLegal(@QueryParam("usuarioId")int idUsuario) {

        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+idUsuario);
        tienda.setStatusAcuerdoLegal(1);
        servicios.actualizar(tienda);

        servicios.CerrarConexion();
        return Response.ok().build();
    }


    @POST
    @Path("/GuardarNombreStoreRegistrar")
    public Response GuardarNombreStoreRegistrar(@QueryParam("usuarioId")int idUsuario,@QueryParam("Nombre")String nombre) {

        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+idUsuario);
        tienda.setNombreCompleto(nombre);
        tienda.setStatusNombreCompleto(0);
        servicios.actualizar(tienda);

        servicios.CerrarConexion();
        return Response.ok().build();
    }

    @POST
    @Path("/GuardarNombreTiendaStoreRegistrar")
    public Response GuardarNombreTiendaStoreRegistrar(@QueryParam("usuarioId")int idUsuario,@QueryParam("NombreTienda")String nombre) {

        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+idUsuario);
        tienda.setNombre(nombre);
        servicios.actualizar(tienda);

        servicios.CerrarConexion();
        return Response.ok().build();
    }


    @POST
    @Path("/VerificarPasosRegistroTienda")
    @Produces(MediaType.APPLICATION_JSON)
    public Response VerificarPasosRegistroTienda(@QueryParam("usuarioId")int idUsuario) {

        JSONObject jo = new JSONObject();
        Servicios servicios = new Servicios();
        boolean tiendaAprobada=true;
        Tienda tineda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+idUsuario);
        if(tineda==null){
            tineda=new Tienda();
            tineda.setUsuarioByIdUsuario((Usuario) servicios.encontrar(idUsuario,Usuario.class));
            tineda.setNombre("");
            tineda.setImagen("");
            tineda.setStatusAcuerdoLegal(-1);
            tineda.setStatus(-1);
            tineda.setCiudadByIdCiudad(null);
            tineda.setFotoPerfil("");
            tineda.setActivaJornada(-1);
            tineda.setStatusFoto(-1);
            tineda.setStatusIne(-1);
            tineda.setIne("");
            tineda.setNombreCompleto("");
            tineda.setStatusNombreCompleto(-1);
            servicios.insertar(tineda);

            jo.put("StatusNombre",-1);
            jo.put("StatusNombreTienda",-1);
            jo.put("StatusAcuerdoLegal",-1);
            jo.put("StatusFotoPerfil",-1);
            jo.put("StatusCiudad",-1);
            jo.put("StatusIne",-1);
            tiendaAprobada=false;
        }else{

            jo.put("StatusNombre",tineda.getStatusNombreCompleto());
            if(tineda.getStatusNombreCompleto()!=1)
                tiendaAprobada=false;

            jo.put("StatusAcuerdoLegal",tineda.getStatusAcuerdoLegal());
            if(tineda.getStatusAcuerdoLegal()!=1)
                tiendaAprobada=false;

            jo.put("StatusFotoPerfil",tineda.getStatusFoto());
            if(tineda.getStatusFoto()!=1)
                tiendaAprobada=false;

            if(tineda.getCiudadByIdCiudad()==null) {
                jo.put("StatusCiudad", -1);
                tiendaAprobada=false;
            }else
                jo.put("StatusCiudad",1);

            if(tineda.getNombre().equals("")) {
                tiendaAprobada=false;
                jo.put("StatusNombreTienda", -1);
            }else
                jo.put("StatusNombreTienda",1);

            jo.put("StatusIne",tineda.getStatusIne());
            if(tineda.getStatusIne()!=1)
                tiendaAprobada=false;

        }
        jo.put("NombreUsuario",tineda.getUsuarioByIdUsuario().getNombre());
        if(tiendaAprobada)
            jo.put("IDTienda",tineda.getIdTienda());

        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }
}
