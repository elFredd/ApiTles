package controlador.api.TlesStore;

import controlador.servicios.Servicios;
import controlador.servicios.UploadsFiles;
import modelo.db.Tienda;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @created 14/11/2021 - 08:39 p. m.
 * @project ApiTles
 * @autor alfre
 */
@WebServlet("/Acciones/GuardarImagenFotoPerfil")
public class GuardarImagenFotoPerfil extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String root = getServletContext().getRealPath("/");
        response.setContentType("text/html; charset=UTF-8");
        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+request.getParameter("usuarioId"));
        tienda.setStatusFoto(0);
        String path=root+"/uploads/TheStore/FotoPerfil";
        String nombre=tienda.getUsuarioByIdUsuario().getNombre()+tienda.getIdTienda()+".png";
        new UploadsFiles().uploadImagenDataUrl(path,nombre,request.getParameter("dataUrlImagen"));
        tienda.setFotoPerfil(path+"/"+nombre);
        servicios.actualizar(tienda);
        servicios.CerrarConexion();



    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        System.out.println("Entro al get");

    }
}
