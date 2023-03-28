import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer um aconexão HTTP e buscar os top 250 filmes
        String url =  "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        URI address = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
           
        // Extrair somente os dados de interesse (extração do título, poster, classificação) - parciar.
        JsonParser parser = new JsonParser();
        List<Map<String, String>>listaDeSeries = parser.parse(body);
        //Utilitário Lista< Utilitario Map que associa uma chave com o valor <Tipo da chave, tipo do valor associado à essa chave> dados que queremos = 
       
        // Exibir e manipular os dados.
        for (int i = 0; i < 3; i++) {
            Map<String,String> serie = listaDeSeries.get(i);
            System.out.println("\u001b[1m Título:\u001b[m" + serie.get("title"));
            System.out.println("\u001b[1m Poster:\u001b[m" + serie.get("image"));
            System.out.println("\u001b[37;1m \u001b[45;1mClassificação:\u001b[m " + serie.get("imDbRating"));
            double nota = Double.parseDouble(serie.get("imDbRating"));
            if (nota <= 3.0) {
                System.out.println("⭐");
            }else if (nota > 3.0 && nota < 5.1) {
                System.out.println("⭐⭐");
            }else if (nota > 5.0 && nota > 7.1){
                System.out.println("⭐⭐⭐");
            }else if (nota > 7.0 && nota < 8.9){
                System.out.println("⭐⭐⭐⭐");
            }else if (nota >= 9.0 && nota < 10.0) {
                System.out.println("⭐⭐⭐⭐⭐");
            }
            System.out.println("\n");
        }
    }
}
