import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import model.Browser;

import java.io.File;
import java.io.IOException;

public class BrowserYmlReader {
    public Browser browser;

    public Browser getBrowser() {
        return browser;
    }

    public BrowserYmlReader() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.browser = mapper.readValue(new File("src/main/resources/browserConfig.yaml"), Browser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
