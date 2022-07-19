package ca.ciccc.assignment4.question5;

import java.util.ArrayList;
import java.util.HashMap;

public class Question5 {
    public void invoke() {
        ArrayList<HashMap<Character, Integer>> points = new ArrayList<>();
        points.add(getPoint(1,2,4));
        points.add(getPoint(1,2,3));
        points.add(getPoint(1,4,4));

        HashMap<Character, Integer> closesPoints = points.get(0);
        double minDistance = getDistance(points.get(0), getCenterPoint());
        for(int i = 0; i < points.size(); i++) {
            double distance = getDistance(points.get(i), getCenterPoint());
            if(distance < minDistance) {
                minDistance = distance;
            }
        }
        System.out.println("The closest points is: ");
        System.out.println(closesPoints);
    }
    public HashMap<Character, Integer> getCenterPoint() {
        HashMap<Character, Integer> center = new HashMap<>();
        center.put('x', 0);
        center.put('y', 0);
        center.put('z', 0);
        return center;
    }
    public double getDistance(HashMap<Character, Integer> p1, HashMap<Character, Integer> p2) {
        double sqrt;
        sqrt = Math.sqrt(
                Math.pow(p1.get('x') - p2.get('x'), 2) + Math.pow(p1.get('y') - p2.get('y'), 2) + Math.pow(p1.get('z') - p1.get('z'), 2)
        );
        return sqrt;
    }
    public HashMap<Character, Integer> getPoint(int x, int y, int z) {
        HashMap<Character, Integer> point = new HashMap<>();
        point.put('x', x);
        point.put('y', y);
        point.put('z', z);
        return point;
    }
}
