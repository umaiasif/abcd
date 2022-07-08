/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author umair
 */
public class Round {
    private int roundId;
    private int gameId;
    private String guessNum;
    private LocalDateTime guessTime;
    private String result;

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGuessNum() {
        return guessNum;
    }

    public void setGuessNum(String guessNum) {
        this.guessNum = guessNum;
    }

    public LocalDateTime getGuessTime() {
        return guessTime;
    }

    public void setGuessTime(LocalDateTime guessTime) {
        this.guessTime = guessTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.roundId;
        hash = 67 * hash + this.gameId;
        hash = 67 * hash + Objects.hashCode(this.guessNum);
        hash = 67 * hash + Objects.hashCode(this.guessTime);
        hash = 67 * hash + Objects.hashCode(this.result);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Round other = (Round) obj;
        if (this.roundId != other.roundId) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.guessNum, other.guessNum)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        if (!Objects.equals(this.guessTime, other.guessTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Round{" + "roundId=" + roundId + ", gameId=" + gameId + ", guessNum=" + guessNum + ", guessTime=" + guessTime + ", result=" + result + '}';
    }
    
}
