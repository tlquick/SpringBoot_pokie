package com.tlquick.pokie.models;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pokie")
@Component
@NoArgsConstructor
public class Pokie implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Getter
	private int spins = 0;
    private double turnover = 0.0;
    private double payouts = 0.0;
    @Autowired
    @Getter
    @OneToOne(cascade=CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "playerId")
    private Player player;
    @Autowired
    @Getter
    @Transient
    private Lines lines;
    @Getter
    private int betLines = 1;
    @Transient
    private String DEFAULT_MSG = "Press Spin";
    @Getter
    @Setter
    @Transient
    private String msg = DEFAULT_MSG;
    private String result = "JJJ";
    public Pokie(int id) {
    	this.id = id;
    	player = new Player();
    	lines = new Lines();
    }
	public void addCredit(double amount)
    {
        player.updateBalance(amount);
    }
    public void bet(int amount)
    {
        player.setBet(amount);
    }
    public void betLines(int lines)
    {
        betLines = lines;
    }
    public void spin()
    {
        double wager = player.getBet()* betLines;
        player.placeBet(wager);
        turnover += wager;
        spins ++;
        result = lines.getResult();
        lines.spin();     
    }
    public String getResult()
    {
        return lines.getResult();
    }
    public void reset()
    {
    	player = new Player();
    	lines = new Lines();
    	betLines = 1;
    	spins = 0;
        turnover = 0.0;
        payouts = 0.0;
        msg = DEFAULT_MSG;
    }
    public void payOut()
    {
        double amount = player.payout(lines.payOff(betLines));
        player.updateBalance(amount);
        payouts += amount;
        if ( amount > 0)
            setMsg("Congratulations! You won $" + ((int)amount));
        else
        	setMsg(DEFAULT_MSG);
    }
    public double getPayOut()
    {
        return player.payout(lines.payOff(betLines));
    }
    public void collect()
    {   
        player.collect();
    }  
    public int turnover()
    {
        return (int)turnover;
    }
    public int payouts()
    {
        return (int)payouts;
    }
    public void credits(int amount)
    {
    	player.updateBalance(amount);
    }
    public String toString()
    {   
        String s = "Cherry Bomb:";
        s += " payouts = $" + payouts;
        s += " turnover = $" + turnover;
        s += " spins = " + spins;
        s += "\n" + player.toString();
        return s;   
    }
}
