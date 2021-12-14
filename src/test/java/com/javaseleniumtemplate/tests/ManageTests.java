package com.javaseleniumtemplate.tests;


import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class ManageTests extends TestBase {

    //Objects
    LoginFlows loginFlows;
    MainPage mainPage;
    ManagePage managePage;
    ManageTagPage manageTagPage;
    ManageProjectPage manageProjectPage;
    ManageCustomFieldPage manageCustomFieldPage;
    ManageGlobalProfilePage manageGlobalProfilePage;
    ManageUsersPage manageUsersPage;
    SoftAssert softAssert = new SoftAssert();


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
        manageProjectPage.fillDescription("Test descrption");
        manageProjectPage.clickAddProject();

        //Assert
        Assert.assertEquals(manageProjectPage.returnSucessText(), successMessage);

    }

    @Test
    public void createNewTag(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageTagPage = new ManageTagPage();
        manageProjectPage = new ManageProjectPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String tagName = "tagTeste";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageTags();
        manageTagPage.fillDescription("descrição tag");
        manageTagPage.fillName(tagName);
        manageTagPage.clickCreate();

        //Assert
        Assert.assertEquals(tagName, manageTagPage.returnCreatedTag(tagName));
    }

    @Test
    public void updateTag(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageTagPage = new ManageTagPage();
        manageProjectPage = new ManageProjectPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String newTagName = "New Name";
        String description = "New Description";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageTags();
        manageTagPage.clickTag("OldTag");
        manageTagPage.clickUpdateTag();
        manageTagPage.fillName(newTagName);
        manageTagPage.fillDescription(description);
        manageTagPage.clickUpdateTag();

        //Assert
        Assert.assertEquals(newTagName, manageTagPage.returnNameTag());
        Assert.assertEquals(description, manageTagPage.returnDescriptionTag());
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

    @Test
    public void createNewCustomField(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageCustomFieldPage = new ManageCustomFieldPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String fieldName = "Automatizado";
        String sucessMessage = "Operation successful.";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageCustomField();
        manageCustomFieldPage.fillNameField(fieldName);
        manageCustomFieldPage.clickNewCustom();

        //Assert
        Assert.assertEquals(manageCustomFieldPage.returnSucessText(), sucessMessage);
    }

    @Test
    public void editCustomField(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageCustomFieldPage = new ManageCustomFieldPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String fieldName = "Editar";
        String type = "Numeric";
        String sucessMessage = "Operation successful.";


        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageCustomField();
        manageCustomFieldPage.clickCustomField(fieldName);
        manageCustomFieldPage.selectType(type);
        manageCustomFieldPage.clickUpdate();

        //Assert
        Assert.assertEquals(manageCustomFieldPage.returnSucessText(), sucessMessage);
    }

    @Test
    public void createGlobalProfile(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageGlobalProfilePage = new ManageGlobalProfilePage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String platform = "Mobile";
        String os = "Windows Mobile";
        String osVersion = "11";
        String sucessMessage = "Operation successful.";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageGlobalProfile();
        manageGlobalProfilePage.fillPlatformField(platform);
        manageGlobalProfilePage.fillOsField(os);
        manageGlobalProfilePage.fillOsVersion(osVersion);
        manageGlobalProfilePage.clickAddProfile();

        //Assert
        Assert.assertEquals(manageGlobalProfilePage.returnSucessText(), sucessMessage);

    }

    @Test
    public void checkGlobalProfileOsVersionFieldRequired(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageGlobalProfilePage = new ManageGlobalProfilePage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String platform = "Mobile";
        String os = "Windows Mobile";
        String alertMessage = "Please fill out this field.";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageGlobalProfile();
        manageGlobalProfilePage.fillPlatformField(platform);
        manageGlobalProfilePage.fillOsField(os);
        manageGlobalProfilePage.clickAddProfile();

        //Assert
        Assert.assertEquals(manageGlobalProfilePage.alertOsVersionMessage(), alertMessage);

    }

    @Test
    public void checkGlobalProfileOsFieldRequired(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageGlobalProfilePage = new ManageGlobalProfilePage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String platform = "Mobile";
        String osVersion = "Windows 11";
        String alertMessage = "Please fill out this field.";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageGlobalProfile();
        manageGlobalProfilePage.fillPlatformField(platform);
        manageGlobalProfilePage.fillOsVersion(osVersion);
        manageGlobalProfilePage.clickAddProfile();

        //Assert
        Assert.assertEquals(manageGlobalProfilePage.alertOsFieldMessage(), alertMessage);

    }

    @Test
    public void checkGlobalProfilePlatformRequired(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageGlobalProfilePage = new ManageGlobalProfilePage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String os = "Windows";
        String osVersion = "Windows 11";
        String alertMessage = "Please fill out this field.";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageGlobalProfile();
        manageGlobalProfilePage.fillOsField(os);
        manageGlobalProfilePage.fillOsVersion(osVersion);
        manageGlobalProfilePage.clickAddProfile();

        //Assert
        Assert.assertEquals(manageGlobalProfilePage.alertPlatformMessage(), alertMessage);

    }

    @Test
    public void createNewUser(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageUsersPage = new ManageUsersPage();


        //Parameters
        String user = "administrator";
        String password = "adm";
        String username = "User01";
        String realname = "User Random";
        String email = "user@user.com.br";
        String successMessage = "Created user " + username + " with an access level of reporter";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickCreateNewAcc();
        manageUsersPage.fillUsernameField(username);
        manageUsersPage.fillRealnameField(realname);
        manageUsersPage.fillEmailField(email);
        manageUsersPage.clickCreateUser();

        //Assert
        Assert.assertEquals(manageUsersPage.getSucessText(), successMessage);

    }

    @Test
    public void deleteUser(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageUsersPage = new ManageUsersPage();


        //Parameters
        String user = "administrator";
        String password = "adm";
        String username = "deleted";

        String successMessage = "Operation successful.";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickUserLink(username);
        manageUsersPage.clickDeleteUser();
        manageUsersPage.clickDeleteAccount();

        //Assert
        Assert.assertEquals(manageUsersPage.getSucessText(), successMessage);

    }

    @Test
    public void changeUserEmail(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageUsersPage = new ManageUsersPage();


        //Parameters
        String user = "administrator";
        String password = "adm";
        String username = "updateEmail";
        String newEmail = "newEmail@user.com.br";
        String successMessage = "Operation successful.";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickUserLink(username);
        manageUsersPage.fillEmailField(newEmail);
        manageUsersPage.clickUpdateAccount();

        //Assert
        Assert.assertEquals(manageUsersPage.getSucessText(), successMessage);

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
    public void createNewUserWithoutUsername(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageUsersPage = new ManageUsersPage();


        //Parameters
        String user = "administrator";
        String password = "adm";
        String realname = "No Username user";
        String email = "nouser@user.com.br";
        String errorExpected = "APPLICATION ERROR #805";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickCreateNewAcc();
        manageUsersPage.fillRealnameField(realname);
        manageUsersPage.fillEmailField(email);
        manageUsersPage.clickCreateUser();

        //Assert
        Assert.assertEquals(manageUsersPage.getErrorText(), errorExpected);
    }

    @Test
    public void createUserWithDuplicatedEmail(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageUsersPage = new ManageUsersPage();


        //Parameters
        String user = "administrator";
        String password = "adm";
        String username = "duplicated2";
        String realname = "Dupli user";
        String email = "duplicated@email.com.br";
        String errorExpected = "APPLICATION ERROR #813";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickCreateNewAcc();
        manageUsersPage.fillUsernameField(username);
        manageUsersPage.fillRealnameField(realname);
        manageUsersPage.fillEmailField(email);
        manageUsersPage.clickCreateUser();

        //Assert
        Assert.assertEquals(manageUsersPage.getErrorText(), errorExpected);
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
    public void createDuplicateUser(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageUsersPage = new ManageUsersPage();


        //Parameters
        String user = "administrator";
        String password = "adm";
        String username = "duplicate";
        String realname = "Duplicate Iser";
        String email = "duplicate1user@email.com.br";
        String errorExpected = "APPLICATION ERROR #800";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickCreateNewAcc();
        manageUsersPage.fillUsernameField(username);
        manageUsersPage.fillRealnameField(realname);
        manageUsersPage.fillEmailField(email);
        manageUsersPage.clickCreateUser();

        //Assert
        Assert.assertEquals(manageUsersPage.getErrorText(), errorExpected);
    }


}