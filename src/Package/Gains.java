package Package;

import java.lang.reflect.Array;

public class Gains {

    public static int salaireMoyen(Collaborateurs[] arrayCol){
        int res = 0;
        for (Collaborateurs col: arrayCol) {
            res += col.salaire;
        }
        return res / arrayCol.length;
    }


}
