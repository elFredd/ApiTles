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
 * @created 24/11/2021 - 09:18 p. m.
 * @project ApiTles
 * @autor alfre
 */
@WebServlet("/Acciones/GuardarPlatillo")
public class GuardarPlatillo extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");

        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+request.getParameter("usuarioId"));
        JSONObject joArticulo=new JSONObject(request.getParameter("ArticuloGuardar"));
        Producto producto=new Producto();
        producto.setStatus(1);
        producto.setTiendaByIdTienda(tienda);
        producto.setCategoriaByIdCategoria((Categoria) servicios.encontrar(joArticulo.getInt("IDTipoProducto"),Categoria.class));
        producto.setNombre(joArticulo.getString("Nombre"));
        producto.setImagen("");
        producto.setDescripcion(joArticulo.getString("Descripcion"));
        producto.setPrecio(joArticulo.getDouble("Precio"));
        producto.setDuracion(joArticulo.getInt("Duracion"));
        servicios.insertar(producto);


        String path= request.getContextPath()+"/uploads/TheStore/Producto";
        String nombre=producto.getIdProducto()+".png";
        new UploadsFiles().uploadImagenDataUrl(path,nombre,joArticulo.getString("Imagen"));
        producto.setImagen(path+"/"+nombre);
        servicios.actualizar(producto);

        JSONArray jaIngredienetes=(JSONArray)joArticulo.get("Ingredientes");
        for(int i=0;i<jaIngredienetes.length();i++){
            String valor=jaIngredienetes.getString(i);
            valor=valor.substring(0,valor.indexOf(" - $"));
            System.out.println(valor+" ------------------");
            ProdIngre prodIngre=new ProdIngre();
            prodIngre.setProductoByIdProducto(producto);
            prodIngre.setStatus(1);
            prodIngre.setIngredientesExtraByIdIngrediente((IngredientesExtra) servicios.buscarUnicoValor("FROM IngredientesExtra WHERE nombre='"+valor+"' and tiendaByIdTienda="+tienda.getIdTienda()));
            servicios.insertar(prodIngre);
        }
        servicios.CerrarConexion();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        System.out.println("Entro al get");

    }
}
