package yang.java.distribute.engine.util;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class JobLibraryProvider {

    public static ClassLoader provideClassLoader(String location) throws IOException {
        if(!Files.exists(Paths.get(location))) {
            throw new IOException("location file not found");
        }
        List<URI> uris = Files.walk(Paths.get(location), FileVisitOption.FOLLOW_LINKS)
                .map(e -> e.toUri()).filter(e -> e.toString().toLowerCase().endsWith(".jar"))
                .collect(Collectors.toList());
        URL[] urls = new URL[uris.size()];
        for (int i = 0; i < urls.length; i++) {
            urls[i] = uris.get(i).toURL();
        }
        return new URLClassLoader(urls);


    }

}
