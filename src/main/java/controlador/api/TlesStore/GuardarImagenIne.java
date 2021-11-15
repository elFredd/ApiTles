package controlador.api.TlesStore;

import controlador.servicios.Servicios;
import controlador.servicios.UploadsFiles;
import modelo.db.Estado;
import modelo.db.Tienda;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * @created 14/11/2021 - 07:07 p. m.
 * @project ApiTles
 * @autor alfre
 */

@WebServlet("/Acciones/GuardarImagenIne")
public class GuardarImagenIne extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Entro al metodo 123");
        String root = getServletContext().getRealPath("/");
        response.setContentType("text/html; charset=UTF-8");
        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+request.getParameter("usuarioId"));
        tienda.setStatusIne(0);
        String path=root+"/uploads/TheStore/INE";
        String nombre=tienda.getUsuarioByIdUsuario().getNombre()+tienda.getIdTienda()+".png";
        new UploadsFiles().uploadImagenDataUrl(path,nombre,request.getParameter("dataUrlImagen"));
        tienda.setIne(path+"/"+nombre);
        servicios.actualizar(tienda);
        servicios.CerrarConexion();



    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        System.out.println("Entro al get");

    }
}
