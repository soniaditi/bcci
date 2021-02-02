package com.bcci;

import java.util.*;
enum Bowler{
	SWING, SPIN, PACE;
	
}
enum Batsman{
	RIGHT_HANDED, LEFT_HANDED;
	
}
enum TypeOfPlayer{
	BATSMAN,
	BOWLER,
	ALL_ROUNDER;
}

public class Players {
private String name;
private int age;
private float average;
private float strikeRate;
private int noOfMatches;
private int runs;
private int wickets;
private int centuries;
private int halfCenturies;
private String playingCountry;
private Bowler bowler;
private Batsman batsman;
private TypeOfPlayer typeOfPlayer;

public Players() {
	
}


public void addPlayer(Management management) {
	Scanner sc= new Scanner(System.in);
	
	System.out.println("Enter the name of the Player you want to add:");
	name= sc.nextLine();
	System.out.println("Enter the age of "+name);
	age = sc.nextInt();
	
	System.out.println("Type of player:");
	System.out.println("Enter for 1 Batsman");
	System.out.println("Enter for 2 Bowler");
	System.out.println("Enter for 3 All Rounder");
	System.out.println("Enter your choice");
	int playerChoice = sc.nextInt();
	switch(playerChoice) {
		case 1:
			typeOfPlayer = typeOfPlayer.BATSMAN;
			System.out.println("Type of Batsman:");
			System.out.println("Enter 1 for Right handed");
			System.out.println("Enter 2 for Left handed");
			System.out.println("Enter your choice");
			int batsmanChoice=sc.nextInt();
			switch(batsmanChoice) {
			case 1: 
				batsman = batsman.RIGHT_HANDED;
				break;
			
			case 2:
				batsman = batsman.LEFT_HANDED;
				break;
				
			default:
				break;
			}
			break;
		case 2:
			typeOfPlayer = typeOfPlayer.BOWLER;
			System.out.println("Type of Bowlers:");
			System.out.println("Enter 1 for swinger");
			System.out.println("Enter 2 for spin");
			System.out.println("Enter 3 for pace ");
			System.out.println("Enter your choice:");
			int bowlerChoice=sc.nextInt();
			switch(bowlerChoice) {
			case 1: 
				bowler = bowler.SWING;
				break;
			
			case 2:
				bowler = bowler.SPIN;
				break;
				
			case 3:
				bowler= bowler.PACE;
				break;
				
			default:
				break;
			}
			break;
		case 3:
			typeOfPlayer = typeOfPlayer.ALL_ROUNDER;
			System.out.println("Type of Batsman:");
			System.out.println("Enter 1 for Right handed");
			System.out.println("Enter 2 for Left handed");
			System.out.println("Enter your choice");
			int allRounderBatsmanChoice=sc.nextInt();
			switch(allRounderBatsmanChoice) {
			case 1: 
				batsman = batsman.RIGHT_HANDED;
				break;
			
			case 2:
				batsman = batsman.LEFT_HANDED;
				break;
				
			default:
				break;
			}
			System.out.println("Type of Bowler:");
			System.out.println("Enter 1 for swinger");
			System.out.println("Enter 2 for spin");
			System.out.println("Enter 3 for pace ");
			System.out.println("Enter your choice:");
			int allRounderBowlerChoice=sc.nextInt();
			switch(allRounderBowlerChoice) {
			case 1: 
				bowler = bowler.SWING;
				break;
			
			case 2:
				bowler = bowler.SPIN;
				break;
				
			case 3:
				bowler= bowler.PACE;
				break;
				
			default:
				break;
			}
			
			break;
		default:
			break;
	}
	System.out.println("Enter ODI average of "+name);
	average=sc.nextFloat();
	System.out.println("\nEnter the strike rate of "+name);
	strikeRate=sc.nextFloat();
	System.out.println("Enter total no. of matches played by "+name);
	noOfMatches=sc.nextInt();
	System.out.println("\nEnter the total no of runs scored in the ODI by "+name);
	runs=sc.nextInt();
	System.out.println("\nEnter total No. of wickets taken by "+name+ " (otherwise put 0)");
	wickets=sc.nextInt();
	System.out.println("\nEnter no. of 100s scored by "+name);
	centuries=sc.nextInt();
	System.out.println("\nEnter no. of 50s scored by "+name);
	halfCenturies=sc.nextInt();
	sc.nextLine();
	boolean flag= true;
	while(flag) {
		System.out.println("Enter the team you want to add "+name+" into");
		String team =sc.nextLine();
		team=team.toLowerCase();
		if(management.IsTeam(team)) {
			playingCountry= team;
			flag=false;
			System.out.println("Player "+name+" has been added to team "+team);
		}
		else {
			System.out.println("ACTION UNSUCCESSFULL!!.No such team is available in the database!!. Do you want to add "+name+" to another team (enter yes or no)");
			String choice = sc.nextLine();
			if(!choice.equalsIgnoreCase("yes")) {
				playingCountry= "No Country";
				flag=false;
			}
		}
	}
	

	
	
}

public Players(String name, int age, float average, float strikeRate, int noOfMatches, int runs, int wickets,
		int centuries, int halfCenturies, String playingCountry, Bowler bowler, Batsman batsman,
		TypeOfPlayer typeOfPlayer) {
	super();
	this.name = name;
	this.age = age;
	this.average = average;
	this.strikeRate = strikeRate;
	this.noOfMatches = noOfMatches;
	this.runs = runs;
	this.wickets = wickets;
	this.centuries = centuries;
	this.halfCenturies = halfCenturies;
	this.playingCountry = playingCountry;
	this.bowler = bowler;
	this.batsman = batsman;
	this.typeOfPlayer = typeOfPlayer;
}

public String getPlayingCountry() {
	return playingCountry;
}

public void setPlayingCountry(String playingCountry) {
	this.playingCountry = playingCountry;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public float getAverage() {
	return average;
}
public void setAverage(float average) {
	this.average = average;
}
public float getStrikeRate() {
	return strikeRate;
}
public void setStrikeRate(float strikeRate) {
	this.strikeRate = strikeRate;
}
public int getNoOfMatches() {
	return noOfMatches;
}
public void setNoOfMatches(int noOfMatches) {
	this.noOfMatches = noOfMatches;
}
public int getRuns() {
	return runs;
}
public void setRuns(int runs) {
	this.runs = runs;
}
public int getWickets() {
	return wickets;
}
public void setWickets(int wickets) {
	this.wickets = wickets;
}
public int getCenturies() {
	return centuries;
}
public void setCenturies(int centuries) {
	this.centuries = centuries;
}
public int getHalfCenturies() {
	return halfCenturies;
}
public void setHalfCenturies(int halfCenturies) {
	this.halfCenturies = halfCenturies;
}
public Bowler getBowler() {
	return bowler;
}
public void setBowler(Bowler bowler) {
	this.bowler = bowler;
}
public Batsman getBatsman() {
	return batsman;
}
public void setBatsman(Batsman batsman) {
	this.batsman = batsman;
}
public TypeOfPlayer getTypeOfPlayer() {
	return typeOfPlayer;
}
public void setTypeOfPlayer(TypeOfPlayer typeOfPlayer) {
	this.typeOfPlayer = typeOfPlayer;
}

@Override
public String toString() {
	return "Players: Name=" + getName() + ", Age=" + getAge() +  ", Type Of Player=" + getTypeOfPlayer()+  "Batsman="
			+ getBatsman() + ", Bowler=" + getBowler() + ", Average=" + getAverage()
			+ ", Strike Rate=" + getStrikeRate() + ", No Of Matches=" + getNoOfMatches() + ", Runs="
			+ getRuns() + ", Wickets=" + getWickets() + ", Centuries=" + getCenturies()
			+ ", Half Centuries=" + getHalfCenturies() + ",Playing Country="+getPlayingCountry();
}



}

