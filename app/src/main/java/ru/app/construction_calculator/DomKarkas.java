package ru.app.construction_calculator;

public class DomKarkas {
    private double l;//Длинна дома
    private double b;//Ширина дома
    private double xSvai;//Кол-во свай по длинне
    private double ySvai;//Кол-во свай по ширине
    private double x, y;//Шаг свай по длинне и ширине
    private double lBrus;//Брус штук по длинне
    private double bBrus;//Брус штук по ширине
    private double nBrus;//Кол-во стоек первого этажа
    private double sBrus;//Кол-во стропил
    private double h;//Высота мансарды под конёк
    private double sKrov;//Площадь кровли
    private String st1,st2;
    private double vTeplo;

    public DomKarkas(double l, double b, double lBrus, double bBrus, String st1, double xSvai, double ySvai) {
        this.l= l;
        this.b= b;
        this.lBrus = lBrus;
        this.bBrus = bBrus;
        this.st1 = st1;
        this.xSvai = xSvai;
        this.ySvai = ySvai;

    }



    public DomKarkas(double l, double b, double xSvai, double ySvai, double x, double y) {
        this.l = l;
        this.b = b;
        this.xSvai = xSvai;
        this.ySvai = ySvai;
        this.x = x;
        this.y = y;
    }



    public DomKarkas(double l, double b, double h, double sBrus, double lBrus) {
        this.l = l;
        this.b = b;
        this.h = h;
        this.sBrus = sBrus;
        this.lBrus = lBrus;
    }

    public DomKarkas(double l, double b,  double h, double sKrov) {
        this.l = l;
        this.b = b;
        this.h = h;
        this.sKrov = sKrov;
    }

    public DomKarkas(double l, double b,double vTeplo, String st1, String st2) {
        this.l = l;
        this.b = b;
        this.vTeplo = vTeplo;
        this.st1 = st1;
        this.st2 = st2;
    }


    public DomKarkas(double lBrus,double bBrus) {
        this.lBrus = lBrus;
        this.bBrus = bBrus;
    }

    public double getsKrov() {
        return sKrov;
    }

    public String getSt1() {
        return st1;
    }

    public double getvTeplo() {
        return vTeplo;
    }

    public String getSt2() {
        return st2;
    }

    public double getH() {
        return h;
    }

    public DomKarkas(double nBrus) {
        this.nBrus = nBrus;
    }

    public void setsBrus(double sBrus) {
        this.sBrus = sBrus;
    }

    public double getsBrus() {
        return sBrus;
    }

    public double getnBrus() {
        return nBrus;
    }

    public void setnBrus(double nBrus) {
        this.nBrus = nBrus;
    }

    public void setxSvai(double xSvai) {
        this.xSvai = xSvai;
    }

    public void setySvai(double ySvai) {
        this.ySvai = ySvai;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getL() {
        return l;
    }

    public double getB() {
        return b;
    }

    public double getxSvai() {
        return xSvai;
    }

    public double getySvai() {
        return ySvai;
    }

    public double getY() {
        return y;
    }

    public double getlBrus() {
        return lBrus;
    }

    public double getbBrus() {
        return bBrus;
    }

    public void setlBrus(double lBrus) {
        this.lBrus = lBrus;
    }

    public void setbBrus(double bBrus) {
        this.bBrus = bBrus;
    }

    public void setX() {
        this.x = x;
    }

    public double getX() {
        return x;
    }


}
