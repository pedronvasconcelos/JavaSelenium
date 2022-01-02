package com.javaseleniumtemplate.tests;


import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageUserTests extends TestBase {

    //Objects
    LoginFlows loginFlows;
    MainPage mainPage;
    ManagePage managePage;
    ManageUsersPage manageUsersPage;

    @Test
    public void createNewReporterUser(){
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
    public void createNewDeveloperUser(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageUsersPage = new ManageUsersPage();


        //Parameters
        String user = "administrator";
        String password = "adm";
        String username = "devuser1";
        String realname = "Developer User";
        String email = "developer@user.com.br";
        String accessLevel = "developer";
        String successMessage = "Created user " + username + " with an access level of developer";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickCreateNewAcc();
        manageUsersPage.fillUsernameField(username);
        manageUsersPage.fillRealnameField(realname);
        manageUsersPage.fillEmailField(email);
        manageUsersPage.selectAccessLevel(accessLevel);
        manageUsersPage.clickCreateUser();

        //Assert
        Assert.assertEquals(manageUsersPage.getSucessText(), successMessage);

    }

    @Test
    public void createNewManagerUser(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageUsersPage = new ManageUsersPage();


        //Parameters
        String user = "administrator";
        String password = "adm";
        String username = "managerUser";
        String realname = "Manager User";
        String email = "managerr@user.com.br";
        String accessLevel = "manager";
        String successMessage = "Created user " + username + " with an access level of manager";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.clickCreateNewAcc();
        manageUsersPage.fillUsernameField(username);
        manageUsersPage.fillRealnameField(realname);
        manageUsersPage.fillEmailField(email);
        manageUsersPage.selectAccessLevel(accessLevel);
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

    @Test
    public void filterAUser(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageUsersPage = new ManageUsersPage();


        //Parameters
        String user = "administrator";
        String password = "adm";
        String username = "filterUser";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageUsers();
        manageUsersPage.fillUserFilter(username);
        manageUsersPage.clickApplyFilter();


        //Assert
        Assert.assertEquals(manageUsersPage.getUserLinkText(), username);
    }

}