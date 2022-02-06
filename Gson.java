import com.google.gson.JsonSyntaxException;

public class Gson {
    private static com.google.gson.Gson g = new com.google.gson.Gson();

    private Gson() {}

    public static <T> T fromJson(Class<T> classOfT, String json)
            throws JsonSyntaxException {
        return g.fromJson(json, classOfT);
    }
}
