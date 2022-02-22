package controlador.api.TlesStore;

import controlador.servicios.Servicios;
import controlador.servicios.UploadsFiles;
import modelo.db.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @created 04/12/2021 - 06:47 p. m.
 * @project ApiTles
 * @autor alfre
 */
@WebServlet("/Acciones/GuardarProducto")
public class GuardarProducto extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");

        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+request.getParameter("usuarioId"));
        JSONObject joArticulo=new JSONObject(request.getParameter("ArticuloGuardar"));
        Producto producto=new Producto();
        producto.setStatus(1);
        producto.setTiendaByIdTienda(tienda);
        producto.setCategoriaByIdCategoria((Categoria) servicios.encontrar(joArticulo.getInt("IDCategoria"),Categoria.class));
        producto.setNombre(joArticulo.getString("Nombre"));
        producto.setImagen("");
        producto.setDescripcion(joArticulo.getString("Descripcion"));
        producto.setPrecio(joArticulo.getDouble("Precio"));
        producto.setCantidad(joArticulo.getInt("Cantidad"));
        servicios.insertar(producto);


        String path= request.getContextPath()+"/uploads/TheStore/Producto";
        String nombre=producto.getIdProducto()+".png";
        new UploadsFiles().uploadImagenDataUrl(path,nombre,joArticulo.getString("Imagen"));
        producto.setImagen(path+"/"+nombre);
        servicios.actualizar(producto);

        servicios.CerrarConexion();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        System.out.println("Entro al get");

    }
}
