package videoCurriculum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamMenuApp {
	
	static Scanner scanner = new Scanner(System.in);
	static List<Team> teams = new ArrayList<Team>();

	public static void main(String[] args) {
		
		int decision = 0;
		
		while (true) {
			printOptions();
			decision = scanner.nextInt();
			if (decision == 1) {
				teams.add(createNewTeam());
			} else if (decision == 2) {
				addPlayerToTeam();
			} else if (decision == 3) {
				removePlayerFromTeam();
			} else if (decision == 4) {
				describeTeam();
			} else {
				System.out.println("Please Pick a Valid Option!");
			}
		}
		
	}
	
	private static void printOptions() {
		System.out.println("1) Create New Team");
		System.out.println("2) Add New Player To Team");
		System.out.println("3) Remove Player From Team");
		System.out.println("4) View Team Info");
	}
	
	private static void describeTeam() {
		printTeamNames();
		System.out.print("Which team would you like to see the info for? ");
		String teamName = scanner.next();
		try {
			Team foundTeam = findTeamByName(teamName);
			foundTeam.describe();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static Team createNewTeam() {
		System.out.print("Enter name of the team you want to create: ");
		String name = scanner.next();
		return new Team(name);
	}
	
	private static void addPlayerToTeam() {
		printTeamNames();
		System.out.print("Enter the name of the team you wish to add a player to:");
		String teamName = scanner.next();
		try {
			Team foundTeam = findTeamByName(teamName);
			foundTeam.addPlayer(createNewPlayer());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static void removePlayerFromTeam() {
		printTeamNames();
		System.out.print("Enter the name of the team you wish to remove a player from:");
		String teamName = scanner.next();
		try {
			Team foundTeam = findTeamByName(teamName);
			foundTeam.describe();
			System.out.print("Which player would you like to remove? ");
			String playerName = scanner.next();
			foundTeam.removePlayer(playerName);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static Player createNewPlayer() {
		System.out.print("Enter player name: ");
		String name = scanner.next();
		System.out.print("Enter player position: ");
		String position = scanner.next();
		System.out.print("Enter player specialty: ");
		String specialty = scanner.next();
		return new Player(name, position, specialty);
	}
	
	private static void printTeamNames() {
		for (Team team : teams) {
			System.out.println(team.getName());
		}
	}
	
	private static Team findTeamByName(String name) throws Exception {
		for (Team team : teams) {
			if (team.getName().equals(name)) {
				return team;
			}
		}
		throw new Exception("Team Not Found: " + name);
	}

}
