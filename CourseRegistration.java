
import java.util.*;
class CourseRegistration {
    static Map<String, List<String>> prereqGraph = new HashMap<>();
    static void addPrereq(String course, String prereq) {
        prereqGraph.computeIfAbsent(course, k -> new ArrayList<>()).add(prereq);
    }
    static boolean hasCompleted(String course, Set<String> completed, Set<String> visited) {
        if (completed.contains(course)) return true;
        if (visited.contains(course)) return false;
        visited.add(course);
        for (String pre : prereqGraph.getOrDefault(course, new ArrayList<>()))
            if (!hasCompleted(pre, completed, visited)) return false;
        return true;
    }
    static void allocateSeats(String[] students, double[] cgpa, int seats) {
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> Double.compare(cgpa[b], cgpa[a]));
        for (int i = 0; i < students.length; i++) maxHeap.offer(i);
        System.out.println("Seats Allocated:");
        int count = 0;
        while (!maxHeap.isEmpty() && count < seats)
            System.out.println("  " + students[maxHeap.poll()] + " CGPA:" + cgpa[count++]);
        System.out.println("Wait-listed:");
        while (!maxHeap.isEmpty()) System.out.println("  " + students[maxHeap.poll()]);
    }
    public static void main(String[] args) {
        addPrereq("DataStructures", "ProgrammingBasics");
        addPrereq("Algorithms", "DataStructures");
        addPrereq("MachineLearning", "Algorithms");
        Set<String> done = new HashSet<>(Arrays.asList("ProgrammingBasics","DataStructures","Statistics"));
        System.out.println("Register Algorithms: " + hasCompleted("Algorithms", done, new HashSet<>()));
        System.out.println("Register ML: " + hasCompleted("MachineLearning", done, new HashSet<>()));
        String[] students = {"Alice","Bob","Carol","Dave","Eve"};
        double[] cgpa = {9.2, 8.7, 9.5, 7.8, 9.1};
        allocateSeats(students, cgpa, 3);
    }
}
//CO6 CODE
