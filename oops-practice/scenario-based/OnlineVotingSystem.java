import java.util.*;

class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String msg) {
        super(msg);
    }
}

abstract class ElectionService {
    abstract void registerVoter(int id, String name);
    abstract void addCandidate(int id, String name);
    abstract void castVote(int voterId, int candidateId) throws DuplicateVoteException;
    abstract void showResult();
}

class Voter {
    int id;
    String name;
    boolean hasVoted;

    Voter(int id, String name) {
        this.id = id;
        this.name = name;
        this.hasVoted = false;
    }
}

class Candidate {
    int id;
    String name;
    int votes;

    Candidate(int id, String name) {
        this.id = id;
        this.name = name;
        this.votes = 0;
    }
}

class Election extends ElectionService {

    Map<Integer, Voter> voters = new HashMap<>();
    Map<Integer, Candidate> candidates = new HashMap<>();

    void registerVoter(int id, String name) {
        voters.put(id, new Voter(id, name));
        System.out.println("Voter registered: " + name);
    }

    void addCandidate(int id, String name) {
        candidates.put(id, new Candidate(id, name));
        System.out.println("Candidate added: " + name);
    }

    void castVote(int voterId, int candidateId) throws DuplicateVoteException {
        Voter voter = voters.get(voterId);
        Candidate candidate = candidates.get(candidateId);

        if (voter.hasVoted) {
            throw new DuplicateVoteException("Vote already cast");
        }

        voter.hasVoted = true;
        candidate.votes++;
        System.out.println("Vote cast successfully");
    }

    void showResult() {
        System.out.println("\nElection Results");
        for (Candidate c : candidates.values()) {
            System.out.println(c.name + " : " + c.votes);
        }
    }
}

public class OnlineVotingSystem {
    public static void main(String[] args) {

        Election election = new Election();

        election.registerVoter(1, "Sneha");
        election.registerVoter(2, "Amit");

        election.addCandidate(101, "Candidate A");
        election.addCandidate(102, "Candidate B");

        try {
            election.castVote(1, 101);
            election.castVote(2, 102);
            election.castVote(1, 102);
        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        election.showResult();
    }
}
