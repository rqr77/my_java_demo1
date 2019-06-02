import domain.User;

import java.io.IOException;
import java.io.PrintWriter;


@javax.servlet.annotation.WebServlet("/MySuccessServlet")
public class MySuccessServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User loginuser= (User) request.getAttribute("user");
        PrintWriter pw = response.getWriter();
        System.out.println(loginuser.getUsername());
        pw.write("<h1>welcome! "+loginuser.getUsername()+"</h1>");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
