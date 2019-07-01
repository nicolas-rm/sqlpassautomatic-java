/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Sesion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author NICOLAS RM
 */
public class SesionDao {

    Conexion conexion = new Conexion();

    public boolean AgregarPass(Sesion session) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call ENCRIPT(?,?,?)}");
            cstm.setString(1, session.getUser());

            cstm.setString(2, DigestUtils.sha512Hex(session.getPass()));

            cstm.setString(3, session.getStatus());

            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }

    public boolean UpdateSessionActivo(Sesion per) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateSessionActivo(?,?,?)}");
            cstm.setString(1, per.getUser());
            cstm.setString(2, per.getPass());
            cstm.setString(3, per.getStatus());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }

    public boolean UpdateSessionInactivo(Sesion per) {
        Connection con = null;
        CallableStatement cstm = null;
        boolean resp = true;
        try {
            con = conexion.getConecion();
            con.setAutoCommit(false);
            cstm = con.prepareCall("{Call UpdateSessionInactivo(?,?,?)}");
            cstm.setString(1, per.getUser());
            cstm.setString(2, per.getPass());
            cstm.setString(3, per.getStatus());
            resp = cstm.execute();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.Cerrar1(con, cstm);
        }
        return resp;
    }
    
//    public boolean DeletePersona(Sesion per) {
//        Connection con = null;
//        CallableStatement cstm = null;
//        boolean resp = true;
//        try {
//            con = conexion.getConecion();
//            con.setAutoCommit(false);
//            cstm = con.prepareCall("{Call DeletePersona(?)}");
//            cstm.setInt(1, per.getIdpers());
//            resp = cstm.execute();
//            con.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            conexion.Cerrar1(con, cstm);
//        }
//        return resp;
//    }

    public List<Sesion> listado() {
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Sesion> lista = null;
        try {
            lista = new ArrayList<>();
            con = conexion.getConecion();
            cstm = con.prepareCall("{Call Listar}");
            rs = cstm.executeQuery();
            Sesion session = null;
            while (rs.next()) {
                session = new Sesion();
                session.setUser(rs.getString("USUARIO"));
                session.setPass(rs.getString("PASS"));
                session.setStatus(rs.getString("ESTATUS"));
                lista.add(session);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.Cerrar2(cstm, rs);
        }
        return lista;
    }
}
