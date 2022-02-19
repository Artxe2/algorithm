public class Gson {
    private static com.google.gson.Gson p =
            new com.google.gson.GsonBuilder().setPrettyPrinting().create();
    private static com.google.gson.Gson g =
            new com.google.gson.Gson();

    private Gson() {}

    public static <T> T fromJson(Class<T> classOfT, String json)
            throws com.google.gson.JsonSyntaxException {
        return g.fromJson(json, classOfT);
    }

    public static String toJson(Object src) {
        return g.toJson(src);
    }

    public static String toJsonPretty(Object src) {
        return p.toJson(src);
    }
}
