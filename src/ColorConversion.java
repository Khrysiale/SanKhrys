
/**
 * Classe permettant d'effectuer la conversion de l'espace couleur RGB vers HSV,
 * Les valeurs HSV sont representees par un tableau float {h, s, v} avec la
 * teinte en degres et la saturation et la valeur entre 0.f et 1.f.
 
 */

public class ColorConversion {
    /**
     * Conversion RGB vers HSV
     * 
     * @param rgb
     *            couleur RGB
     * @return triplet HSV
     */
    public static float[] RGB2HSV(int rgb) {
        int r = (rgb & 0xff0000) >> 16;
        int g = (rgb & 0xff00) >> 8;
        int b = (rgb & 0xff);

        float h;
        float s;
        float v;

        int max = Math.max(r, Math.max(g, b));
        int min = Math.min(r, Math.min(g, b));

        if (max == min) {
            h = 0.f;
        } else {
            float t;
            int d;
            if (max == r) {
                t = (g - b) / (float) (max - min);
                d = 360;
            } else if (max == g) {
                t = (b - r) / (float) (max - min);
                d = 120;
            } else {
                t = (r - g) / (float) (max - min);
                d = 240;
            }
            h = 60 * t + d;
            if (h > 360)
                h -= 360;
        }

        if (max == 0 || max == min)
            s = 0.f;
        else {
            s = 1.f - min / (float) max;
        }

        v = max / 255.f;

        return new float[] { h, s, v };
    }
}
