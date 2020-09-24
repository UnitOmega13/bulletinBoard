package servlet;

import config.SecurityConfig;
import dao.UserDAO;
import factory.UserDAOFactory;
import model.UserAccount;
import org.apache.commons.codec.digest.DigestUtils;
import storage.CurrentUser;
import utils.IdGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserDAO userDAO = UserDAOFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer id = IdGenerator.generateId();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
            req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
        } else {
            String encryptedPassword = DigestUtils.sha256Hex(password);
            UserAccount userAccount = new UserAccount(id, email, encryptedPassword, firstName, lastName,
                    SecurityConfig.USER_ROLE);
            userDAO.saveUser(userAccount);
            CurrentUser.setEmail(email);
            CurrentUser.setFirstName(firstName);
            CurrentUser.setLastName(lastName);
            CurrentUser.setId(id);
            CurrentUser.setPassword(password);
            CurrentUser.setExist(true);
            req.getRequestDispatcher("/WEB-INF/views/userInfoView.jsp").forward(req, resp);
        }
    }
}
