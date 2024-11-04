package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Score {

    int wins;
    int losses;
    int ties;
    public Score(){}

    public Score(int wins, int losses, int ties) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void increasWins(){
        this.wins = this.wins+1;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }


}
