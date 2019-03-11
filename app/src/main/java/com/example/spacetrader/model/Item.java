package com.example.spacetrader.model;

public class Item {
    private String name;
    private int MTLP;
    private int MTLU;
    private int TTP;
    private int basePrice;
    private int IPL;
    private int variance;
    private String IE;
    private String CR;
    private String ER;
    private int MTL;
    private int MTH;

    public Item (String name, int MTLP, int MTLU, int TTP, int basePrice, int IPL,
                 int variance, String IE, String CR, String ER, int MTL, int MTH) {
        this.name = name;
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.TTP = TTP;
        this.basePrice = basePrice;
        this.IPL = IPL;
        this.variance = variance;
        this.IE = IE;
        this.CR = CR;
        this.ER = ER;
        this.MTL = MTL;
        this.MTH = MTH;
    }

    public double calculatePrice() {
        if (Math.random() >= 0.5) {
            return basePrice + IPL*(TTP - MTLP) + Math.random() * (variance * 0.1 + 1);
        }
        return basePrice + IPL*(TTP - MTLP) - Math.random() * (variance * 0.1 + 1);
    }

    public String getName() {
        return name;
    }
}
