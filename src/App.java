import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        API api = API.LINGUAGENS;

        
        String url = api.getUrl();
        ExtratorDeConteudo extrator = api.getExtrator();
        
        var http = new ClienteHttp(); 
        String json = http.buscaDados(url);

                  
        // Exibir e manipular os dados.

        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        var fabrica  = new FabricaDeFigurinha();
            
        for  (int i = 0; i < 5; i++)  {
            
            Conteudo conteudo = conteudos.get(i);
            
            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo =  "saida/" + conteudo.titulo() + ".png";

            
            fabrica.criacao(inputStream , nomeArquivo);

            
            System.out.println(conteudo.titulo());
            System.out.println();
        }
    } 
}