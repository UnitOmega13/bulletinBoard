package model;

import lombok.Getter;
import lombok.Setter;

public class Promo {

    @Getter
    @Setter
    private Integer promoId;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String imageData;

    @Getter
    @Setter
    private String promoInfo;

    @Getter
    @Setter
    private String lastName;

    public Promo(int promoId, String title, String imageData, String promoInfo, String lastName) {
        this.promoId = promoId;
        this.title = title;
        this.imageData = imageData;
        this.promoInfo = promoInfo;
        this.lastName = lastName;
    }
}
