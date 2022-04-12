package ru.alina.model;

import javax.persistence.*;

@Entity
@Table(name = "parameters")
public class Parameters {
    @Id
    public Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

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

    public Parameters() {
    }

    public Parameters(Long id, Gender gender, Integer height, Integer age, Activity activity, Double startWeight, Double desiredWeight, Integer calories) {
        this.id = id;
        this.gender = gender;
        this.height = height;
        this.age = age;
        this.activity = activity;
        this.startWeight = startWeight;
        this.desiredWeight = desiredWeight;
        this.calories = calories;
    }

    public Parameters(Gender gender, Integer height, Integer age, Activity activity, Double startWeight, Double desiredWeight, Integer calories) {
        this.gender = gender;
        this.height = height;
        this.age = age;
        this.activity = activity;
        this.startWeight = startWeight;
        this.desiredWeight = desiredWeight;
        this.calories = calories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Parameters{" +
                "id=" + id +
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
