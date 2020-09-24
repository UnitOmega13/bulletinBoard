package factory;

import dao.PromoDAO;
import dao.impl.PromoDAOImpl;

public class PromoDAOFactory {

    private static PromoDAO instance;

    private PromoDAOFactory() {
    }

    public static synchronized PromoDAO getInstance() {
        if (instance == null) {
            instance = new PromoDAOImpl();
        }
        return instance;
    }
}
