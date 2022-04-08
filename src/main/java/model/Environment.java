package model;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    public EnvironmentModel intEnv;
    public EnvironmentModel testEnv;
    public EnvironmentModel defaultEnv;

    public EnvironmentModel getIntEnv() {
        return intEnv;
    }

    public EnvironmentModel getTestEnv() {
        return testEnv;
    }

    public EnvironmentModel getDefaultEnv() {
        return defaultEnv;
    }

    public List<EnvironmentModel> getListOfEnvironments(){
        List<EnvironmentModel> listOfEnvironments = new ArrayList<>();
        listOfEnvironments.add(getIntEnv());
        listOfEnvironments.add(getTestEnv());
        listOfEnvironments.add(getDefaultEnv());
        return listOfEnvironments;

    }
}
