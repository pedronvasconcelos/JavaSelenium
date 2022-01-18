package com.javaseleniumtemplate.tests;


import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.ProjetosDbSteps;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.ManagePage;
import com.javaseleniumtemplate.pages.ManageProjectPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageProjectTests extends TestBase {

    //Objects
    LoginFlows loginFlows;
    MainPage mainPage;
    ManagePage managePage;
    ManageProjectPage manageProjectPage;

    @Test
    public void createNewProject(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageProjectPage = new ManageProjectPage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String successMessage = "Operation successful.";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickManage();
        managePage.clickManageProjects();
        manageProjectPage.clickCreateNewProject();
        manageProjectPage.fillProjectName("Test Auto");
        manageProjectPage.fillDescription("Test description");
        manageProjectPage.clickAddProject();

        //Assert
        Assert.assertEquals(manageProjectPage.returnSucessText(), successMessage);

    }

    @Test
    public void createNewProjectWithQuery(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageProjectPage = new ManageProjectPage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String nomeProjeto = "SQL Project";

        //Query
        ProjetosDbSteps.createProject(nomeProjeto);

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickManage();
        managePage.clickManageProjects();
        manageProjectPage.clickProjectLink(nomeProjeto);

        //Assertion
        Assert.assertEquals(nomeProjeto, manageProjectPage.getProjectNameFieldText());
        Assert.assertEquals("Criado por Query", manageProjectPage.getDescriptionFieldText());

    }

    @Test
    public void deleteProject(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageProjectPage = new ManageProjectPage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String nomeProjeto = "delete";

        //Query

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickManage();
        managePage.clickManageProjects();
        manageProjectPage.clickProjectLink(nomeProjeto);
        manageProjectPage.clickDelete();
        manageProjectPage.clickUpdate();

        //Assert
        Assert.assertFalse(manageProjectPage.returnProjectExists(nomeProjeto));
    }

    @Test
    public void updateProjectName(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageProjectPage = new ManageProjectPage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String projectName = "updateThisProject";
        String newName = "newName";


        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickManage();
        managePage.clickManageProjects();
        manageProjectPage.clickProjectLink(projectName);
        manageProjectPage.fillProjectName(newName);
        manageProjectPage.clickUpdate();

        //Assert
        Assert.assertEquals(manageProjectPage.returnCreatedProject(newName), newName);
    }
    @Test
    public void createNewPrivateProject(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageProjectPage = new ManageProjectPage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String successMessage = "Operation successful.";
        String projectName = "Private Project";
        String projectDescription = "Private Description";
        String status = "private";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickManage();
        managePage.clickManageProjects();
        manageProjectPage.clickCreateNewProject();
        manageProjectPage.fillProjectName(projectName);
        manageProjectPage.fillDescription(projectDescription);
        manageProjectPage.selectViewStatus(status);
        manageProjectPage.clickAddProject();

        //Assert
        Assert.assertEquals(manageProjectPage.returnSucessText(), successMessage);

    }


    @Test
    public void createNewSubProject(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageProjectPage = new ManageProjectPage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String successMessage = "Operation successful.";
        String projectName = "Main Project";
        String subProjectName = "Sub Project";
        String description = "This is a Sub Project";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickManage();
        managePage.clickManageProjects();
        manageProjectPage.clickProjectLink(projectName);
        manageProjectPage.clickNewSubProject();
        manageProjectPage.fillProjectName(subProjectName);
        manageProjectPage.fillDescription(description);
        manageProjectPage.clickAddProject();

        //Assert
        Assert.assertEquals(manageProjectPage.returnSucessText(), successMessage);

    }

    @Test
    public void createNewVersion(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageProjectPage = new ManageProjectPage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String successMessage = "Operation successful.";
        String projectName = "Project Version";
        String version = "1.1";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickManage();
        managePage.clickManageProjects();
        manageProjectPage.clickProjectLink(projectName);
        manageProjectPage.fillVersion(version);
        manageProjectPage.clickAddVersion();

        //Assert
        Assert.assertEquals(manageProjectPage.returnSucessText(), successMessage);

    }

    @Test
    public void createNewCategory(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageProjectPage = new ManageProjectPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String categoryName = "Testes automatizados";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageProjects();
        manageProjectPage.fillCategoryAdd(categoryName);
        manageProjectPage.clickAddCategory();

        //Assert
        Assert.assertEquals(categoryName, manageProjectPage.returnCreatedCategory(categoryName));
    }

}