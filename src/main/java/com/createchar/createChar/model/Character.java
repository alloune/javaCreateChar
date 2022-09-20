package com.createchar.createChar.model;

public class Character {
    //attributs de la classe
    private int id;
    private String name;
    private String type;
    private int hp;


    //constructeur
    public Character() {
    }


    public Character(int id, String name, String type, int hp) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hp = hp;
    }
    //Getters - Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    //Adaption à nos besoin du toString
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + name + '\'' +
                ", pdv=" + hp +
                ", classe=" + type +
                '}';
    }
}
