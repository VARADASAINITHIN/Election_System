import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Election election = new Election();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n=== Election System Menu ===");
            System.out.println("1. Add Candidate");
            System.out.println("2. Show Candidates");
            System.out.println("3. Cast Vote");
            System.out.println("4. View Results");
            System.out.println("5. Show Winner");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();  // clear buffer
                    System.out.print("Enter candidate name: ");
                    String name = sc.nextLine();
                    election.addCandidate(name);
                    break;
                case 2:
                    election.showCandidates();
                    break;
                case 3:
                    System.out.print("Enter your Voter ID (number): ");
                    int voterId = sc.nextInt();
                    System.out.print("Enter Candidate ID to vote for: ");
                    int candidateId = sc.nextInt();
                    election.castVote(voterId, candidateId);
                    break;
                case 4:
                    election.showResults();
                    break;
                case 5:
                    election.showWinner();
                    break;
                case 0:
                    System.out.println("Thank you for using the Election System.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
