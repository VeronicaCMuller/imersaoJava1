import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ExtratorConteudoNasa implements ExtratorDeConteudo {

    //public List <Conteudo> extraiConteudos (String json){
    public List <Conteudo> extraiConteudos (String json){
        JsonParser parser = new JsonParser();
        List<Map<String, String>>listaDeAtributos = parser.parse(json);

        return listaDeAtributos.stream().map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url"))).toList();

    }
}    