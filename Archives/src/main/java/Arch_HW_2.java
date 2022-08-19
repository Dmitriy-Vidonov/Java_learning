import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class Arch_HW_2 {

    public static void main(String[] args) throws IOException {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        Path path = Paths.get("test2.zip");
        URI uri = URI.create("jar:" + path.toUri());
        try (FileSystem fs = FileSystems.newFileSystem(uri, env))
        {
            Path nf = fs.getPath("out.xyz");
            try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
                writer.write("hello");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}