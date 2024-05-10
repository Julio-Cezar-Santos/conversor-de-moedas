import com.google.gson.Gson;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor{
    public String converteMoeda(String base_code, String target_code, double valor) {

        try {
            URI uri = URI.create("https://v6.exchangerate-api.com/v6/ee1754377a6ada9fe7a908d1/pair/" + base_code + "/"+ target_code + "/" + valor);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            Cotacao cotacao = new Gson().fromJson(responseBody, Cotacao.class);

            if (cotacao.errorType() != null) {
                return  "Error: " + cotacao.errorType();
            }else{
                return "Valor " + valor + " " + base_code + " convertido para " + target_code + " é " + cotacao.conversion_result();
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
