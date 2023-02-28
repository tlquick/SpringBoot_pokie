package com.tlquick.pokie.models;


import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Component
@Entity
@Table(name = "player")
public class Player  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "ID")
	@Id
	@GeneratedValue
	private int id;
    private double balance = 0.0;
    @Getter
    @Setter
    private double bet = 1.0;
    @Getter
    private int games = 0;

    public boolean canBet(int lines)
    {
        return balance >= bet*lines;
    }
    public void placeBet(double betAmount)
    {
        balance -= betAmount;
        games++;
    }
    public double payout(double amount)
    {
        return bet * amount;
    }
    public void collect()
    {
        balance = 0;
        games = 0;
    }
    public void updateBalance(double amount)
    {
        balance += amount;
    }
    public int getBalance()
    {
        return (int)balance;
    }
    public String toString()
    {
        return "Player: bet $" + bet + " balance $" + balance + " games played " + games;
    }
}
