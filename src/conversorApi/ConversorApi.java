package conversorApi;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConversorApi {
        private String baseCode;
        private String targetCode;
        private String conversion_rate;
        private double amount;
        private String apiKey = "62de4c45fa84903a0465b9dd";
        List<Conversor> conversorList = new ArrayList<>();

        public ConversorApi(Conversor conversor){
            this.baseCode = conversor.getBaseCode();
            this.targetCode = conversor.getTargetCode();
            this.amount = conversor.getValor();
        }

        public String chamadaApi() throws RuntimeException {
            this.apiKey = apiKey;
            String uriConsulta = this.apiKey + "/pair/" + this.baseCode + "/" + this.targetCode + "/" + this.amount;

            URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + uriConsulta);


            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(uri)
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();

                Gson gson = new Gson();
                Conversor conversor = gson.fromJson(json, Conversor.class);
                conversorList.add(conversor);
                return conversor.toString();

            } catch (Exception e) {
                throw new RuntimeException("Erro!!");
                //return "Erro" + e.getMessage();
            }

        }

        public List<Conversor> getConversorList(){
            return conversorList;
        }

}
