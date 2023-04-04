import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class FabricaDeFigurinha {
    
    public void criacao(InputStream inputStream, String nomeArquivo) throws Exception{

        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);


        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        
        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0 , 0, null);
        
        //configurar a fonte
        var fonte = new Font("Impact", Font.BOLD, 98);
        graphics.setColor(Color.ORANGE);
        graphics.setFont(fonte);
       
        // escrever na nova imagem
        String texto = "Muito bom!";
        FontMetrics metricasFonte =graphics.getFontMetrics();
        Rectangle2D retangulo = metricasFonte.getStringBounds(texto, graphics);

        int largutaTexto = (int) retangulo.getWidth();
        int posicaoTextoX = ((largura - largutaTexto)/2);

        int posicaoTextoY = novaAltura - 100;
        
        graphics.drawString(texto, posicaoTextoX, posicaoTextoY);

        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var textLayout =  new TextLayout(texto, fonte, fontRenderContext);

        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posicaoTextoX, posicaoTextoY);
        graphics.setTransform(transform);

        var outlineStroke =  new BasicStroke(largura * 0.004f);
        graphics.setStroke(outlineStroke);

        graphics.setColor(Color.BLACK);
        graphics.draw(outline);
        graphics.setClip(outline);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File (nomeArquivo));
    }
}
