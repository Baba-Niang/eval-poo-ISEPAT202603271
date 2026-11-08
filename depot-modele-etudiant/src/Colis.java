public abstract class Colis implements Comparable<Colis> {
    private String code;
    private int poids;
    private boolean horsDakar;

    public Colis(String code, int poids, boolean horsDakar) {
        if (poids <= 0) {
            throw new IllegalArgumentException("poids invalide : " + poids);
        }
        this.code = code;
        this.poids = poids;
        this.horsDakar = horsDakar;
    }

    public String getCode() { return code; }
    public int getPoids() { return poids; }
    public boolean isHorsDakar() { return horsDakar; }

    public long tarif() {
        long t = poids * Parametres.TARIF_KG;
        if (horsDakar) {
            t = t + Parametres.SURCHARGE_HORS_DAKAR;
        }
        return t;
    }

    public abstract String sigle();
    public abstract int priorite();

    @Override
    public String toString() {
        String lieu = horsDakar ? "hors-Dakar" : "Dakar";
        return "[" + sigle() + "] " + code + " " + poids + "kg "
             + lieu + " " + tarif() + " FCFA";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colis autre = (Colis) o;
        return code.equals(autre.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public int compareTo(Colis autre) {
        if (priorite() != autre.priorite()) {
            return autre.priorite() - priorite();
        }
        if (tarif() != autre.tarif()) {
            return Long.compare(autre.tarif(), tarif());
        }
        return code.compareTo(autre.code);
    }
}