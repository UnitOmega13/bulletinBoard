package servlet;

import dao.PromoDAO;
import factory.PromoDAOFactory;
import model.Promo;
import org.apache.commons.compress.utils.IOUtils;
import storage.CurrentUser;
import storage.DataBase;
import utils.IdGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet("/addPromo")
public class AddPromo extends HttpServlet {
    private static final String SAVE_DIR = "images";
    private static final PromoDAO promoDAO = PromoDAOFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/addPromo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = IdGenerator.generateId();
        String title = req.getParameter("title");
        String base64 = "";
        try{
            Part filePart = req.getPart("file");
            InputStream iSteamReader = filePart.getInputStream();
            byte[] imageBytes = IOUtils.toByteArray(iSteamReader);
            base64 = Base64.getEncoder().encodeToString(imageBytes);
        }catch(Exception e){
            e.printStackTrace();
        }
        String imageData = "data:image/png;base64," + base64;
        String lastName = req.getParameter("lastName");
        String promoInfo = req.getParameter("promoInfo");
        if (title.isEmpty() || promoInfo.isEmpty()) {
            req.setAttribute("error", "Empty fields!");
            req.getRequestDispatcher("/WEB-INF/views/addPromo.jsp").forward(req, resp);
        } else {
            promoDAO.add(new Promo(id, title, imageData, promoInfo, lastName));
            req.getRequestDispatcher("/WEB-INF/views/addPromo.jsp").forward(req, resp);
        }
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "new";
    }
}
