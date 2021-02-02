package com.bcci;


import java.util.*;

public class Management {
	 public List<Players> playersList= new ArrayList<Players>();
	 public List<Teams> teamsList= new ArrayList<Teams>();
	 
	 
	 public boolean IsTeam(String teamName) {
			boolean flag = false;
			for(Teams team : teamsList) {
				if(teamName.equals(team.getTeamName()))
					flag = true;
			}
			
			return flag;
	} 
	 
	 public void addPlayersToTeam(String playerName) {
		 Scanner sc = new Scanner(System.in);
		 
		 for(Players player : playersList) {
				if(playerName.equals(player.getName())) {
					System.out.println("Enter team name");
					String teamName = sc.nextLine();
					if(IsTeam(teamName)) {
						if(player.getPlayingCountry().equalsIgnoreCase(teamName)) {
						
							System.out.println(playerName+" Player is already present in "+teamName);
						}
						if(player.getPlayingCountry().equalsIgnoreCase("No Country")) {
							player.setPlayingCountry(teamName);
							System.out.println(playerName+" Player added successfully to "+teamName);
						}
					}
					else {
						System.out.println( teamName+" is not available in the list");
					}
				}
			}
	 }
	
	 public void removePlayersFromTeam(String playerName) {
		 int n=playersList.size();
		 boolean flag=false;
		 if(n!=0) {
			for(Players player : playersList) {
				if(playerName.equals(player.getName())) {
					System.out.println("Player Name: " + playerName+" Playing for team: " + player.getPlayingCountry());
					player.setPlayingCountry("No country");
					System.out.println("SUCCESSFULLY REMOVED!! Player Name: "+ playerName+"is now playing for " + player.getPlayingCountry());
					flag=true;
				}
			}
			if(flag==false)
				System.out.println("ACTION UNSUCCESSFUL!!. "+playerName+" is not available in the list");
		}
		 else
			 System.out.println("opss!! Players list is empty. First add some players by entering the respective choice from the menu.");
	 }
	
	 public void searchPlayers(String playerName) {
			int n= playersList.size();
			boolean flag=false;
			if(n!=0) {
				for(Players player : playersList) {
					if(player.getName().equalsIgnoreCase(playerName)) {
						System.out.println("Player "+playerName+" is present in the database. The details are as follows");
						System.out.println(player.toString());
						flag=true;
					}
			}
			if(flag==false) {
				System.out.println(playerName+" is not present in the List.");
				System.out.println("List of Players available in database are:");
				System.out.println(playersList);
				}
			}
			else
				System.out.println("Player list is empty. Please add some players by entering the respective choice from the menu.");
	}
	 
	 public void searchTeams(String teamName) {
			
			Scanner sc= new Scanner(System.in);
		
			int n= teamsList.size();
			boolean flag=false;
			if(n!=0) {
				for(Teams team : teamsList) {
					if(team.getTeamName().equalsIgnoreCase(teamName)) {
						System.out.println("Team "+teamName+" is present in the database. The details are as follows");
						System.out.println(team.toString());
						flag= true;
					}
				}
				if(flag==false) {
					System.out.println(teamName+" is not present in the List.");
					System.out.println("List of teams available in database are:");
					System.out.println(teamsList);
				}
			}
			else
				System.out.println("List of team is empty. Please add teams by entering the respective choice from the menu.");
	}
	 
	 public void countPlayersInTeam(String teamName) {
			int count = 0;
			for (Players player : playersList) {
				if (teamName.equalsIgnoreCase(player.getPlayingCountry())) {
					count++;
				}
			}
			if(count<=0)
				System.out.println("Their is no player in "+teamName+" team yet");
			else
				System.out.println("Currently Total number of players in the team are: "+count);
				
		}
	 public void printPlayersInTeam(String teamName) {
			List<String> playersPerTeamList = new ArrayList<>();
			boolean flag=false;
			for (Players player : playersList) {
				String team = player.getPlayingCountry();
				if (team.equalsIgnoreCase(teamName)) {
					playersPerTeamList.add(player.getName());
					flag=true;
				}
			}
			if(flag==false) 
				System.out.println("Their is no player in "+teamName+" team yet");
			else {
				Collections.sort(playersPerTeamList);
				System.out.println(playersPerTeamList);
			}
			
		}
	 public void sortByName() {
		 int n= teamsList.size();
		 if(n!=0) {
			 Collections.sort(teamsList, new ComparisonByName());
			 System.out.println(teamsList);
			 
		 }
		 else
			 System.out.println("List of team is empty. Please add teams by entering the respective choice from the menu.");
	 }
	 
	 public void sortByDate() {
		 int n= teamsList.size();
		 if(n!=0) {
			 Collections.sort(teamsList, new ComparisonByDate());
			 System.out.println(teamsList);
		 }
		 else
			 System.out.println("List of team is empty. Please add teams by entering the respective choice from the menu.");
	 }
}

