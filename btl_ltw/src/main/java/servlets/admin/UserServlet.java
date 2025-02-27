package servlets.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import models.UserLogin;
import repositories.impls.UserRepo;
import repositories.interfaces.IUserRepo;

@WebServlet({ "/admin/user", "/admin/user/" })
public class UserServlet extends BaseServlet {
    private IUserRepo userRepo;

    public UserServlet() {
        super();
        userRepo = new UserRepo();
    }

    private static final long serialVersionUID = 22;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        if (!ServletUtil.IsSessionExsited(req, resp)) {
            resp.sendRedirect("/btl_ltw/user/login");
            return;
        }

        List<User> listCategories;
        try {

            listCategories = userRepo.Gets("", "");
            req.setAttribute("listCategories", listCategories);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            req.setAttribute("pageName", "user.jsp");
            req.getRequestDispatcher("/user/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!ServletUtil.IsSessionExsited(req, resp)) {
            resp.sendRedirect("/btl_ltw/admin/login");
            return;
        }

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phonenum = req.getParameter("phonenum");
        String cccd = req.getParameter("cccd");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        UserLogin userLogin = new UserLogin();
        userLogin.set(null, username, password);
        try {
            int res = userRepo.Add(user);
            if (res == 2) {
                req.getSession().setAttribute("message", "Thêm mới thành công!");
                req.getSession().setAttribute("messageType", "success");
            } else {
                req.getSession().setAttribute("message", "Thêm mới không thành công!");
                req.getSession().setAttribute("messageType", "error");
            }
        } catch (SQLException e) {
            req.getSession().setAttribute("message", e.getMessage());
            req.getSession().setAttribute("messageType", "error");
        } finally {
            resp.sendRedirect("/btl_ltw/admin/user");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
