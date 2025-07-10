import java.util.HashSet;

public class Voter {
    private static HashSet<Integer> votedVoterIds = new HashSet<>();

    public static boolean hasVoted(int voterId) {
        return votedVoterIds.contains(voterId);
    }

    public static void markVoted(int voterId) {
        votedVoterIds.add(voterId);
    }
}
