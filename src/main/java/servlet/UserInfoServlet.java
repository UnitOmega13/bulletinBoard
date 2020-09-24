package servlet;

import config.SecurityConfig;
import dao.UserDAO;
import dao.impl.UserDAOImpl;
import model.UserAccount;
import storage.CurrentUser;
import storage.DataBase;
import utils.AppUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAO userDao = new UserDAOImpl();

    public UserInfoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String email = request.getParameter("email");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        UserAccount user = new UserAccount(CurrentUser.getId(), CurrentUser.getEmail(), CurrentUser.getPassword(),
                CurrentUser.getFirstName(), CurrentUser.getLastName(), SecurityConfig.USER_ROLE);
        UserAccount newUser = new UserAccount(CurrentUser.getId(), email, password, firstName, lastName, SecurityConfig.USER_ROLE);
        userDao.updateUser(user, newUser);
        CurrentUser.setEmail(email);
        CurrentUser.setFirstName(firstName);
        CurrentUser.setLastName(lastName);
        CurrentUser.setId(user.getId());
        CurrentUser.setPassword(password);
        response.sendRedirect("/userInfo");
    }
}
