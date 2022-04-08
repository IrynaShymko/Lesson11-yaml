import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YMLreader {
    public static Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }

    public YMLreader() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.configuration = mapper.readValue(new File("src/main/resources/config.yaml"), Configuration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
