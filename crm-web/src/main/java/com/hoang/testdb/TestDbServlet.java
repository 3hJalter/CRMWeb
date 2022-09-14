package com.hoang.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        // setup connection variables
        String user = "springStudent";
        String password = "springStudent";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker";
        String driver = "com.mysql.jdbc.Driver";

        // get connection to database
        try {
            PrintWriter out = resp.getWriter();
            out.println("Connection to database: " + jdbcUrl);
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            out.println("Connection successful");
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
