package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.List;

import static com.example.spacetrader.entity.Game.calculateFuelPrice;

public class Player {

    private String name;

    private List<Integer> skillDistribution;

    private String difficulty;

    private int credits;

    private Spaceship spaceship;

    private String weapon;

    private Planet currentPlanet;

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

    public Planet getCurrentPlanet() {
        return this.currentPlanet;
    }

    public void travel(Planet planet) {
        int currentFuel = this.getSpaceship().getFuel();
        this.getSpaceship().setFuel(currentFuel - calculateFuelPrice(planet));
        this.setCurrentPlanet(planet);
    }

    public int calculateDistance(Planet planet) {
        return (int) Math.sqrt(Math.pow(planet.getX() - this.getCurrentPlanet().getX(), 2) + Math.pow(planet.getY() - this.getCurrentPlanet().getY(), 2));
    }

    public int calculateFuelPrice(Planet planet) {
        return (int) (calculateDistance(planet) * 3.5);
    }

    public void setCurrentPlanet(Planet planet) {
        this.currentPlanet = planet;
    }

}
