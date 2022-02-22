package controlador.api.TlesStore;

import controlador.servicios.Servicios;
import controlador.servicios.TerminosCondiciones;
import controlador.servicios.TipoTienda;
import controlador.servicios.UploadsFiles;
import modelo.db.*;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
    @Path("/TraerEstadosStore")
    public Response TraerEstadosStore() {

        Servicios servicios = new Servicios();
        List<Estado> listEstados=servicios.listar("Estado");
        JSONArray ja=new JSONArray();
        for(int i=0;i<listEstados.size();i++){
            ja.put(i,listEstados.get(i).getNombre());
        }

        servicios.CerrarConexion();
        return Response.ok(ja.toString()).build();
    }

    @POST
    @Path("/TraerCiudadesStore")
    public Response TraerCiudadesStore(@QueryParam("estado")String estado) {

        Servicios servicios = new Servicios();
        List<Ciudad> listCiudad=servicios.consultaHQLRetonarLista("FROM Ciudad WHERE estadoByIdEstado.nombre='"+estado+"'");
        JSONArray ja=new JSONArray();
        for(int i=0;i<listCiudad.size();i++){
            ja.put(i,listCiudad.get(i).getNombre());
        }

        servicios.CerrarConexion();
        return Response.ok(ja.toString()).build();
    }

    @POST
    @Path("/GuardarCiudadStoreRegistro")
    public Response GuardarCiudadStoreRegistro(@QueryParam("usuarioId")int usuarioId,@QueryParam("estado")String estado,@QueryParam("ciudad") String ciudad) {

        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+usuarioId);
       // tienda.setCiudadByIdCiudad((Ciudad) servicios.buscarUnicoValor("FROM Ciudad WHERE nombre='"+ciudad+"' and estadoByIdEstado.nombre='"+estado+"'"));
        servicios.actualizar(tienda);
        servicios.CerrarConexion();
        return Response.ok().build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/TraerProductosTienda")
    public Response TraerProductosTienda(@QueryParam("storeId")int storeId) {

        Servicios servicios = new Servicios();
        List<Producto>listProducto=servicios.consultaHQLRetonarLista("FROM Producto WHERE status<>-1 AND tiendaByIdTienda="+storeId);
        Tienda tienda=(Tienda)servicios.encontrar(storeId,Tienda.class);
        JSONObject joPrincipal=new JSONObject();
        JSONArray jaProductos=new JSONArray();
        int i=0;
        for(Producto producto:listProducto){
            JSONObject joProducto=new JSONObject();
            joProducto.put("Nombre",producto.getNombre());
            joProducto.put("IDProducto",producto.getIdProducto());
            joProducto.put("Precio",producto.getPrecio());
            joProducto.put("Imagen",producto.getImagen());
            joProducto.put("Categoria", producto.getCategoriaByIdCategoria().getNombre());
            joProducto.put("Estado",producto.getStatus());
            jaProductos.put(i,joProducto);
            i++;
        }
        if(tienda.getStatus()==-1)
            joPrincipal.put("StatusTienda","");

        joPrincipal.put("TipoTienda",tienda.getTipoTienda());
        joPrincipal.put("Productos",jaProductos);
        servicios.CerrarConexion();
        return Response.ok(joPrincipal.toString()).build();
    }

    @POST
    @Path("/GuardarNuevoIngredientes")
    public Response GuardarNuevoIngredientes(@QueryParam("storeId")int storeId,@QueryParam("nombre") String nombre,@QueryParam("precio") double precio,@QueryParam("Variantes") String variantes) {

        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.encontrar(storeId,Tienda.class);
        IngredientesExtra ingredientesExtra=new IngredientesExtra();
        ingredientesExtra.setStatus(1);
        ingredientesExtra.setNombre(nombre);
        ingredientesExtra.setPrecio(precio);
        ingredientesExtra.setTiendaByIdTienda(tienda);
        servicios.insertar(ingredientesExtra);

        JSONArray jaVariantes=new JSONArray(variantes);
        for(int i=0;i< jaVariantes.length();i++){
            VariantesIngrediente variantesIngrediente=new VariantesIngrediente();
            variantesIngrediente.setNombre(jaVariantes.getString(i));
            variantesIngrediente.setStatus(1);
            variantesIngrediente.setIngredientesExtraByIdIngrediente(ingredientesExtra);
            servicios.insertar(variantesIngrediente);
        }

        servicios.CerrarConexion();
        return Response.ok().build();
    }

    @POST
    @Path("/EditarIngredientes")
    public Response EditarIngredientes(@QueryParam("nombre") String nombre,@QueryParam("precio") double precio,@QueryParam("id")int id,@QueryParam("Variantes") String variantes) {

        Servicios servicios = new Servicios();
        IngredientesExtra ingredientesExtra=(IngredientesExtra) servicios.encontrar(id,IngredientesExtra.class);
        ingredientesExtra.setNombre(nombre);
        ingredientesExtra.setPrecio(precio);
        servicios.actualizar(ingredientesExtra);

        List<VariantesIngrediente>listVariantes=servicios.consultaHQLRetonarLista("FROM VariantesIngrediente WHERE ingredientesExtraByIdIngrediente="+id+" AND status=1");
        for(VariantesIngrediente varTemp:listVariantes){
            varTemp.setStatus(-1);
            servicios.actualizar(varTemp);
        }

        JSONArray jaVariantes=new JSONArray(variantes);
        for(int i=0;i< jaVariantes.length();i++){
            VariantesIngrediente variantesIngrediente=new VariantesIngrediente();
            variantesIngrediente.setNombre(jaVariantes.getString(i));
            variantesIngrediente.setStatus(1);
            variantesIngrediente.setIngredientesExtraByIdIngrediente(ingredientesExtra);
            servicios.insertar(variantesIngrediente);
        }

        servicios.CerrarConexion();
        return Response.ok().build();
    }

    @POST
    @Path("/EliminarIngredientes")
    public Response EliminarIngredientes(@QueryParam("id")int id) {

        Servicios servicios = new Servicios();
        IngredientesExtra ingredientesExtra=(IngredientesExtra) servicios.encontrar(id,IngredientesExtra.class);
        ingredientesExtra.setStatus(-1);
        servicios.actualizar(ingredientesExtra);
        servicios.CerrarConexion();
        return Response.ok().build();
    }
    @POST
    @Path("/GuardarTipoTienda")
    public Response GuardarTipoTienda(@QueryParam("usuarioId")int usuarioId,@QueryParam("tipoTienda")int tipoTienda) {

        Servicios servicios = new Servicios();
        Tienda tienda=(Tienda)servicios.buscarUnicoValor("FROM Tienda WHERE usuarioByIdUsuario="+usuarioId);
        switch (tipoTienda){
            case 1:
                tienda.setTipoTienda(TipoTienda.SUPERMERCADO);
                break;
            case 2:
                tienda.setTipoTienda(TipoTienda.RESTAURANTE);
        }
        servicios.actualizar(tienda);
        servicios.CerrarConexion();
        return Response.ok().build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ConsultaComisionTienda")
    public Response ConsultaComisionTienda() {

        Servicios servicios = new Servicios();
        Configuracion configuracion=(Configuracion) servicios.buscarUnicoValor("FROM Configuracion WHERE status=1");

        JSONObject jo=new JSONObject();
        jo.put("ComisionVentas",configuracion.getComisionVentaStore());
        jo.put("PrecioMinimo",configuracion.getPrecioMinimoTienda());
        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/TraerIngredientesExtra")
    public Response TraerIngredientesExtra(@QueryParam("storeId")int storeId) {

        Servicios servicios = new Servicios();
        JSONArray jaIngredientes=new JSONArray();
        List<IngredientesExtra> listIngredientes=servicios.consultaHQLRetonarLista("FROM IngredientesExtra WHERE tiendaByIdTienda="+storeId+" AND status=1");

        for(int i=0;i<listIngredientes.size();i++){
            JSONObject jo=new JSONObject();
            jo.put("ID",listIngredientes.get(i).getIdIngredietes());
            jo.put("Nombre",listIngredientes.get(i).getNombre());
            jo.put("Precio",listIngredientes.get(i).getPrecio());

            List<VariantesIngrediente>listVariantes=servicios.consultaHQLRetonarLista("FROM VariantesIngrediente WHERE ingredientesExtraByIdIngrediente="+listIngredientes.get(i).getIdIngredietes()+" AND status=1");
            JSONArray jaVariantes=new JSONArray();
            for(int j=0;j<listVariantes.size();j++){
                JSONObject joVaiante=new JSONObject();
                VariantesIngrediente variante= listVariantes.get(j);
                joVaiante.put("Nombre",variante.getNombre());
                joVaiante.put("ID",variante.getIdVarianteIngrediente());
                jaVariantes.put(j,joVaiante);
            }
            jo.put("Variantes",jaVariantes);

            jaIngredientes.put(i,jo);
        }
        servicios.CerrarConexion();
        return Response.ok(jaIngredientes.toString()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/TraerTipoPlatillos")
    public Response TraerTipoPlatillos() {

        Servicios servicios = new Servicios();
        List<Categoria> listCate= servicios.consultaHQLRetonarLista("FROM Categoria WHERE status=1 and tipoTienda='"+TipoTienda.RESTAURANTE+"'");

        JSONArray ja=new JSONArray();
        for(int i=0;i< listCate.size();i++){
            Categoria categoria=listCate.get(i);
            JSONObject jo=new JSONObject();
            jo.put("ID",categoria.getIdCategoria());
            jo.put("Nombre",categoria.getNombre());
            jo.put("Imagen",categoria.getImagen());
            ja.put(i,jo);
        }
        servicios.CerrarConexion();

        return Response.ok(ja.toString()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/TraerCategoriasProductos")
    public Response TraerCategoriasProductos() {

        Servicios servicios = new Servicios();
        List<Categoria> listCate= servicios.consultaHQLRetonarLista("FROM Categoria WHERE status=1 and tipoTienda='"+TipoTienda.SUPERMERCADO+"'");

        JSONArray ja=new JSONArray();
        for(int i=0;i< listCate.size();i++){
            Categoria categoria=listCate.get(i);
            JSONObject jo=new JSONObject();
            jo.put("ID",categoria.getIdCategoria());
            jo.put("Nombre",categoria.getNombre());
            jo.put("Imagen",categoria.getImagen());
            ja.put(i,jo);
        }
        servicios.CerrarConexion();

        return Response.ok(ja.toString()).build();
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
            tineda.setStatus(1);
            tineda.setDireccionByIdDireccion(null);
            tineda.setFotoPerfil("");
            tineda.setTipoTienda("");
            tineda.setActivaJornada(-1);
            tineda.setStatusFoto(-1);
            tineda.setStatusIne(-1);
            tineda.setIne("");
            tineda.setNombreCompleto("");
            tineda.setStatusNombreCompleto(-1);
            servicios.insertar(tineda);

            jo.put("StatusTipoTienda",-1);
            jo.put("StatusNombre",-1);
            jo.put("StatusNombreTienda",-1);
            jo.put("StatusAcuerdoLegal",-1);
            jo.put("StatusFotoPerfil",-1);
            jo.put("StatusDireccion",-1);
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

            if(tineda.getDireccionByIdDireccion()==null) {
                jo.put("StatusDireccion", -1);
                tiendaAprobada=false;
            }else
                jo.put("StatusDireccion",1);

            if(tineda.getNombre().equals("")) {
                tiendaAprobada=false;
                jo.put("StatusNombreTienda", -1);
            }else
                jo.put("StatusNombreTienda",1);

            if(tineda.getTipoTienda().equals("")) {
                tiendaAprobada=false;
                jo.put("StatusTipoTienda", -1);
            }else
                jo.put("StatusTipoTienda",1);

            jo.put("StatusIne",tineda.getStatusIne());
            if(tineda.getStatusIne()!=1)
                tiendaAprobada=false;

        }
        jo.put("NombreUsuario",tineda.getUsuarioByIdUsuario().getNombre());
        if(tiendaAprobada) {
            tineda.setStatus(0);
            servicios.actualizar(tineda);
            jo.put("IDTienda", tineda.getIdTienda());
        }

        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }


    @POST
    @Path("/DarBajaAltaProducto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response DarBajaAltaProducto(@QueryParam("id")int id) {

        JSONObject jo = new JSONObject();
        Servicios servicios = new Servicios();

        Producto producto=(Producto)servicios.encontrar(id,Producto.class);
        if(producto.getStatus()==1)
            producto.setStatus(0);
        else
            producto.setStatus(1);
        servicios.actualizar(producto);

        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }

    @POST
    @Path("/EliminarProducto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response EliminarProducto(@QueryParam("id")int id) {

        JSONObject jo = new JSONObject();
        Servicios servicios = new Servicios();

        Producto producto=(Producto)servicios.encontrar(id,Producto.class);
        producto.setStatus(-1);
        servicios.actualizar(producto);

        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }

    @POST
    @Path("/TraerDatosArticulo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response TraerDatosArticulo(@QueryParam("id")int id) {

        JSONObject jo = new JSONObject();
        Servicios servicios = new Servicios();

        Producto producto = (Producto) servicios.encontrar(id, Producto.class);
        jo.put("Nombre", producto.getNombre());
        jo.put("Precio", producto.getPrecio());
        jo.put("Categoria", producto.getCategoriaByIdCategoria().getNombre());
        jo.put("Descripcion", producto.getNombre());
        if (producto.getCantidad() == 0){
            jo.put("Duracion", producto.getDuracion());

            JSONArray jaIngredientes=new JSONArray();
            List<IngredientesExtra>listIngredinetes=servicios.consultaHQLRetonarLista("FROM IngredientesExtra WHERE status=1 AND tiendaByIdTienda="+producto.getTiendaByIdTienda().getIdTienda());
            for(IngredientesExtra ingrediente:listIngredinetes){
                JSONObject joIngrediente=new JSONObject();
                joIngrediente.put("Nombre",ingrediente.getNombre());
                joIngrediente.put("Precio",ingrediente.getPrecio());
                if(servicios.buscarUnicoValor("FROM ProdIngre WHERE status=1 and ingredientesExtraByIdIngrediente="+ingrediente.getIdIngredietes()+" AND productoByIdProducto="+id)!=null){
                    joIngrediente.put("Agregado",true);
                }else{
                    joIngrediente.put("Agregado",false);
                }
                jaIngredientes.put(joIngrediente);
            }
            jo.put("Ingredientes",jaIngredientes);

        }else
            jo.put("Cantidad",producto.getCantidad());

        List<Categoria>listCategorias=servicios.consultaHQLRetonarLista("FROM Categoria WHERE tipoTienda='"+producto.getCategoriaByIdCategoria().getTipoTienda()+"'");
        JSONArray jaCategorias=new JSONArray();
        for(Categoria categoria:listCategorias){
            jaCategorias.put(categoria.getNombre());
        }
        jo.put("Categorias",jaCategorias);

        Configuracion configuracion=(Configuracion) servicios.buscarUnicoValor("FROM Configuracion WHERE status=1");
        jo.put("ComisionVentas",configuracion.getComisionVentaStore());
        jo.put("PrecioMinimo",configuracion.getPrecioMinimoTienda());
        jo.put("Imagen",producto.getImagen());




        servicios.CerrarConexion();
        return Response.ok(jo.toString()).build();
    }
}
