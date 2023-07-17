package com.oops.ratzlord.appointmentscheduler.model;

import com.oops.ratzlord.appointmentscheduler.entity.Work;
import com.oops.ratzlord.appointmentscheduler.entity.user.User;
import com.oops.ratzlord.appointmentscheduler.entity.user.customer.CorporateCustomer;
import com.oops.ratzlord.appointmentscheduler.entity.user.customer.RetailCustomer;
import com.oops.ratzlord.appointmentscheduler.entity.user.provider.Provider;
import com.oops.ratzlord.appointmentscheduler.validation.FieldsMatches;
import com.oops.ratzlord.appointmentscheduler.validation.UniqueUsername;
import com.oops.ratzlord.appointmentscheduler.validation.groups.*;
import com.oops.ratzlord.appointmentscheduler.validation.groups.*;

import javax.validation.constraints.*;
import java.util.List;

@FieldsMatches(field = "password", matchingField = "matchingPassword", groups = {CreateUser.class})
public class UserForm {

    @NotNull(groups = {UpdateUser.class})
    @Min(value = 1, groups = {UpdateUser.class})
    private int id;

    @UniqueUsername(groups = {CreateUser.class})
    @Size(min = 5, max = 15, groups = {CreateUser.class}, message = "Username should have 5-15 letters")
    @NotBlank(groups = {CreateUser.class})
    private String userName;

    @Size(min = 5, max = 15, groups = {CreateUser.class}, message = "Password should have 5-15 letters")
    @NotBlank(groups = {CreateUser.class})
    private String password;

    @Size(min = 5, max = 15, groups = {CreateUser.class}, message = "Password should have 5-15 letters")
    @NotBlank(groups = {CreateUser.class})
    private String matchingPassword;

    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "First name cannot be empty")
    private String firstName;

    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "Last name cannot be empty")
    private String lastName;

    @Email(groups = {CreateUser.class, UpdateUser.class}, regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\.bits-pilani\\.ac\\.in+$", message = "Email not valid! Enter bitsmail only")
    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "Email cannot be empty")
    private String email;

    @Pattern(groups = {CreateUser.class, UpdateUser.class}, regexp = "[0-9]{10}", message = "Please enter valid mobile phone")
    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "Mobile phone cannot be empty")
    private String mobile;

    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 5, max = 30, message = "Invalid Hostel/Quarter name!")
    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "Hostel/Quarter cannot be empty")
    private String street;

    @Pattern(groups = {CreateUser.class, UpdateUser.class}, regexp = "^[A-Z]-[0-9]+$", message = "Please enter valid room/house number")
    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "Room/House number cannot be empty")
    private String postcode;

    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "Campus City cannot be empty")
    private String city;

    /*
     * CorporateCustomer only:
     * */
    @NotBlank(groups = {CreateCorporateCustomer.class, UpdateCorporateCustomer.class}, message = "Department cannot be empty")
    private String companyName;

    @Pattern(groups = {CreateCorporateCustomer.class, UpdateCorporateCustomer.class}, regexp = "^[A-Z]-[0-9]{3}+$", message = "Please enter valid Room number")
    @NotBlank(groups = {CreateCorporateCustomer.class, UpdateCorporateCustomer.class}, message = "Room number cannot be empty")
    private String vatNumber;

    /*
     * Provider only:
     * */
    @NotNull(groups = {CreateProvider.class, UpdateProvider.class})
    private List<Work> works;


    public UserForm() {
    }

    public UserForm(User user) {
        this.setId(user.getId());
        this.setUserName(user.getUserName());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setCity(user.getCity());
        this.setStreet(user.getStreet());
        this.setPostcode(user.getPostcode());
        this.setMobile(user.getMobile());
    }

    public UserForm(Provider provider) {
        this((User) provider);
        this.setWorks(provider.getWorks());
    }

    public UserForm(RetailCustomer retailCustomer) {
        this((User) retailCustomer);
    }

    public UserForm(CorporateCustomer corporateCustomer) {
        this((User) corporateCustomer);
        this.setCompanyName(corporateCustomer.getCompanyName());
        this.setVatNumber(corporateCustomer.getVatNumber());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

}