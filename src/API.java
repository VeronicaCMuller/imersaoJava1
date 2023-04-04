public enum API {
    
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorConteudoImDb()),
    IMDB_TOP_SERIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new ExtratorConteudoImDb()),
    NASA ("https://api.nasa.gov/planetary/apod?api_key=bMdBeyJyImenYLZCP9JpeVGLDrIySzYhRcAz3oeD&start_date=2021-02-15&end_date=2022-02-18", new ExtratorConteudoNasa());
    
    private String url;
    private ExtratorDeConteudo extrator;

    API (String url, ExtratorDeConteudo extrator){
       this.url = url;
       this.extrator = extrator;
    }   

    public String getUrl(){
        return url;
    }

    public ExtratorDeConteudo getExtrator(){
        return extrator;
    }
}
