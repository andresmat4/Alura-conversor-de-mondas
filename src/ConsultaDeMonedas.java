import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDeMonedas {
    public DatosDeMonedas buscarMonedas(String monedaBase, String monedaTarget){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/2e3a69495a96c545ae679a6a/pair/"+monedaBase+"/"+monedaTarget);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), DatosDeMonedas.class);



        } catch (Exception e){
            throw new RuntimeException("No encontre la moneda");


        }
    }


}
