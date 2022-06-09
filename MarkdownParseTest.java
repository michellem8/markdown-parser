//javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
//java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
import static org.junit.Assert.*;
import org.junit.*;
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

    
    @Test
    public void testSnip1() throws IOException{
        Path fileName = Path.of("snip1.md");
        // Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("url.com, `google.com", "google.com", "ucsd.edu");

        assertEquals(expected, links);
    }

    @Test
    public void testSnip2() throws IOException{
        Path fileName = Path.of("snip2.md");
        // Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("a.com", "a.com", "example.com");

        assertEquals(expected, links);
    }

    @Test
    public void testSnip3() throws IOException{
        Path fileName = Path.of("snip3.md");
        // Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");

        assertEquals(expected, links);
    }
    
}

