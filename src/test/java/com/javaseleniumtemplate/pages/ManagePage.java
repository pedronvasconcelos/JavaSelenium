package com.javaseleniumtemplate.pages;
import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ManagePage extends PageBase{
    //Mapping
    By manageProjectsMenu = By.xpath("//a[@href='/manage_proj_page.php']");
    By manageTagsMenu = By.xpath("//a[@href='/manage_tags_page.php']");
    By manageCustomFieldMenu = By.xpath("//a[@href='/manage_custom_field_page.php']");
    By manageGlobalProfileMenu = By.xpath("//a[@href='/manage_prof_menu_page.php']");
    By manageUsersMenu = By.xpath("//a[@href='/manage_user_page.php']");

    public void clickManageProjects(){
        click(manageProjectsMenu);
    }

    public void clickManageTags(){
        click(manageTagsMenu);
    }

    public void clickManageCustomField(){
        click(manageCustomFieldMenu);
    }

    public void clickManageGlobalProfile(){
        click(manageGlobalProfileMenu);
    }

    public void clickManageUsers(){
        click(manageUsersMenu);
    }


}
