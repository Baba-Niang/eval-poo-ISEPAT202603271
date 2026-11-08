public class Tournee {

    public static void trierFusion(Colis[] t) {
        if (t.length <= 1) {
            return;                         // déjà trié
        }
        int milieu = t.length / 2;
        Colis[] gauche = new Colis[milieu];
        Colis[] droite = new Colis[t.length - milieu];
        for (int i = 0; i < milieu; i++) gauche[i] = t[i];
        for (int i = milieu; i < t.length; i++) droite[i - milieu] = t[i];

        trierFusion(gauche);
        trierFusion(droite);

        int g = 0, d = 0, k = 0;
        while (g < gauche.length && d < droite.length) {
            if (gauche[g].compareTo(droite[d]) <= 0) {
                t[k++] = gauche[g++];
            } else {
                t[k++] = droite[d++];
            }
        }
        while (g < gauche.length) t[k++] = gauche[g++];
        while (d < droite.length) t[k++] = droite[d++];
    }

    public static Colis[] chargementOptimal(Colis[] t, int capacite) {
        int n = t.length;
        long[][] meilleur = new long[n + 1][capacite + 1];
        for (int i = 1; i <= n; i++) {
            int p = t[i - 1].getPoids();
            long v = t[i - 1].tarif();
            for (int cap = 0; cap <= capacite; cap++) {
                meilleur[i][cap] = meilleur[i - 1][cap];
                if (p <= cap && meilleur[i - 1][cap - p] + v > meilleur[i][cap]) {
                    meilleur[i][cap] = meilleur[i - 1][cap - p] + v;
                }
            }
        }
        // 1) compter les colis pris
        int nb = 0;
        int cap = capacite;
        for (int i = n; i >= 1; i--) {
            if (meilleur[i][cap] != meilleur[i - 1][cap]) {
                nb++;
                cap = cap - t[i - 1].getPoids();
            }
        }
        // 2) remplir un tableau de la taille exacte
        Colis[] choisis = new Colis[nb];
        cap = capacite;
        int k = 0;
        for (int i = n; i >= 1; i--) {
            if (meilleur[i][cap] != meilleur[i - 1][cap]) {
                choisis[k++] = t[i - 1];
                cap = cap - t[i - 1].getPoids();
            }
        }
        return choisis;
    }

    public static void main(String[] args) {
        Colis[] lot = {
            new ColisStandard("C01", 4, false),
            new ColisExpress("C02", 3, true),
            new ColisFragile("C03", 5, false, 120_000),
            new ColisStandard("C04", 7, true),
            new ColisExpress("C05", 2, false),
            new ColisFragile("C06", 6, true, 45_000),
            new ColisStandard("C07", 1, true),
            new ColisExpress("C08", 8, false),
            new ColisFragile("C09", 3, false, 300_000),
            new ColisStandard("C10", 5, false),
        };
        trierFusion(lot);
        for (int i = 0; i < lot.length; i++) {
            System.out.println(lot[i]);
        }
        Colis[] choix = chargementOptimal(lot, Parametres.CAPACITE);
        long recette = 0;
        for (int i = 0; i < choix.length; i++) {
            recette = recette + choix[i].tarif();
        }
        System.out.println("Recette optimale : " + recette
            + " FCFA (capacite " + Parametres.CAPACITE + " kg)");
    }
}