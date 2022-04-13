package ru.alina.to;

import ru.alina.model.Activity;
import ru.alina.model.Gender;
import ru.alina.model.Profile;


public class ProfileTo {

    public Long id;

    private Gender gender;

    private Integer height;

    private Integer age;


    private Activity activity;


    private Double startWeight;


    private Double desiredWeight;

    private Integer calories;

    private Integer slowGoal;

    private Integer middleGoal;

    private Integer fastGoal;

    public ProfileTo() {
    }

    public ProfileTo(Profile profile) {
        this.id = profile.getId();
        this.gender = profile.getGender();
        this.height = profile.getHeight();
        this.age = profile.getAge();
        this.activity = profile.getActivity();
        this.startWeight = profile.getStartWeight();
        this.desiredWeight = profile.getDesiredWeight();
        this.calories = profile.getCalories();
        this.slowGoal = this.calories - (this.calories/100 * 10);
        this.middleGoal = this.calories - (this.calories/100 * 15);
        this.fastGoal = this.calories - (this.calories/100 * 20);
    }

    public Long getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getAge() {
        return age;
    }

    public Activity getActivity() {
        return activity;
    }

    public Double getStartWeight() {
        return startWeight;
    }

    public Double getDesiredWeight() {
        return desiredWeight;
    }

    public Integer getCalories() {
        return calories;
    }

    public Integer getSlowGoal() {
        return slowGoal;
    }

    public Integer getMiddleGoal() {
        return middleGoal;
    }

    public Integer getFastGoal() {
        return fastGoal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setStartWeight(Double startWeight) {
        this.startWeight = startWeight;
    }

    public void setDesiredWeight(Double desiredWeight) {
        this.desiredWeight = desiredWeight;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public void setSlowGoal(Integer slowGoal) {
        this.slowGoal = slowGoal;
    }

    public void setMiddleGoal(Integer middleGoal) {
        this.middleGoal = middleGoal;
    }

    public void setFastGoal(Integer fastGoal) {
        this.fastGoal = fastGoal;
    }

    @Override
    public String toString() {
        return "ProfileDao{" +
                "id=" + id +
                ", gender=" + gender +
                ", height=" + height +
                ", age=" + age +
                ", activity=" + activity +
                ", startWeight=" + startWeight +
                ", desiredWeight=" + desiredWeight +
                ", calories=" + calories +
                ", slowGoal=" + slowGoal +
                ", middleGoal=" + middleGoal +
                ", fastGoal=" + fastGoal +
                '}';
    }
}
