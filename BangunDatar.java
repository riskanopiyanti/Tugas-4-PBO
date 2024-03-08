// Parent class BangunDatar
public abstract class BangunDatar {
    public abstract double hitungLuas();
}

// Child class Segitiga
public abstract class Segitiga extends BangunDatar {
    protected double alas;
    protected double tinggi;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public double hitungSisiMiring() {
        return Math.sqrt(alas * alas + tinggi * tinggi);
    }

    public abstract double hitungLuas();
}

// Child class SegitigaSikuSiku
public class SegitigaSikuSiku extends Segitiga {
    public SegitigaSikuSiku(double alas, double tinggi) {
        super(alas, tinggi);
    }

    public double hitungLuas() {
        return 0.5 * alas * tinggi;
    }
}

// Child class SegitigaSamaKaki
public class SegitigaSamaKaki extends Segitiga {
    public SegitigaSamaKaki(double sisi1, double sisi2) {
        super(sisi1, sisi2);
        this.alas = sisi1;
        this.tinggi = sisi2;
    }

    public double hitungLuas() {
        return 0.5 * alas * tinggi;
    }
}

// Child class SegitigaSamaSisi
public class SegitigaSamaSisi extends Segitiga {
    public SegitigaSamaSisi(double sisi) {
        super(sisi, sisi);
    }

    public double hitungLuas() {
        return 0.5 * alas * tinggi;
    }
}

// Child class SegitigaSembarang
public class SegitigaSembarang extends Segitiga {
    public SegitigaSembarang(double sisi1, double sisi2, double sisi3) {
        super(sisi1, sisi2);
        double s4 = hitungSisiMiring();
        if (s4 == sisi3) {
            alas = sisi1;
            tinggi = sisi2;
        } else {
            throw new IllegalArgumentException("Segitiga sembarang dengan sisi " + sisi1 + ", " + sisi2 + " dan " + sisi3 + " tidak valid.");
        }
    }

    public double hitungLuas() {
        double s1 = alas;
        double s2 = tinggi;
        double s3 = hitungSisiMiring();
        double s = (s1 + s2 + s3) / 2;
        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }
}

// Child class Persegi
public class Persegi extends BangunDatar {
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    public double hitungLuas() {
        return sisi * sisi;
    }
}

// Child class Lingkaran
public class Lingkaran extends BangunDatar {
    private double jariJari;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    public double hitungLuas() {
        final double pi = 3.14159;
        return pi * jariJari * jariJari;
    }
}
