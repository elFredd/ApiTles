package controlador.servicios;

import controlador.core.AES.DesEncripAES;
import controlador.core.AES.EncripAES;
import modelo.dao.DAO;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.LocalDate.now;


public class Servicios {
    public DAO objDAO;

    public Servicios()
    {
        objDAO  = new DAO();
    }

    public List listar(String nombreTabla)
    {
        return objDAO.listar(nombreTabla);
    }

    public void CerrarConexion(){
        objDAO.CerrarConexion();
    }


    public Object insertar(Object object){
        try {
            //insertar
            objDAO.insertar(object);
            return object;
        }
        catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    public Object buscarUnicoValor(String consulta){
        List verificar= consultaHQLRetonarLista(consulta);
        if(verificar!=null&&verificar.size()>0)
            return verificar.toArray()[0];
        else return null;
    }

    public Object buscarEnCombo(String encontrar,String columna,Class tablaTipo) {
        List verificar= consultaHQLRetonarLista("FROM "+tablaTipo.getName()+" where "+columna+" = '"+encontrar+"'");
        if(verificar!=null&&verificar.size()>0)
            return verificar.toArray()[0];
        else return null;
    }

    public boolean actualizar(Object object){
        try {
            objDAO.actualizar(object);
            return  true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void eliminar(Object objectEliminar){
        objDAO.eliminar(objectEliminar);
    }

    public Object encontrar(Integer idEncontrar,Class ClaseTipo){
        return  objDAO.buscar(idEncontrar,ClaseTipo);
    }

    public Object consultaHQLRetonarValorUnico(String cadenaConsulta) {
        return objDAO.ConsultaHQLRetonaValorUnico(cadenaConsulta);
    }
    public List consultaHQLRetonarLista(String cadenaConsulta){
        return objDAO.consultaHQLRetonarLista(cadenaConsulta);

    }
    public List consultaHQLRetonarListaCantidadEspecifica(String cadenaConsulta,int cantidad){
        return objDAO.consultaHQLRetonarListaCantidadEspecifica(cadenaConsulta,cantidad);

    }
    public Object consultaHQLRetonarValorUnicoParametros(String cadenaConsulta,String... parametros) {
        return objDAO.consultaHQLRetonaValorUnicoParametros(cadenaConsulta,parametros);
    }

    public List consultaHQLRetonarListaParametros(String cadenaConsulta,String... Parametros){
        return objDAO.consultaHQLRetonarListaParametros(cadenaConsulta,Parametros);
    }

    public String getFecha(Timestamp fecha, boolean hora){

        LocalDateTime localDateTime=fecha.toLocalDateTime();
        int dmy=localDateTime.getMonthValue();

        String retorno=getMes(dmy);

        String minutos, horas;
        if (localDateTime.getMinute()<10) minutos="0"+localDateTime.getMinute();
        else minutos=""+localDateTime.getMinute();

        if (localDateTime.getHour()<10) horas="0"+localDateTime.getHour();
        else horas=""+localDateTime.getHour();

        if(hora)
            return localDateTime.getDayOfMonth()+" de "+retorno+" de "+localDateTime.getYear()+" - "+horas+":"+minutos;
        else
            return localDateTime.getDayOfMonth()+" de "+retorno+" de "+localDateTime.getYear();
    }




    public String getCodigoRandom(int longitud){
        Random r = new Random();
        String cadena="";
        for (int i = 0; i <longitud ; i++) {
            cadena+=r.nextInt(9);
        }
        return cadena;
    }

    public boolean isCorreo(String email){
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    public boolean isNumero(String telefono){
        return telefono.matches("^[0-9]{10}$");
    }

    public String getMes(int i){
        String mes="";
        switch (i){
            case 1: mes="Enero";break;
            case 2: mes="Febrero";break;
            case 3: mes="Marzo";break;
            case 4: mes="Abril";break;
            case 5: mes="Mayo";break;
            case 6: mes="Junio";break;
            case 7: mes="Julio";break;
            case 8: mes="Agosto";break;
            case 9: mes="Septiembre";break;
            case 10: mes="Octubre";break;
            case 11: mes="Noviembre";break;
            case 12: mes="Diciembre";break;
        }
        return mes;
    }

    public String getHora(Time time){
        LocalTime localTime=time.toLocalTime();
        int hora=localTime.getHour();
        int minutos=localTime.getMinute();
        String PMAM="AM";

        if(hora>12){
            PMAM="PM";
            hora=localTime.getHour()-12;
        }else if (hora==0){
            hora=12;
        }

        String horaReturn=hora+"";

        if(hora<10){
            horaReturn="0"+hora;
        }

        String minutosReturn=minutos+"";
        if(minutos<10){
            minutosReturn="0"+minutos;
        }

        return horaReturn+":"+minutosReturn+" "+PMAM;

    }



    public String getTiempo(double minutos) {
        if(minutos>=60){
            double horas=minutos/60;
            if(horas>=24){
                double dias=horas/24;
                return (int)dias+" dias";
            }else {
                return (int)horas+" horas";
            }
        }else {
            return (int)minutos+" minutos";
        }
    }



}

