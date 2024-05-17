// package onkar.Core_Java_Collections;

import java.util.*;

public class LokSabhaElection {
    private static Map<String, Integer> candidateVotes = new HashMap<>();
    private static Map<String, String> candidateParties = new HashMap<>();
    private static Set<String> candidates = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****Lok Sabha Election 2024****");
        while (true) {
            System.out.println("\n       Menu:       ");
            System.out.println("1. Add Candidate");
            System.out.println("2. Vote for Candidate");
            System.out.println("3. Display Candidate List");
            System.out.println("4. Display Election Results");
            System.out.println("5. Display Final Election Results");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCandidate(scanner);
                    break;
                case 2:
                    voteForCandidate(scanner);
                    break;
                case 3:
                    displayCandidateList();
                    break;
                case 4:
                    displayElectionResults();
                    break;
                case 5:
                    displayFinalElectionResults();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addCandidate(Scanner scanner) {
        System.out.print("Enter candidate name: ");
        String candidateName = scanner.next();
        System.out.print("Enter candidate party: ");
        String partyName = scanner.next();
        candidates.add(candidateName);
        candidateVotes.put(candidateName, 0);
        candidateParties.put(candidateName, partyName);
        System.out.println("Candidate added successfully!");
        System.out.println("----------------------------------------------");
    }

    private static void voteForCandidate(Scanner scanner) {
        if (candidates.isEmpty()) {
            System.out.println("No candidates added yet.");
            return;
        }

        System.out.println("Available candidates:");
        for (String candidate : candidates) {
            System.out.println(candidate);
        }

        System.out.print("Enter candidate name to vote: ");
        String candidateName = scanner.next();

        if (candidates.contains(candidateName)) {
            int currentVotes = candidateVotes.get(candidateName);
            candidateVotes.put(candidateName, currentVotes + 1);
            System.out.println("Vote casted successfully!");
        } else {
            System.out.println("Candidate not found.");
        }
        System.out.println("----------------------------------------------");
    }

    private static void displayCandidateList() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates added yet.");
        } else {
            System.out.println("\nCandidate List:");
            for (String candidate : candidates) {
                System.out.println(candidate + " (" + candidateParties.get(candidate) + ")");
            }
        }
        System.out.println("----------------------------------------------");
    }

    private static void displayElectionResults() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates added yet.");
            return;
        }

        System.out.println("\nElection Results:");
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            System.out.println(entry.getKey() + " (" + candidateParties.get(entry.getKey()) + "): " + entry.getValue() + " votes");
        }
        System.out.println("----------------------------------------------");
    }

    private static void displayFinalElectionResults() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates added yet.");
            return;
        }

        System.out.println("\nFinal Election Results:");
        TreeMap<Integer, List<String>> sortedResults = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            String candidate = entry.getKey();
            int votes = entry.getValue();
            String party = candidateParties.get(candidate);
            if (!sortedResults.containsKey(votes)) {
                sortedResults.put(votes, new ArrayList<>());
            }
            sortedResults.get(votes).add(candidate + " (" + party + ")");
        }

        int rank = 1;
        for (Map.Entry<Integer, List<String>> entry : sortedResults.entrySet()) {
            int votes = entry.getKey();
            List<String> candidates = entry.getValue();
            for (String candidate : candidates) {
                System.out.println("Rank " + rank + ": " + candidate + " - " + votes + " votes");
            }
            rank++;
        }
        System.out.println("----------------------------------------------");
    }
    
}
