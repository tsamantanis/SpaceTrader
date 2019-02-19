package com.example.spacetrader.entity;

public class Player {

    private String name;

    private int[] skillDistribution;

    private String difficulty;

    private int credits;

    private String spaceship;

    private String weapon;

    private String location;

    public Player(String name, int[] skillDistribution, String difficulty) {
        this.name = name;
        this.skillDistribution = skillDistribution;
        this.difficulty = difficulty;
        this.credits = 1000;
        this.spaceship = "Second Hand Gnat";
        this.weapon = "pulse laser";
        this.location = "Local GGF space port";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getSkillDistribution() {
        return skillDistribution;
    }

    public void setSkillDistribution(int[] skillDistribution) {
        this.skillDistribution = skillDistribution;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getSpaceship() {
        return spaceship;
    }

    public void setSpaceship(String spaceship) {
        this.spaceship = spaceship;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
