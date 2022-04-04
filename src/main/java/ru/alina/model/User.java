package ru.alina.model;

import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date registered;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "uk_user_roles")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer height;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Activity activity;

    @Column(name = "start_weight")
    private Double startWeight;

    @Column(name = "desired_weight")
    private Double desiredWeight;

    private Integer calories;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Integer id, String email, String password, Gender gender, Integer height, Integer age, Activity activity, Double startWeight, Double desiredWeight, Integer calories, Role role, Role...roles) {
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

    public User(String email, String password, Gender gender, Integer height, Integer age, Activity activity, Double startWeight, Double desiredWeight, Integer calories, Role role, Role...roles) {
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
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

    public Double getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(Double startWeight) {
        this.startWeight = startWeight;
    }

    public Double getDesiredWeight() {
        return desiredWeight;
    }

    public void setDesiredWeight(Double desiredWeight) {
        this.desiredWeight = desiredWeight;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
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
