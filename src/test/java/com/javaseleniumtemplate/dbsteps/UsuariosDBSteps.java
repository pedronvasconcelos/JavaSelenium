package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.Utils;

public class UsuariosDBSteps {

    private static String queriesPath = System.getProperty("user.dir")+ "/src/test/java/com/javaseleniumtemplate/queries/";

    public static String returnUserName(String usuario){
        String query = Utils.getFileContent(queriesPath + "realNameQuery.sql").replace("$username", usuario);

        return DBUtils.getQueryResult(query).get(0);
    }
}