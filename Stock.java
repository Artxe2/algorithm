import java.text.DecimalFormat;

public class Stock {
    static final double COMM = 0.0025;
    public static void main(String[] args) {
        long target = 107000;
        long a = 56000000;
        long aa = a / target; // 523
        long b = a * 100 / 45 / 10000 * 10000;
        long bb = b / target; // 1162
        long low = 103500;
        long high = 110000;
        int counterTrade = counterTrade(a, b, target, low);

        System.out.println("start( " + target + " ): "
                + num((aa + bb) * target * -COMM));

        System.out.println("counterTrade: " + num(counterTrade));

        double realizedPNL = counterTrade * (low - target - low * COMM);

        System.out.println("realizedPNL( " + low + " ): " + num(realizedPNL));
        bb -= counterTrade;
        realizedPNL += (aa + bb) * (high - target - high * COMM);
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
        a += (a / target + b / target) * (low - target - low * COMM);
        b -= low * sell;
        return (a + b) / (double) b >= 1.4;
    }

    static String num(double n) {
        return new DecimalFormat("###,###").format(n);
    }
}
