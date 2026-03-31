import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

class Policy {
    private String policyNumber;
    private String policyholder;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    
    public Policy(String policyNumber, String policyholder, LocalDate expiryDate, 
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

public class InsurancePolicyManagementMap {
    private HashMap<String, Policy> hashMapPolicies;
    private LinkedHashMap<String, Policy> linkedMapPolicies;
    private TreeMap<LocalDate, Policy> treeMapPolicies;
    
    public InsurancePolicyManagementMap() {
        this.hashMapPolicies = new HashMap<>();
        this.linkedMapPolicies = new LinkedHashMap<>();
        this.treeMapPolicies = new TreeMap<>();
    }
    
    public void addPolicy(Policy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }
    
    public Policy retrievePolicy(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }
    
    public List<Policy> getPoliciesExpiringIn30Days() {
        List<Policy> expiringPolicies = new ArrayList<>();
        for (Policy policy : hashMapPolicies.values()) {
            if (policy.expiresWithin30Days()) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }
    
    public List<Policy> getPoliciesForPolicyholder(String policyholder) {
        List<Policy> results = new ArrayList<>();
        for (Policy policy : hashMapPolicies.values()) {
            if (policy.getPolicyholder().equalsIgnoreCase(policyholder)) {
                results.add(policy);
            }
        }
        return results;
    }
    
    public void removeExpiredPolicies() {
        List<String> keysToRemove = new ArrayList<>();
        for (Map.Entry<String, Policy> entry : hashMapPolicies.entrySet()) {
            if (entry.getValue().isExpired()) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (String key : keysToRemove) {
            hashMapPolicies.remove(key);
            linkedMapPolicies.remove(key);
        }
    }
    
    public void displayAllPolicies() {
        System.out.println("All Policies (HashMap):");
        for (Policy policy : hashMapPolicies.values()) {
            System.out.println(policy);
        }
    }
    
    public void displayLinkedMapPolicies() {
        System.out.println("Policies in Insertion Order (LinkedHashMap):");
        for (Policy policy : linkedMapPolicies.values()) {
            System.out.println(policy);
        }
    }
    
    public void displayTreeMapPolicies() {
        System.out.println("Policies Sorted by Expiry Date (TreeMap):");
        for (Policy policy : treeMapPolicies.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InsurancePolicyManagementMap system = new InsurancePolicyManagementMap();
        
        LocalDate today = LocalDate.now();
        system.addPolicy(new Policy("P001", "John Doe", today.plusDays(15), "Health", 5000));
        system.addPolicy(new Policy("P002", "Jane Smith", today.plusDays(45), "Auto", 3000));
        system.addPolicy(new Policy("P003", "John Doe", today.plusDays(25), "Home", 8000));
        system.addPolicy(new Policy("P004", "Mike Johnson", today.minusDays(10), "Health", 4500));
        system.addPolicy(new Policy("P005", "Sarah Williams", today.plusDays(5), "Auto", 3500));
        
        boolean running = true;
        while (running) {
            System.out.println("=== Insurance Policy Management System ===");
            System.out.println("1. Display all policies");
            System.out.println("2. Display policies in insertion order");
            System.out.println("3. Display policies sorted by expiry date");
            System.out.println("4. Retrieve policy by number");
            System.out.println("5. Get policies expiring in 30 days");
            System.out.println("6. Get policies for specific policyholder");
            System.out.println("7. Remove expired policies");
            System.out.println("8. Add new policy");
            System.out.println("9. Exit");
            System.out.println("Enter choice:");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    system.displayAllPolicies();
                    break;
                case 2:
                    system.displayLinkedMapPolicies();
                    break;
                case 3:
                    system.displayTreeMapPolicies();
                    break;
                case 4:
                    System.out.println("Enter policy number:");
                    String policyNum = sc.nextLine();
                    Policy policy = system.retrievePolicy(policyNum);
                    if (policy != null) {
                        System.out.println(policy);
                    } else {
                        System.out.println("Policy not found");
                    }
                    break;
                case 5:
                    List<Policy> expiring = system.getPoliciesExpiringIn30Days();
                    if (expiring.isEmpty()) {
                        System.out.println("No policies expiring within 30 days");
                    } else {
                        System.out.println("Policies expiring in 30 days:");
                        for (Policy p : expiring) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter policyholder name:");
                    String holder = sc.nextLine();
                    List<Policy> holderPolicies = system.getPoliciesForPolicyholder(holder);
                    if (holderPolicies.isEmpty()) {
                        System.out.println("No policies found for this policyholder");
                    } else {
                        System.out.println("Policies for " + holder + ":");
                        for (Policy p : holderPolicies) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 7:
                    system.removeExpiredPolicies();
                    System.out.println("Expired policies removed");
                    break;
                case 8:
                    System.out.println("Enter policy number:");
                    String newPolicyNum = sc.nextLine();
                    System.out.println("Enter policyholder name:");
                    String newHolder = sc.nextLine();
                    System.out.println("Enter expiry date (YYYY-MM-DD):");
                    LocalDate expiryDate = LocalDate.parse(sc.nextLine());
                    System.out.println("Enter coverage type:");
                    String coverage = sc.nextLine();
                    System.out.println("Enter premium amount:");
                    double premium = sc.nextDouble();
                    
                    Policy newPolicy = new Policy(newPolicyNum, newHolder, expiryDate, coverage, premium);
                    system.addPolicy(newPolicy);
                    System.out.println("Policy added successfully");
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        
        sc.close();
    }
}
