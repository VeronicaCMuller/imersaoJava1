import java.util.List;
import java.util.Map;

public class ExtratorConteudoImDb implements ExtratorDeConteudo {

    public List <Conteudo> extraiConteudos (String json){

        // Extrair somente os dados de interesse (extração do título, poster, classificação) - parciar.
        JsonParser parser = new JsonParser();
        List<Map<String, String>>listaDeAtributos = parser.parse(json);

        return listaDeAtributos.stream().map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg"))).toList();

        
    }
    
}
