import com.google.gson.annotations.SerializedName;

public record Cotacao(String result, double conversion_result, String base_code, String target_code,
                      @SerializedName("error-type") String errorType) {
}