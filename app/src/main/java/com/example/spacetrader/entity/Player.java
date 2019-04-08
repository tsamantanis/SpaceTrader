package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Integer> skillDistribution;

    private String difficulty;

    private int credits;

    private Spaceship spaceship;

    private String weapon;

    public Player() {}

    public Player(String name, int[] skillDistribution, String difficulty) {
        this.name = name;
        this.skillDistribution = new ArrayList<>();
        for (int skill : skillDistribution) {
            this.skillDistribution.add(skill);
        }
        this.difficulty = difficulty;
        this.credits = 1000;
        this.spaceship = new Spaceship();
        this.weapon = "pulse laser";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSkillDistribution() {
        return skillDistribution;
    }

    public void setSkillDistribution(List<Integer> skillDistribution) {
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

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

}
