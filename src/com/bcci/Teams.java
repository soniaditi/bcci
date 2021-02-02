package com.bcci;

import java.util.*;




public class Teams  {
	private String teamName;
	private String currentCaptain;
	private int noOfMatchesPlayed;
	private int noOfMatchesWon;
	private int noOfMatchesLost;
	private Date dateOfCreation;
	
	

	public void addTeam(Management management)  {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Name of the Team");
		teamName = sc.nextLine();
		teamName=teamName.toLowerCase();
		System.out.println("Enter current Captain of "+teamName);
		currentCaptain = sc.nextLine();
		System.out.println("Enter no Of Matches Played by "+teamName);
		noOfMatchesPlayed = sc.nextInt();
		System.out.println("Enter no Of Matches won by "+teamName);
		noOfMatchesWon = sc.nextInt();
		System.out.println("Enter no Of Matches lost by "+teamName);
		noOfMatchesLost = sc.nextInt();
		dateOfCreation = new Date();
		Teams team = new Teams(teamName,currentCaptain,noOfMatchesPlayed,noOfMatchesWon,noOfMatchesLost,dateOfCreation);
		management.teamsList.add(team);
		
	}
	

	
	public Teams() {
		
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}


	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getCaptain() {
		return currentCaptain;
	}
	public void setCaptain(String currentCaptain) {
		this.currentCaptain = currentCaptain;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public int getNoOfMatchesPlayed() {
		return noOfMatchesPlayed;
	}
	public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
		this.noOfMatchesPlayed = noOfMatchesPlayed;
	}
	public int getNoOfMatchesWon() {
		return noOfMatchesWon;
	}
	public void setNoOfMatchesWon(int noOfMatchesWon) {
		this.noOfMatchesWon = noOfMatchesWon;
	}
	public int getNoOfMatchesLost() {
		return noOfMatchesLost;
	}
	public void setNoOfMatchesLost(int noOfMatchesLost) {
		this.noOfMatchesLost = noOfMatchesLost;
	}
	public Teams(String teamName,String currentCaptain, int noOfMatchesPlayed, int noOfMatchesWon, int noOfMatchesLost, Date dateOfCreation) {
		this.teamName = teamName;
		this.currentCaptain= currentCaptain;
		this.noOfMatchesPlayed = noOfMatchesPlayed;
		this.noOfMatchesWon = noOfMatchesWon;
		this.noOfMatchesLost = noOfMatchesLost;
		this.dateOfCreation= dateOfCreation;
	}
	
@Override
	public String toString() {
		return "\nTeams ODI Records: TeamName= " + getTeamName() +  ",current Captain= "+getCaptain()+", No. Of Matches Played= " + getNoOfMatchesPlayed()
				+ ", No. Of Matches Won= " + getNoOfMatchesWon() + ", No. Of Matches Lost= " + getNoOfMatchesLost()+", Date Of Creation= " +getDateOfCreation();
	}

	
}

class ComparisonByDate implements Comparator<Teams> {

	//public Comparator<Teams> compareByDate = new ComparisonByDate();
		@Override
		public int compare(Teams o1, Teams o2) {
			Date Date1 = o1.getDateOfCreation();
			Date Date2 = o2.getDateOfCreation();
			int compare=Date1.compareTo(Date2);
			if(compare==0) {
				compare=Integer.compare(o1.getNoOfMatchesPlayed(), o2.getNoOfMatchesPlayed());
			}
			return compare;
		}
	
}

class ComparisonByName implements Comparator<Teams>{
	  //Comparator<Teams> compareByName = new ComparisonByName() ;
	  @Override
	  public int compare(Teams o1, Teams o2) {
		String name1=o1.getTeamName();
		String name2=o2.getTeamName();
		int compare =name1.compareToIgnoreCase(name2);
		return compare;
	}

	
}
	
	