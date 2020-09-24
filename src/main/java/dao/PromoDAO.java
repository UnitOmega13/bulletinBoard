package dao;

import model.Promo;

import java.util.List;

public interface PromoDAO {

    void add(Promo promo);

    List<Promo> getAll();

    Promo get(int index);

}
