public class Inventaire {
    public static long valeurAssuree(Object[] objets) {
        long somme = 0;
        for (int i = 0; i < objets.length; i++) {
            if (objets[i] instanceof ColisFragile) {
                ColisFragile f = (ColisFragile) objets[i];
                somme = somme + f.getValeurDeclaree();
            }
        }
        return somme;
    }

    public static int[] compterParType(Object[] objets) {
        int[] c = new int[4];          // {standard, express, fragile, autres}
        for (int i = 0; i < objets.length; i++) {
            Object o = objets[i];
            if (o == null) {
                continue;               // on ignore les null
            } else if (o instanceof ColisFragile) {
                c[2]++;                 // tester AVANT ColisStandard !
            } else if (o instanceof ColisStandard) {
                c[0]++;
            } else if (o instanceof ColisExpress) {
                c[1]++;
            } else {
                c[3]++;
            }
        }
        return c;
    }
}
