package dao.impl;

import dao.PromoDAO;
import model.Promo;
import storage.DataBase;

import java.util.List;

public class PromoDAOImpl implements PromoDAO {

    @Override
    public void add(Promo promo) {
        DataBase.promos.add(promo);
    }

    @Override
    public List getAll() {
        return DataBase.promos;
    }

    @Override
    public Promo get(int index) {
        return DataBase.promos.get(index);
    }
}
