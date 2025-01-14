package com.rabex.express.controllers.user;
import com.rabex.express.core.dao.RID;
import com.rabex.express.model.User;
import com.rabex.express.services.UserInfoService;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/nguoi-dung/thong-tin-nguoi-dung")
public class UserInfoController extends HttpServlet {
    @Inject
    UserInfoService userInfoService;
    RID userId = RID.from("01HZY0M93WZXABCDEF12345715");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userInfoService.findById(userId);
        if (userInfoService != null){
            req.setAttribute("user", user);
        }
        System.out.println(user);
        req.getRequestDispatcher("/WEB-INF/views/user/user-info.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
}
