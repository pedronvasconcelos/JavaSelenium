package com.javaseleniumtemplate.tests;


import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class ManageProfilesTests extends TestBase {

    //Objects
    LoginFlows loginFlows;
    MainPage mainPage;
    ManagePage managePage;
    ManageGlobalProfilePage manageGlobalProfilePage;

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



}