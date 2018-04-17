/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import gestion.GestionPersona;
import gestion.GestionUsuario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Persona;
import modelo.Usuario;
/**
 *
 * @author Unicomfacauca
 */
@WebService(serviceName = "WSParcial2")
public class WSParcial2 {

    GestionPersona gestionPersona;
    GestionUsuario gestionUsuario;
    public WSParcial2() {
        super();
        gestionPersona = new GestionPersona();
        gestionUsuario = new GestionUsuario();
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="Métodos Servicio Test">
    @WebMethod(operationName = "crearPersona")
    public Persona crearPersona(@WebParam(name = "Persona") Persona obj) {
        return gestionPersona.crearPersona(obj);
    }

    @WebMethod(operationName = "editarPersona")
    public String editarPersona(@WebParam(name = "Persona") Persona obj) {
        return gestionPersona.editarPersona(obj);
    }

    @WebMethod(operationName = "buscarPersona")
    public Persona buscarPersona(@WebParam(name = "Persona") Persona obj) {
        return gestionPersona.buscarPersona(obj);
    }

    @WebMethod(operationName = "eliminarPersona")
    public boolean eliminarPersona(@WebParam(name = "Persona") Persona obj) {
        return gestionPersona.eliminarPersona(obj);
    }

    @WebMethod(operationName = "listarPersona")
    public List listarPersona() {
        return gestionPersona.listarPersona();
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Métodos Servicio Test">
    @WebMethod(operationName = "crearUsuario")
    public Usuario crearUsuario(@WebParam(name = "Usuario") Usuario obj) {
        return gestionUsuario.crearUsuario(obj);
    }

    @WebMethod(operationName = "editarUsuario")
    public String editarUsuario(@WebParam(name = "Usuario") Usuario obj) {
        return gestionUsuario.editarUsuario(obj);
    }

    @WebMethod(operationName = "buscarUsuario")
    public Usuario buscarUsuario(@WebParam(name = "Usuario") Usuario obj) {
        return gestionUsuario.buscarUsuario(obj);
    }

    @WebMethod(operationName = "eliminarUsuario")
    public boolean eliminarUsuario(@WebParam(name = "Usuario") Usuario obj) {
        return gestionUsuario.eliminarUsuario(obj);
    }

    @WebMethod(operationName = "listarUsuario")
    public List listarUsuario() {
        return gestionUsuario.listarUsuario();
    }
    // </editor-fold>
}
