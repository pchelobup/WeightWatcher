package ru.alina.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    private Date registered;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "uk_user_roles")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int height;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Activity activity;

    @Column(name = "start_weight")
    private double startWeight;

    @Column(name = "desired_weight")
    private double desiredWeight;

    private int calories;

    public User() {
    }


    public User(Integer id, String email, String password, Gender gender, int height, Integer age, Activity activity, double startWeight, double desiredWeight, int calories, Role role, Role...roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.roles = EnumSet.of(role, roles);
        this.gender = gender;
        this.height = height;
        this.age = age;
        this.activity = activity;
        this.startWeight = startWeight;
        this.desiredWeight = desiredWeight;
        this.calories = calories;
    }

    public User(String email, String password, Gender gender, int height, Integer age, Activity activity, double startWeight, double desiredWeight, int calories, Role role, Role...roles) {
        this.email = email;
        this.password = password;
        this.roles = EnumSet.of(role, roles);
        this.gender = gender;
        this.height = height;
        this.age = age;
        this.activity = activity;
        this.startWeight = startWeight;
        this.desiredWeight = desiredWeight;
        this.calories = calories;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public double getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(double startWeight) {
        this.startWeight = startWeight;
    }

    public double getDesiredWeight() {
        return desiredWeight;
    }

    public void setDesiredWeight(double desiredWeight) {
        this.desiredWeight = desiredWeight;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registered=" + registered +
                ", gender=" + gender +
                ", height=" + height +
                ", age=" + age +
                ", activity=" + activity +
                ", startWeight=" + startWeight +
                ", desiredWeight=" + desiredWeight +
                ", calories=" + calories +
                '}';
    }
}
