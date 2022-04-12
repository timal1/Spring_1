package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "JdbcServlet", urlPatterns = "/jdbc_servlet")
public class UserServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(UserServlet.class);
    private Connection conn;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        conn = (Connection) context.getAttribute("jdbcConnection");
        if (conn == null) {
            throw new ServletException("No JDBC connection in Servlet Context");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException {

        logger.info("Get all products");
        resp.setContentType("text/html;charset=UTF-8");

        try {
            Statement stmt = conn.createStatement();

            for (int i = 7; i < 17; i++) {

                String request = "SELECT id, product_name, cost FROM cart_product WHERE id = " + i;
                ResultSet rs = stmt.executeQuery(request);

                while (rs.next()) {
                    String number = rs.getString(1);
                    String productName = rs.getString(2);
                    String cost = rs.getString(3);
                    resp.getWriter().println("<h3> " + String.format("№: %s товар: %s цена: %s руб.",
                            number, productName, cost) + "</h3>");
                }
            }
            resp.getWriter().close();

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
