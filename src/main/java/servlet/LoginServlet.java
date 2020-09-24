package servlet;

import dao.UserDAO;
import factory.UserDAOFactory;
import model.UserAccount;
import storage.CurrentUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAO userDAO = UserDAOFactory.getInstance();

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            authenticate(request, response);
            response.sendRedirect("/userInfo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (userDAO.validate(email, password)) {
            UserAccount userAccount = userDAO.getUserByEmail(email);
            CurrentUser.setEmail(userAccount.getEmail());
            CurrentUser.setFirstName(userAccount.getFirstName());
            CurrentUser.setLastName(userAccount.getLastName());
            CurrentUser.setId(userAccount.getId());
            CurrentUser.setPassword(userAccount.getPassword());
            CurrentUser.setExist(true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("success");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }
}
