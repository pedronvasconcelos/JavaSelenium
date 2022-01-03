package com.javaseleniumtemplate.tests;


import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageTagTests extends TestBase {

    //Objects
    LoginFlows loginFlows;
    MainPage mainPage;
    ManagePage managePage;
    ManageTagPage manageTagPage;
    ManageProjectPage manageProjectPage;


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
    public void deleteTag(){

        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageTagPage = new ManageTagPage();
        manageProjectPage = new ManageProjectPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String tagName = "delete";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageTags();
        manageTagPage.clickTag(tagName);
        manageTagPage.clickDeleteTag();
        manageTagPage.clickDeleteTag();


        //Assert
        Assert.assertFalse(manageTagPage.returnIfTagExists(tagName));
    }

}