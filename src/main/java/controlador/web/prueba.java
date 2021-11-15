package controlador.web;

import controlador.core.AES.EncripAES;
import controlador.servicios.Servicios;
import modelo.db.Estado;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Acciones/Prueba")
public class prueba extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print("Hola mundo");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        Estado estado=new Estado();
        estado.setNombre("Colima");
        Servicios servicios=new Servicios();
        servicios.insertar(estado);
        servicios.CerrarConexion();
        response.getWriter().print("Hola mundo");
    }
}
