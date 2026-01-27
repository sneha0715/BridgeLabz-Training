import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholder;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    
    public InsurancePolicy(String policyNumber, String policyholder, LocalDate expiryDate, 
                          String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholder = policyholder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    
    public String getPolicyNumber() {
        return policyNumber;
    }
    
    public String getPolicyholder() {
        return policyholder;
    }
    
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    
    public String getCoverageType() {
        return coverageType;
    }
    
    public double getPremiumAmount() {
        return premiumAmount;
    }
    
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
    
    public boolean expiresWithin30Days() {
        long daysUntilExpiry = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
        return daysUntilExpiry >= 0 && daysUntilExpiry <= 30;
    }
    
    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy policy = (InsurancePolicy) obj;
        return policyNumber.equals(policy.policyNumber);
    }
    
    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
    
    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Policyholder='" + policyholder + '\'' +
                ", ExpiryDate=" + expiryDate +
                ", Coverage='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagementSet {
    private HashSet<InsurancePolicy> hashSet;
    private LinkedHashSet<InsurancePolicy> linkedHashSet;
    private TreeSet<InsurancePolicy> treeSet;
    
    public InsurancePolicyManagementSet() {
        this.hashSet = new HashSet<>();
        this.linkedHashSet = new LinkedHashSet<>();
        this.treeSet = new TreeSet<>();
    }
    
    public void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }
    
    public List<InsurancePolicy> getAllUniquePolicies() {
        return new ArrayList<>(hashSet);
    }
    
    public List<InsurancePolicy> getPoliciesExpiringWithin30Days() {
        List<InsurancePolicy> results = new ArrayList<>();
        for (InsurancePolicy policy : hashSet) {
            if (policy.expiresWithin30Days()) {
                results.add(policy);
            }
        }
        return results;
    }
    
    public List<InsurancePolicy> getPoliciesByType(String coverageType) {
        List<InsurancePolicy> results = new ArrayList<>();
        for (InsurancePolicy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                results.add(policy);
            }
        }
        return results;
    }
    
    public boolean hasDuplicate(InsurancePolicy policy) {
        return hashSet.contains(policy);
    }
    
    public void displayHashSet() {
        System.out.println("HashSet (Quick Lookup):");
        for (InsurancePolicy policy : hashSet) {
            System.out.println(policy);
        }
    }
    
    public void displayLinkedHashSet() {
        System.out.println("LinkedHashSet (Insertion Order):");
        for (InsurancePolicy policy : linkedHashSet) {
            System.out.println(policy);
        }
    }
    
    public void displayTreeSet() {
        System.out.println("TreeSet (Sorted by Expiry Date):");
        for (InsurancePolicy policy : treeSet) {
            System.out.println(policy);
        }
    }
    
    public void performanceComparison() {
        System.out.println("=== Performance Comparison ===");
        
        int iterations = 100000;
        InsurancePolicy[] policies = new InsurancePolicy[1000];
        for (int i = 0; i < 1000; i++) {
            LocalDate date = LocalDate.now().plusDays(i % 365);
            policies[i] = new InsurancePolicy("P" + i, "Holder" + i, date, 
                                             i % 3 == 0 ? "Health" : i % 3 == 1 ? "Auto" : "Home", 
                                             1000 + i);
        }
        
        HashSet<InsurancePolicy> tempHash = new HashSet<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            tempHash.add(policies[i % 1000]);
        }
        long endTime = System.nanoTime();
        System.out.println("HashSet Add Time: " + (endTime - startTime) / 1000000 + " ms");
        
        LinkedHashSet<InsurancePolicy> tempLinked = new LinkedHashSet<>();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            tempLinked.add(policies[i % 1000]);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (endTime - startTime) / 1000000 + " ms");
        
        TreeSet<InsurancePolicy> tempTree = new TreeSet<>();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            tempTree.add(policies[i % 1000]);
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (endTime - startTime) / 1000000 + " ms");
        
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            tempHash.contains(policies[i % 1000]);
        }
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) / 1000000 + " ms");
        
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            tempLinked.contains(policies[i % 1000]);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (endTime - startTime) / 1000000 + " ms");
        
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            tempTree.contains(policies[i % 1000]);
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1000000 + " ms");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InsurancePolicyManagementSet system = new InsurancePolicyManagementSet();
        
        LocalDate today = LocalDate.now();
        system.addPolicy(new InsurancePolicy("P001", "John Doe", today.plusDays(15), "Health", 5000));
        system.addPolicy(new InsurancePolicy("P002", "Jane Smith", today.plusDays(45), "Auto", 3000));
        system.addPolicy(new InsurancePolicy("P003", "John Doe", today.plusDays(25), "Home", 8000));
        system.addPolicy(new InsurancePolicy("P004", "Mike Johnson", today.minusDays(10), "Health", 4500));
        system.addPolicy(new InsurancePolicy("P005", "Sarah Williams", today.plusDays(5), "Auto", 3500));
        
        boolean running = true;
        while (running) {
            System.out.println("=== Insurance Policy Management (Set-based) ===");
            System.out.println("1. Display all unique policies (HashSet)");
            System.out.println("2. Display policies in insertion order (LinkedHashSet)");
            System.out.println("3. Display policies sorted by expiry (TreeSet)");
            System.out.println("4. Get policies expiring in 30 days");
            System.out.println("5. Get policies by coverage type");
            System.out.println("6. Check for duplicate policy");
            System.out.println("7. Performance comparison");
            System.out.println("8. Add new policy");
            System.out.println("9. Exit");
            System.out.println("Enter choice:");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    system.displayHashSet();
                    break;
                case 2:
                    system.displayLinkedHashSet();
                    break;
                case 3:
                    system.displayTreeSet();
                    break;
                case 4:
                    List<InsurancePolicy> expiring = system.getPoliciesExpiringWithin30Days();
                    if (expiring.isEmpty()) {
                        System.out.println("No policies expiring within 30 days");
                    } else {
                        System.out.println("Policies expiring in 30 days:");
                        for (InsurancePolicy p : expiring) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter coverage type (Health/Auto/Home):");
                    String type = sc.nextLine();
                    List<InsurancePolicy> byType = system.getPoliciesByType(type);
                    if (byType.isEmpty()) {
                        System.out.println("No policies found for this coverage type");
                    } else {
                        System.out.println("Policies with " + type + " coverage:");
                        for (InsurancePolicy p : byType) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter policy number to check:");
                    String policyNum = sc.nextLine();
                    LocalDate dummyDate = LocalDate.now();
                    InsurancePolicy dummyPolicy = new InsurancePolicy(policyNum, "", dummyDate, "", 0);
                    if (system.hasDuplicate(dummyPolicy)) {
                        System.out.println("Policy exists");
                    } else {
                        System.out.println("Policy does not exist");
                    }
                    break;
                case 7:
                    system.performanceComparison();
                    break;
                case 8:
                    System.out.println("Enter policy number:");
                    String newPolicyNum = sc.nextLine();
                    System.out.println("Enter policyholder name:");
                    String holder = sc.nextLine();
                    System.out.println("Enter expiry date (YYYY-MM-DD):");
                    LocalDate expiryDate = LocalDate.parse(sc.nextLine());
                    System.out.println("Enter coverage type:");
                    String coverage = sc.nextLine();
                    System.out.println("Enter premium:");
                    double premium = sc.nextDouble();
                    
                    system.addPolicy(new InsurancePolicy(newPolicyNum, holder, expiryDate, coverage, premium));
                    System.out.println("Policy added");
                    break;
                case 9:
                    running = false;
                    break;
            }
        }
        
        sc.close();
    }
}
