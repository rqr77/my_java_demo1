import dao.UserData;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser= new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
        UserData ud=new UserData();
        User datauser =ud.login(loginuser);
        System.out.println(loginuser.getUsername());
        System.out.println(loginuser.getPassword());
        System.out.println(password);
        System.out.println(datauser);
        if (datauser==null){
            request.getRequestDispatcher("/FailServlet").forward(request,response);
        }else {
            //存储数据
            request.setAttribute("user",datauser);
            request.getRequestDispatcher("/MySuccessServlet").forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
