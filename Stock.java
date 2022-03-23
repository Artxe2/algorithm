import java.text.DecimalFormat;

public class Stock {
    static final double COMM = 0.0025;
    public static void maina(String[] args) {
        long target = 107000;
        long a = 56000000;
        long aa = a / target; // 523
        long b = a * 100 / 45 / 10000 * 10000;
        long bb = b / target; // 1162
        long low = 105300;
        long high = 107300;
        int counterTrade = counterTrade(a, b, target, low);

        System.out.println("start( " + target + " ): "
                + num((aa + bb) * target * -COMM));

        System.out.println("counterTrade: " + num(counterTrade));

        double realizedPNL = counterTrade * (low - target - grt(low));

        System.out.println("realizedPNL( " + low + " ): " + num(realizedPNL));
        bb -= counterTrade;
        realizedPNL += (aa + bb) * (high - target - grt(high));
        System.out.println("realizedPNL( " + high + " ): " + num(realizedPNL));
    }

    static int counterTrade(long a, long b, long target, long low) {
        int sell = 0;

        while (!verifyGuarantee(a, b, target, low, sell)) {
            sell++;
        }
        return sell;
    }

    static boolean verifyGuarantee(long a, long b, long target, long low, int sell) {
        a += (a / target + b / target) * (low - target - grt(low));
        b -= low * sell;
        return (a + b) / (double) b >= 1.4;
    }

    static String num(double n) {
        return new DecimalFormat("###,###").format(n);
    }

    static int grt(double sell) {
        return (int) (sell * COMM);
    }
}
