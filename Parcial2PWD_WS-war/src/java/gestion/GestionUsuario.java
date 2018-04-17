/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import control.Conexion;
import control.NextId;
import dao.UsuarioDao;
import java.sql.Connection;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author WAlvarezV
 */
public class GestionUsuario {

    Conexion conexion;
    Connection conn;
    NextId nextID;

    public GestionUsuario() {
        conexion = new Conexion();
        nextID = new NextId();
    }

    // <editor-fold defaultstate="collapsed" desc="Métodos Gestión Usuario">
    public Usuario crearUsuario(Usuario obj) {
        try {
            conn = conexion.conectar();
            UsuarioDao objDao = new UsuarioDao();
            obj.setID_USUARIO(nextID.next(conn, "USUARIO"));
            objDao.create(conn, obj);
            return objDao.getObject(conn, obj.getID_USUARIO());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return null;
    }

    public String editarUsuario(Usuario obj) {
        String msj = "OK";
        try {
            conn = conexion.conectar();
            UsuarioDao objDao = new UsuarioDao();
            objDao.save(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
            msj = "ERROR editarUsuario: " + e.getMessage();
        } finally {
            conexion.cerrarConexion();
        }
        return msj;
    }

    public Usuario buscarUsuario(Usuario obj) {
        try {
            conn = conexion.conectar();
            UsuarioDao objDao = new UsuarioDao();
            return (Usuario) objDao.searchMatching(conn, obj).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return null;
    }

    public boolean eliminarUsuario(Usuario obj) {
        try {
            conn = conexion.conectar();
            UsuarioDao objDao = new UsuarioDao();
            objDao.delete(conn, obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public List listarUsuario() {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            UsuarioDao objDao = new UsuarioDao();
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
