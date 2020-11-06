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

        return v>=this.pocetna && v<this.krajnja;
    }

    public boolean isNull() {
        return this.pocetna==0.0 && this.krajnja==0.0 && !this.pripadaPocetna && !this.pripadaKrajnja;
    }

    public Interval intersect(Interval interval) {

        return intersect(this,interval);
    }
    public static Interval intersect(Interval i, Interval i2) {
        if(i.getKrajnja() < i2.getPocetna()){
            return new Interval();
        }

        else {
            Interval presjek = new Interval();
            if (i.getPocetna() < i2.getPocetna() && i2.getPripadaPocetna()) {
                presjek.setPocetna(i2.getPocetna());
                presjek.setPripadaPocetna(true);
            } else if (i.getPocetna() > i2.getPocetna() && i.getPripadaPocetna()) {
                presjek.setPocetna(i.getPocetna());
                presjek.setPripadaPocetna(true);
            } else if (i.getPocetna() > i2.getPocetna() && !i.getPripadaPocetna()) {
                presjek.setPocetna(i.getPocetna());
                presjek.setPripadaPocetna(false);
            } else {
                presjek.setPocetna(i2.getPocetna());
                presjek.setPripadaPocetna(false);
            }

            if (i.getKrajnja() < i2.getPocetna() && i.getPripadaKrajnja()) {
                presjek.setKrajnja(i.getKrajnja());
                presjek.setPripadaKrajnja(true);
            } else if (i.getKrajnja() > i2.getKrajnja() && i2.getPripadaKrajnja()) {
                presjek.setKrajnja(i2.getKrajnja());
                presjek.setPripadaKrajnja(true);
            } else if (i.getPocetna() > i2.getPocetna() && i2.getPripadaPocetna()) {
                presjek.setKrajnja(i2.getKrajnja());
                presjek.setPripadaKrajnja(false);
            } else {
                presjek.setKrajnja(i.getKrajnja());
                presjek.setPripadaKrajnja(false);
            }

            return presjek;
        }
    }

    @Override
    public String toString() {
        if(getPocetna()==0 && getKrajnja()==0)
            return "()";

        if(getPripadaPocetna() && !getPripadaKrajnja())
            return "[" + pocetna + "," + krajnja + ")";
        else if(getPripadaPocetna() && getPripadaKrajnja())
            return "[" + pocetna + "," + krajnja + "]";
        else if (!getPripadaPocetna() && getPripadaKrajnja())
            return "("+pocetna + "," + krajnja+"]";
        else
            return "(" + pocetna + "," + krajnja+")";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Interval))
            return false;

        return this.getPocetna()==((Interval) obj).getPocetna() && this.getKrajnja()==((Interval) obj).getKrajnja() && this.getPripadaPocetna()==((Interval) obj).getPripadaPocetna() && this.getPripadaKrajnja()==((Interval) obj).getPripadaKrajnja();

    }
}
