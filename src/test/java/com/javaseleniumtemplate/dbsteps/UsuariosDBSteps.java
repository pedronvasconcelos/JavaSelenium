package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.Utils;

public class UsuariosDBSteps {

    private static String queriesPath = "src/test/java/com/javaseleniumtemplate/queries/usuariosqueries/";

    public static String retornaSenhaDoUsuarioDB(String usuario){
        String query = Utils.getFileContent(queriesPath + "retornaSenhaDoUsuario.sql").replace("$usuario", usuario);

        return DBUtils.getQueryResult(query).get(0);
    }
}
