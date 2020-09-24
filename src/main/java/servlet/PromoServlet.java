package servlet;

import dao.PromoDAO;
import factory.PromoDAOFactory;
import model.Promo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@WebServlet({"/userPromo"})
public class PromoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final PromoDAO promoDAO = PromoDAOFactory.getInstance();

    public PromoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 10;
        List<Promo> list = new ArrayList<>();
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
            list = new ArrayList<>(promoDAO.getAll());
        int noOfRecords = promoDAO.getAll().size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("promoList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/userPromo.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/userPromo");
    }
}
