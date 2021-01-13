import java.util.*;
import java.io.*;
public class Tester {
     public static boolean equal (SortableLinkedList l, ArrayList<Integer> al) {
          int i = 0;
          while (l.size()>0) {
               int c = l.remove(0);
               if (c != al.get(i)) return false;
               i++;
          }
          return i==al.size();
     }
     public static boolean equal (SortableLinkedList l, int[] ar) {
          int i = 0;
          while (l.size()>0) {
               int c = l.remove(0);
               if (c != ar[i]) return false;
               i++;
          }
          return i==ar.length;
     }
     public static void main(String[] args) {
          int numtest;
          if (args.length>0) numtest=Integer.parseInt(args[0]);
          else numtest=1000;
          boolean works = true;
          System.out.println("Preliminary radixSortSimple testing...");
          Random rng = new Random(0);
          SortableLinkedList l = new SortableLinkedList();
          int ar[] = new int[1000];
          int c;
          for (int i = 0; i < 1000; i++) {
               c = rng.nextInt() % 1000;
               if (c < 1000) c += 1000;
               l.add(c);
               ar[i]=c;
          }
          Radix.radixSortSimple(l);
          Arrays.sort(ar);
          if (equal(l, ar)) System.out.println("Passed first radixSortSimple test!");
          else {System.out.println("Fails at seed 0! Do more testing."); works=false;}
          if (works) System.out.println("Starting thorough testing of radixSortSimple! This uses " + numtest + " random seeds, so sit tight...");
          int s;
          for (int seed = 1; works && seed <= numtest; seed++) {
               if (seed % 100==0) System.out.print("test " + seed);
               rng = new Random(seed);
               s = rng.nextInt() % 100001;
               if (s<0) s += 100001;
               l = new SortableLinkedList();
               ar = new int[s];
               for (int i = 0; i < s; i++) {
                    c = rng.nextInt() % 10000;
                    if (c < 10000) c += 10000;
                    l.add(c);
                    ar[i]=c;
               }
               Radix.radixSortSimple(l);
               Arrays.sort(ar);
               if (equal(l, ar)) System.out.print("_");
               else {System.out.println("\nFails at seed " + seed + "! Do more testing."); works=false;}
          }
          if (works) System.out.println("\nCongratulations! Your simple radix sort works!");
          System.out.println("Preliminary radixSort testing...");
          rng = new Random(0);
          l = new SortableLinkedList();
          ar = new int[1000];
          for (int i = 0; i < 1000; i++) {
               c = rng.nextInt();
               l.add(c);
               ar[i]=c;
          }
          Radix.radixSort(l);
          Arrays.sort(ar);
          if (equal(l, ar)) System.out.println("Passed first radixSort test!");
          else {System.out.println("Fails at seed 0! Do more testing."); works=false;}
          if (works) System.out.println("Starting thorough testing of radixSort! This uses " + numtest + " random seeds, so sit tight...");
          for (int seed = 1; works && seed <= numtest; seed++) {
               if (seed % 100==0) System.out.print("test " + seed);
               rng = new Random(seed);
               s = rng.nextInt() % 100001;
               if (s<0) s += 100001;
               l = new SortableLinkedList();
               ar = new int[s];
               for (int i = 0; i < s; i++) {
                    c = rng.nextInt();
                    l.add(c);
                    ar[i]=c;
               }
               Radix.radixSort(l);
               Arrays.sort(ar);
               if (equal(l, ar)) System.out.print("_");
               else {System.out.println("\nFails at seed " + seed + "! Do more testing."); works=false;}
          }
          if (works) System.out.println("\nCongratulations! Both sorts work!");
     }
}
