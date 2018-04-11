/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author usuario
 */
public class ConexionBD {

    private String URLAccess = "jdbc:mysql:thin:@localhost:3306:XE";
    private String usuario ="root";
    private String clave="sist25";
    private Connection conexion;

    public String getURLAccess() {
        return URLAccess;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setURLAccess(String URLAccess) {
        this.URLAccess = URLAccess;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "ConexionBd{" + "URLAccess=" + URLAccess + ", usuario=" + usuario + ", clave=" + clave + '}';
    } 
    
    public void setConexionSql(String URLAccess, String usuario, String clave){
        try {
            setURLAccess(URLAccess);
            setUsuario(usuario);
            setClave(clave);
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(URLAccess, usuario, clave);
            System.out.println("conexion exitosa.url"+ URLAccess + "usuario" + usuario);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error!" + ex.toString());
        }
    }
   
    public void closeConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error!" + ex.toString());
        }
    }
    
    public void senteciasNoSlect(String sentencia){
        try {
            Statement st=conexion.createStatement();
            st.executeUpdate(sentencia);
            conexion.commit();
        } catch (SQLException ex) {
            System.out.println("Error!" + ex.toString());
        }
    }
    
    public void getDatosConsulta(String consulta){
        try {
            int i =0;
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                i++;
                for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {
                    System.out.println(rs.getObject(j)+"\t");
                    
                    
                    System.out.println("");
                }
             
                
            }
            
        } catch (Exception ex) {
            System.out.println("    error"+ ex.toString());
        }
    }
    
    
    public void getMetaDataTable(String consulta) {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("---numero de campos" + 
                    rs.getMetaData().getColumnCount());
            int i = 1;
            while (i <= rsmd.getColumnCount()) {                
                System.out.println("campo: " + rs.getMetaData().getColumnTypeName(i));
                i++;
            }
            
        } catch (SQLException ex) {
            System.out.println("   error"+ ex.toString());
        }
    }
 
      
}

