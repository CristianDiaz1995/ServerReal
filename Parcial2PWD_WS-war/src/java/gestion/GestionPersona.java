/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import control.Conexion;
import control.NextId;
import dao.PersonaDao;
import java.sql.Connection;
import java.util.List;
import modelo.Persona;

/**
 *
 * @author WAlvarezV
 */
public class GestionPersona {

    Conexion conexion;
    Connection conn;
    NextId nextID;

    public GestionPersona() {
        conexion = new Conexion();
        nextID = new NextId();
    }

    // <editor-fold defaultstate="collapsed" desc="Métodos Gestión Persona">
    public Persona crearPersona(Persona obj) {
        try {
            conn = conexion.conectar();
            PersonaDao objDao = new PersonaDao();
            obj.setID_PERSONA(nextID.next(conn, "PERSONA"));
            objDao.create(conn, obj);
            return objDao.getObject(conn, obj.getID_PERSONA());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return null;
    }

    public String editarPersona(Persona obj) {
        String msj = "OK";
        try {
            conn = conexion.conectar();
            PersonaDao objDao = new PersonaDao();
            objDao.save(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
            msj = "ERROR editarPersona: " + e.getMessage();
        } finally {
            conexion.cerrarConexion();
        }
        return msj;
    }

    public Persona buscarPersona(Persona obj) {
        try {
            conn = conexion.conectar();
            PersonaDao objDao = new PersonaDao();
            return (Persona) objDao.searchMatching(conn, obj).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return null;
    }

    public boolean eliminarPersona(Persona obj) {
        try {
            conn = conexion.conectar();
            PersonaDao objDao = new PersonaDao();
            objDao.delete(conn, obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public List listarPersona() {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            PersonaDao objDao = new PersonaDao();
            mylista = objDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return mylista;
    }
    // </editor-fold>

}
