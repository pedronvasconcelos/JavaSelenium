package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.Utils;

public class ProjetosDbSteps {

    private static String queriesPath = System.getProperty("user.dir")+ "/src/test/java/com/javaseleniumtemplate/queries/";

    public static void createProject(String projectName){
        String query = Utils.getFileContent(queriesPath + "createProject.sql").replace("$name", projectName);
        DBUtils.executeUpdateQuery(query);
    }
}
