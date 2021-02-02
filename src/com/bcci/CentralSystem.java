package com.bcci;

import java.util.Scanner;

public class CentralSystem {
	public static void main(String args[]) {
		int choice=0;
		Scanner sc= new Scanner(System.in);
		Management management= new Management();
		
		do {
			System.out.println("**************Welcome to ICC ODI Records********************");
			System.out.println("Enter 1 to see menu for Teams");
			System.out.println("Enter 2 tosee menu for Players");
			System.out.println("Enter 3 to EXIT");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("**************Welcome to Team's Menu********************");
				System.out.println("Enter 1 to add a team");
				System.out.println("Enter 2 to print teams in the order of names");
				System.out.println("Enter 3 to print teams in the order of their date of creation");
				System.out.println("Enter 4 to search for teams in the database");
				System.out.println("Enter 5 to print players in the team");
				System.out.println("Enter 6 to Exit this menu");
				System.out.println("Enter your choice: ");
				int teamChoice = sc.nextInt();
				switch(teamChoice) {
				case 1: 
					Teams team = new Teams();
					team.addTeam(management);
					management.teamsList.add(team);
					break;
				
				case 2:
					management.sortByName();
					break;
					
				case 3:
					management.sortByDate();
					break;
					
				case 4:
					System.out.println("Enter the team name you want to search in the database:");
					String name= sc.nextLine();
					management.searchTeams(name);
					break;
				case 5:
					System.out.println("Enter the team name you want to print all players in:");
					String tName= sc.nextLine();
					management.printPlayersInTeam(tName);
					break;
				case 6: 
					System.out.println("Exiting Teams menu....");
					break;
				
				default:
					System.out.println("WRONG CHOICE");
					break;
				}
				break;
			
			case 2:
				System.out.println("**************Welcome to Player's Menu********************");
				System.out.println("Enter 1 to add Players in the databse");
				System.out.println("Enter 2 to Search Player in the database");
				System.out.println("Enter 3 to add Players to team");
				System.out.println("Enter 4 to remove Players from the team");
				System.out.println("Enter 5 to EXIT this menu");
				System.out.println("Enter your choice: ");
				int playerChoice = sc.nextInt();
				switch(playerChoice) {
					case 1:
						Players player = new Players();
						player.addPlayer(management);
						management.playersList.add(player);
						break;
					case 2:
						System.out.println("Enter name of the player you want to search");
						String name = sc.nextLine();
						sc.nextLine();
						management.searchPlayers(name);
						break;
					case 3:
						System.out.println("Enter name of the player you want to add in a team");
						String playerName = sc.nextLine();
						management.addPlayersToTeam(playerName);
						break;
					case 4:
						System.out.println("Enter player name to remove from any team");
						String removePlayerName = sc.nextLine();
						management.removePlayersFromTeam(removePlayerName);
						break;
					case 5: 
						System.out.println("Exiting Player menu....");
						break;
					default:
						System.out.println("WRONG CHOICE");
						break;
				}
				break;
			case 3:
				System.out.println("Thank you");
				break;
			default:
				System.out.println("oopss!!you have entered the wrong choice. Please try again!");
				break;
			}
		}while(choice!=3);
	}
}
