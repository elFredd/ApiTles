package controlador.api;

import controlador.core.AES.DesEncripAES;
import controlador.core.AES.EncripAES;
import controlador.servicios.Servicios;
import controlador.servicios.TipoUsuario;
import modelo.db.Estado;
import modelo.db.Usuario;
import org.json.JSONObject;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @created 10/11/2021 - 11:13 p. m.
 * @project ApiTles
 * @autor alfre
 */

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationPath("/api")
@Path("/login")
public class ApiLogin {

    @POST
    @Path("/RegistrarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response RegistrarUsuario(@QueryParam("Nombre") String nombre,@QueryParam("Apellido") String apellido,@QueryParam("CorreoOTelefono") String correoOTelefono,@QueryParam("Password") String password) {

        JSONObject jo = new JSONObject();
        Servicios servicios = new Servicios();
        Usuario usuario = (Usuario) servicios.buscarUnicoValor("FROM Usuario where correo='" + correoOTelefono + "' or telefono='" + correoOTelefono + "'");
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setApellido(apellido);
            usuario.setTipoUsuario(TipoUsuario.USUARIO);
            usuario.setNombre(nombre);
            if (servicios.isCorreo(correoOTelefono)) {
                usuario.setCorreo(correoOTelefono);
                usuario.setValidarCorreo(0);
                usuario.setTelefono("");
                usuario.setValidarTelefono(0);
            } else if (servicios.isNumero(correoOTelefono)) {
                usuario.setTelefono(correoOTelefono);
                usuario.setValidarTelefono(0);
                usuario.setCorreo("");
                usuario.setValidarCorreo(0);
            }
            usuario.setPassword(new EncripAES(password).resultadoEncrip);
            usuario.setStatus(1);
            usuario.setPuntos(0);
            usuario.setFechaRegistro(Timestamp.valueOf(LocalDateTime.now()));
            servicios.insertar(usuario);
            jo.put("ID", usuario.getIdUsuario());
        } else {
            //Que Existe ya un usuario con el correo o el telefono
            jo.put("Error", 1);
        }

        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }

    @POST
    @Path("/IniciarSesion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response IniciarSesion(@QueryParam("CorreoOTelefono") String correoOTelefono,@QueryParam("Password") String password) {

        JSONObject jo = new JSONObject();
        Servicios servicios = new Servicios();
        Usuario usuario = (Usuario) servicios.buscarUnicoValor("FROM Usuario where (correo='" + correoOTelefono + "' or telefono='" + correoOTelefono + "') and password='"+new EncripAES(password).resultadoEncrip +"'");
        if (usuario != null) {
            if(usuario.getStatus()==1){
                jo.put("ID",usuario.getIdUsuario());
                if((usuario.getTelefono().length()>0 && usuario.getValidarTelefono()==0 ) || (usuario.getCorreo().length()>0 && usuario.getValidarCorreo()==0)){
                    //Validar telefono o correo no estan validos
                    jo.put("Validar",1);
                }
            }else {
                //El usuario fue dado de baja
                jo.put("Error", 2);
            }
        } else {
            //Que No existe el usuario
            jo.put("Error", 1);
        }

        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }


}
