import java.util.*;

public class Election {
    private Map<Integer, Candidate> candidates = new HashMap<>();
    private int candidateCounter = 1;

    public void addCandidate(String name) {
        Candidate c = new Candidate(candidateCounter++, name);
        candidates.put(c.getId(), c);
        System.out.println("Candidate added: " + c.getName() + " [ID: " + c.getId() + "]");
    }

    public void showCandidates() {
        System.out.println("=== Candidates ===");
        for (Candidate c : candidates.values()) {
            System.out.println("ID: " + c.getId() + " | Name: " + c.getName());
        }
    }

    public void castVote(int voterId, int candidateId) {
        if (Voter.hasVoted(voterId)) {
            System.out.println("Voter ID " + voterId + " has already voted!");
            return;
        }

        Candidate c = candidates.get(candidateId);
        if (c == null) {
            System.out.println("Invalid candidate ID.");
            return;
        }

        c.addVote();
        Voter.markVoted(voterId);
        System.out.println("Vote cast for: " + c.getName());
    }

    public void showResults() {
        System.out.println("=== Election Results ===");
        for (Candidate c : candidates.values()) {
            System.out.println(c.getName() + ": " + c.getVotes() + " votes");
        }
    }

    public void showWinner() {
        Candidate winner = null;
        for (Candidate c : candidates.values()) {
            if (winner == null || c.getVotes() > winner.getVotes()) {
                winner = c;
            }
        }

        if (winner != null) {
            System.out.println("🏆 Winner: " + winner.getName() + " with " + winner.getVotes() + " votes!");
        } else {
            System.out.println("No votes cast yet.");
        }
    }
}
