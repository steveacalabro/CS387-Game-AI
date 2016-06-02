package mapGeneration;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge e1, Edge e2) {
        return Integer.compare(e1.getWeight(), e2.getWeight());
    }
}
