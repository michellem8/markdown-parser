import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class MarkdownParseTest {
    
    @Test
    public void addition(){
       assertEquals(2, 1+1) ;
    }

    @Test 
    public void MarkDownTest() throws IOException{

        //MarkdownParse md = new MarkdownParse();
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
	    System.out.println(links);
        //ArrayList<String> expec = md.getLink(Files.readString("test-file.md"));
        List<String> got = List.of("https://something.com", "some-thing.html");
        System.out.print(links);
        assertEquals(got, links);
    }
}

