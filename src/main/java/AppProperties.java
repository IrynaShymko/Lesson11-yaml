import model.EnvironmentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AppProperties {
    private static Logger logger = LoggerFactory.getLogger("AppProperties.class");

    public AppProperties() {
        setSystemPropertiesFromYamlEnvironment();
    }

    private void setSystemPropertiesFromYamlEnvironment() {
        YMLreader ymlReader = new YMLreader();
        List<EnvironmentModel> listOfEnvironments = ymlReader.getConfiguration().getEnvironment().getListOfEnvironments();
        boolean foundActiveEnvironment = false;
        for (EnvironmentModel environmentModel : listOfEnvironments) {
            if (environmentModel.isActive()) {
                foundActiveEnvironment = true;
                Map<String, Object> environmentProperties = environmentModel.getEnvironmentProperties();
                for (Map.Entry entry : environmentProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    logger.info("Loaded environment property: {} = {}", entry.getKey().toString(), entry.getValue().toString());
                }
                logger.info("Loaded environment properties total: {}", environmentProperties.size());
                break;
            }
        }
        if (foundActiveEnvironment==false) {
            loadDefaultEnvironment();
        }
    }

    private void loadDefaultEnvironment() {
        logger.info("No environment was specified in config file. Loading default properties");
        Map<String, Object> environmentProperties = new YMLreader().getConfiguration().getEnvironment().getDefaultEnv().getEnvironmentProperties();
        for (Map.Entry entry : environmentProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Loaded environment property: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
        logger.info("Loaded environment properties total: {}", environmentProperties.size());
        }
    }

