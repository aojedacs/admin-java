/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.aojedacs.userpanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aojedacs
 */
public class UserPanel {
    
    static final String URL = "jdbc:mysql://localhost:3306/test_library";
    static final String USER = "root";
    static final String PASSWORD = "Cupcake12345$";


    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stmt = null;
        
         try {
            // Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Declaration
            stmt = conn.createStatement();

            // CRUD
            // CREATE
            /*String insertQuery = "INSERT INTO tabla (columna1, columna2) VALUES ('valor1', 'valor2')";
            stmt.executeUpdate(insertQuery);
*/
            // READ
            String selectQuery = "SELECT * FROM books";
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                // Procesar los resultados
                String isbn = rs.getString("ISBN");
                String title = rs.getString("title");
                String author = rs.getString("author");
                System.out.println("ISBN: " + isbn + ", title: " + title + ", author: " + author);
            }

         /*   // UPDATE
            String updateQuery = "UPDATE tabla SET columna1 = 'nuevo_valor' WHERE id = 1";
            stmt.executeUpdate(updateQuery);

            // DELETE
            String deleteQuery = "DELETE FROM tabla WHERE id = 1";
            stmt.executeUpdate(deleteQuery);*/

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Paso 4: Cerrar la conexión y los recursos
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Hello World!");
    }
}
