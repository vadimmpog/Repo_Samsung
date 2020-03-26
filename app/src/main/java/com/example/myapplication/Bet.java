package com.example.myapplication;

public class Bet {
    private int id;
    private String teamHome;
    private String teamGuest;
    private float betTeamHome;
    private float betTeamGuest;
    private float betDraw;

    public int getId() {
        return id;
    }

    public String getTeamHome() {
        return teamHome;
    }

    public String getTeamGuest() {
        return teamGuest;
    }

    public float getBetDraw(){
        return betDraw;
    }


    public float getBetTeamHome() {
        return betTeamHome;
    }

    public float getBetTeamGuest() {
        return betTeamGuest;
    }

    Bet(int id, String teamHome, String teamGuest, float betTeamHome, float betDraw, float betTeamGuest){
        this.id = id;
        this.teamHome = teamHome;
        this.teamGuest = teamGuest;
        this.betTeamHome = betTeamHome;
        this.betDraw = betDraw;
        this.betTeamGuest = betTeamGuest;

    }
}
