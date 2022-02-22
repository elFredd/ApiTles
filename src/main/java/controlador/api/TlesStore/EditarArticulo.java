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
import java.util.List;

/**
 * @created 05/12/2021 - 07:17 p. m.
 * @project ApiTles
 * @autor alfre
 */
@WebServlet("/Acciones/EditarArticulo")
public class EditarArticulo extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");

        Servicios servicios = new Servicios();
        JSONObject joArticulo=new JSONObject(request.getParameter("ArticuloGuardar"));
        Producto producto=(Producto) servicios.encontrar(joArticulo.getInt("IDArticulo"),Producto.class);
        producto.setCategoriaByIdCategoria((Categoria) servicios.buscarUnicoValor("FROM Categoria WHERE nombre='"+joArticulo.getString("NomCategoria")+"' and status=1"));
        producto.setNombre(joArticulo.getString("Nombre"));
        producto.setDescripcion(joArticulo.getString("Descripcion"));
        producto.setPrecio(joArticulo.getDouble("Precio"));



        if(!joArticulo.getString("Imagen").equals("")) {
            String path = request.getContextPath() + "/uploads/TheStore/Producto";
            String nombre = producto.getIdProducto() + ".png";
            new UploadsFiles().uploadImagenDataUrl(path, nombre, joArticulo.getString("Imagen"));
            producto.setImagen(path + "/" + nombre);
        }

        if(joArticulo.getBoolean("PlatilloProducto")) {
            producto.setDuracion(joArticulo.getInt("Duracion"));

            List<ProdIngre>listProdu=servicios.consultaHQLRetonarLista("FROM ProdIngre WHERE status=1 and productoByIdProducto="+producto.getIdProducto());
            for(ProdIngre prodIngre:listProdu){
                prodIngre.setStatus(-1);
                servicios.actualizar(producto);
            }

            JSONArray jaIngredienetes = (JSONArray) joArticulo.get("Ingredientes");
            for (int i = 0; i < jaIngredienetes.length(); i++) {
                String valor = jaIngredienetes.getString(i);
                valor = valor.substring(0, valor.indexOf(" - $"));
                ProdIngre prodIngre = new ProdIngre();
                prodIngre.setProductoByIdProducto(producto);
                prodIngre.setStatus(1);
                prodIngre.setIngredientesExtraByIdIngrediente((IngredientesExtra) servicios.buscarUnicoValor("FROM IngredientesExtra WHERE nombre='" + valor + "' and tiendaByIdTienda=" + producto.getTiendaByIdTienda().getIdTienda()));
                servicios.insertar(prodIngre);
            }
        }else{
            producto.setCantidad(joArticulo.getInt("Cantidad"));
        }
        servicios.actualizar(producto);
        servicios.CerrarConexion();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        System.out.println("Entro al get");

    }
}
