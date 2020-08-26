package assgn3;

import java.util.*;;

class Pair implements Comparable<Pair>{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + " y = " + y;
    }

    @Override
    public int compareTo(Pair other) {
        double thisDistance = Math.pow(x, 2) + Math.pow(y, 2);
        double otherDistance = Math.pow(other.x, 2) + Math.pow(other.y, 2);
        if (thisDistance == otherDistance) {
            return x > other.x ? 1 : -1;
        } else {
            return thisDistance > otherDistance ? 1 : -1;
        }
    }
}

class Entry{
    int x;
    int y;

    public Entry(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + " y = " + y;
    }
}

//class MyComparator implements Comparator<Entry> {
//
//    @Override
//    public int compare(Entry o1, Entry o2) {
//        return 1;
//    }
//
//}

public class PQdemo {
    public static void main(String[] a) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(1,3));
        pq.offer(new Pair(3,1));
        pq.offer(new Pair(2,2));
        pq.offer(new Pair(2,3));
        pq.offer(new Pair(4,1));

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        Pair[] pairs = new Pair[] {new Pair(1,3), new Pair(2,2), new Pair(1,2), new Pair(3,1)};
        Arrays.sort(pairs);
        for (Pair pair : pairs) {
            System.out.println(pair);
        }

        List<Pair> list = new ArrayList<>();
        list.add(new Pair(1,2));
        list.add(new Pair(2,2));
        list.add(new Pair(3,2));
        list.add(new Pair(1,3));
        Collections.sort(list);
        for (Pair pair : list) {
            System.out.println(pair);
        }


        PriorityQueue<Entry> pq2 = new PriorityQueue<>(10, new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                double o1Distance = Math.pow(o1.x, 2) + Math.pow(o1.y, 2);
                double o2Distance = Math.pow(o2.x, 2) + Math.pow(o2.y, 2);
                if (o1Distance == o2Distance) {
                    return o1.x > o2.x ? 1 : -1;
                } else {
                    return o1Distance > o2Distance ? 1 : -1;
                }
            }
        });
        pq2.offer(new Entry(1,3));
        pq2.offer(new Entry(3,1));
        pq2.offer(new Entry(2,2));
        pq2.offer(new Entry(2,2));
        pq2.offer(new Entry(2,3));
        pq2.offer(new Entry(4,1));

        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());


        Entry[] entries = new Entry[] {new Entry(1,3), new Entry(2,2), new Entry(1,2), new Entry(3,1)};
        Arrays.sort(entries, new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                double thisDistance = Math.pow(o1.x, 2) + Math.pow(o1.y, 2);
                double otherDistance = Math.pow(o2.x, 2) + Math.pow(o2.y, 2);
                if (thisDistance == otherDistance) {
                    return o1.x > o2.x ? 1 : -1;
                } else {
                    return thisDistance > otherDistance ? 1 : -1;
                }
            }
        });
        for (Entry entry : entries) {
            System.out.println(entry);
        }
    }
}