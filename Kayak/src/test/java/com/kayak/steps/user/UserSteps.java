package com.kayak.steps.user;

import com.kayak.domain.builders.UserBuilder;
import com.kayak.domain.entities.User;
import com.kayak.domain.helpers.UserHelper;
import com.kayak.domain.models.response.CreateUserResponse;
import com.kayak.domain.models.response.UserResponse;
import com.kayak.domain.models.response.UsersResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class UserSteps {
    private UserHelper userHelper;
    private CreateUserResponse createUserResponse;
    private int createUserStatusCode = 0;
    private UserResponse userResponse;
    private int userStatusCode = 0;
    private UsersResponse usersResponse;
    private int usersStatusCode = 0;
    private User user;

    public UserSteps(UserHelper userHelper) {
        this.userHelper = userHelper;
    }

    @When("^I create user$")
    public void createUser() throws Throwable {
        create();
    }

    @When("^I try to create user \"([^\"]*)\"$")
    public void iTryToCreateUser(String task) throws Throwable {
        switch (task){
            case "Success":
                successfullCreateUser();
                break;
            case "WithoutName":
                createWithoutName();
                break;
            case "WithoutJob":
                createWithoutJob();
                break;
            case "WithoutJobAndName":
                createWithoutJobAndName();
                break;
        }

    }

    @When("^I get user$")
    public void getUser() throws Throwable {
        userResponse = userHelper.getUser();
    }

    @When("^I try to get user$")
    public void iTryToGetUser() throws Throwable {
        userStatusCode = userHelper.getUserWithStatusCode();
    }

    @When("^I get users$")
    public void getUsers() throws Throwable {
        usersResponse = userHelper.getUsers();
    }

    @When("^I try to get users$")
    public void iTryToGetUsers() throws Throwable {
        usersStatusCode = userHelper.getUsersWithStatusCode();
    }

    @Then("^I check create user$")
    public void iCheckCreateUser() {
        createUserCheck();
    }

    @Then("^I check user$")
    public void iCheckUser() {
        userCheck();
    }

    @Then("^I check users$")
    public void iCheckUsers() {
        usersCheck();
    }

    @Then("^I compare the user$")
    public void iCompareTheUser() {
        userCompare();
    }

    @Then("^I should see \"([^\"]*)\" status code$")
    public void iShouldSeeStatusCode(int statusCode) {
        if (createUserStatusCode != 0) {
            Assert.assertTrue("", statusCode == createUserStatusCode);
        }

        if (userStatusCode != 0) {
            Assert.assertTrue("", statusCode == userStatusCode);
        }

        if (usersStatusCode != 0) {
            Assert.assertTrue("", statusCode == usersStatusCode);
        }
    }

    private void create() throws UnirestException {
        user = (new UserBuilder())
                .setName("celil")
                .setJob("engineer")
                .build();
        createUserResponse = userHelper.createUser(user);
    }

    private void createWithoutJob() throws UnirestException {
        user = (new UserBuilder())
                .setName("celil")
                .build();
        createUserResponse = userHelper.createUser(user);
    }

    private void createWithoutJobAndName() throws UnirestException {
        user = (new UserBuilder())
                .build();
        createUserResponse = userHelper.createUser(user);
    }

    private void createWithoutName() throws UnirestException {
        user = (new UserBuilder())
                .setJob("engineer")
                .build();
        createUserResponse = userHelper.createUser(user);
    }

    private void successfullCreateUser() throws UnirestException {
        user = (new UserBuilder())
                .setName("celil")
                .setJob("engineer")
                .build();
        createUserStatusCode = userHelper.createUserWithStatusCode(user);
    }

    private void createUserCheck() {
        Assert.assertEquals("Create user response job is wrong", createUserResponse.job, user.job);
        Assert.assertEquals("Create user response name is wrong", createUserResponse.name, user.name);
        Assert.assertNotNull("Create user response id is null", createUserResponse.id);
        Assert.assertTrue("Create user response id is not string", createUserResponse.id instanceof String);
        Assert.assertNotNull("Create user response created at is null", createUserResponse.createdAt);
        Assert.assertTrue("Create user response created at is not string", createUserResponse.createdAt instanceof String);
    }

    private void userCheck() {
        Assert.assertEquals("User response email is wrong", userResponse.data.email, ("george.bluth@reqres.in"));
        Assert.assertTrue("User response id is wrong", userResponse.data.id == 1);
        Assert.assertEquals("User response first name is wrong", userResponse.data.first_name, ("George"));
        Assert.assertEquals("User response last name is wrong", userResponse.data.last_name, ("Bluth"));
        Assert.assertEquals("User response avatar is wrong", userResponse.data.avatar, ("https://reqres.in/img/faces/1-image.jpg"));
        Assert.assertEquals("User response url is wrong", userResponse.support.url, ("https://reqres.in/#support-heading"));
        Assert.assertEquals("User response text is wrong", userResponse.support.text, ("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }

    private void usersCheck() {
        Assert.assertTrue("Users response page is wrong", usersResponse.page == 1);
        Assert.assertTrue("Users response per_page is wrong", usersResponse.per_page == 6);
        Assert.assertTrue("Users response total count is wrong", usersResponse.total == 12);
        Assert.assertTrue("Users response total pages count is wrong", usersResponse.total_pages == 2);
        for (int i = 1; i <= 6; i++) {
            Assert.assertTrue("Users response id is wrong", usersResponse.data.get(i - 1).id == i);
            Assert.assertTrue("Users response email is wrong", (usersResponse.data.get(i - 1).email).contains(("@reqres.in")));
            Assert.assertTrue("Users response first name is null", usersResponse.data.get(i - 1).first_name != null);
            Assert.assertTrue("Users response first name is not string", usersResponse.data.get(i - 1).first_name instanceof String);
            Assert.assertTrue("Users response last name is null", usersResponse.data.get(i - 1).last_name != null);
            Assert.assertTrue("Users response last name is not string", usersResponse.data.get(i - 1).last_name instanceof String);
            Assert.assertTrue("Users response avatar is wrong", (usersResponse.data.get(i - 1).avatar).equals("https://reqres.in/img/faces/" + i + "-image.jpg"));
        }
    }

    private void userCompare() {
        Assert.assertEquals("User response email is wrong", userResponse.data.email, usersResponse.data.get(0).email);
        Assert.assertTrue("User response id is wrong", userResponse.data.id == usersResponse.data.get(0).id);
        Assert.assertEquals("User response first name is wrong", userResponse.data.first_name, usersResponse.data.get(0).first_name);
        Assert.assertEquals("User response last name is wrong", userResponse.data.last_name, usersResponse.data.get(0).last_name);
        Assert.assertEquals("User response avatar is wrong", userResponse.data.avatar, usersResponse.data.get(0).avatar);
    }
}