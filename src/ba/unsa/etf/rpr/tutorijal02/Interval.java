package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna, krajnja;
    private boolean pripadaPocetna, pripadaKrajnja;

    public double getPocetna() {
        return pocetna;
    }

    public void setPocetna(double pocetna) {
        this.pocetna = pocetna;
    }

    public double getKrajnja() {
        return krajnja;
    }

    public void setKrajnja(double krajnja) {
        this.krajnja = krajnja;
    }

    public boolean getPripadaPocetna() {
        return pripadaPocetna;
    }

    public void setPripadaPocetna(boolean pripadaPocetna) {
        this.pripadaPocetna = pripadaPocetna;
    }

    public boolean getPripadaKrajnja() {
        return pripadaKrajnja;
    }

    public void setPripadaKrajnja(boolean pripadaKrajnja) {
        this.pripadaKrajnja = pripadaKrajnja;
    }

    public Interval(double v, double v1, boolean b, boolean b1) {
        if(v>v1) throw new IllegalArgumentException();
        setPocetna(v);
        setKrajnja(v1);
        setPripadaPocetna(b);
        setPripadaKrajnja(b1);

    }

    public Interval() {
        setPocetna(0.0);
        setKrajnja(0.0);
        setPripadaPocetna(false);
        setPripadaKrajnja(false);
    }



    public boolean isIn(double v) {
        if(v>=this.pocetna && v<this.krajnja)
            return true;
        else
            return false;
    }

    public boolean isNull() {
        if(this.pocetna==0.0 && this.krajnja==0.0 && this.pripadaPocetna==false && this.pripadaKrajnja==false)
            return true;
        else
            return false;
    }

    public Interval intersect(Interval interval) {
        Interval nula=new Interval();
        Interval presjekNula=intersect(interval, nula);

        return presjekNula;
    }
    public static Interval intersect(Interval i, Interval i2) {
        if(i.getKrajnja() < i2.getPocetna()){
            Interval nula= new Interval();
            return nula;
        }

        else {
            Interval presjek = new Interval();
            if (i.getPocetna() < i2.getPocetna() && i2.getPripadaPocetna() == true) {
                presjek.setPocetna(i2.getPocetna());
                presjek.setPripadaPocetna(true);
            } else if (i.getPocetna() > i2.getPocetna() && i.getPripadaPocetna() == true) {
                presjek.setPocetna(i.getPocetna());
                presjek.setPripadaPocetna(true);
            } else if (i.getPocetna() > i2.getPocetna() && i.getPripadaPocetna() == false) {
                presjek.setPocetna(i.getPocetna());
                presjek.setPripadaPocetna(false);
            } else {
                presjek.setPocetna(i2.getPocetna());
                presjek.setPripadaPocetna(false);
            }

            if (i.getKrajnja() < i2.getPocetna() && i.getPripadaKrajnja() == true) {
                presjek.setKrajnja(i.getKrajnja());
                presjek.setPripadaKrajnja(true);
            } else if (i.getKrajnja() > i2.getKrajnja() && i2.getPripadaKrajnja() == true) {
                presjek.setKrajnja(i2.getKrajnja());
                presjek.setPripadaKrajnja(true);
            } else if (i.getPocetna() > i2.getPocetna() && i2.getPripadaPocetna() == false) {
                presjek.setKrajnja(i2.getKrajnja());
                presjek.setPripadaKrajnja(false);
            } else {
                presjek.setKrajnja(i.getKrajnja());
                presjek.setPripadaKrajnja(false);
            }

            return presjek;
        }
    }

}
