import java.util.*;
import java.io.*;
public class Radix {

     public static int nth (int n, int col) {
          return (int)(n/Math.pow(10, col)) % 10;
     }

     public static int length (int n) {
          if (n==0) return 1;
          return (int) Math.log10(Math.abs(n)) + 1;
     }

     public static void merge (SortableLinkedList original, SortableLinkedList[] buckets) {
          for (int i = 0; i < buckets.length; i++) {
               original.extend(buckets[i]);
          }
     }

     public static void radixSortSimple(SortableLinkedList data) {
          int passes = 0;
          SortableLinkedList buckets[] = new SortableLinkedList[10];
          for (int i = 0; i < 10; i++) buckets[i] = new SortableLinkedList();
          int s = data.size();
          int k;
          while (s-->0) {
               passes = Math.max(passes, data.get(0));
               data.add(data.remove(0));
          }
          passes = length(passes);
          for (int digit = 0; digit < passes; digit++) {
               s = data.size();
               while (s-->0) {
                    k = data.remove(0);
                    buckets[nth(k, digit)].add(k);
               }
               merge(data, buckets);
          }
     }

     public static void radixSort(SortableLinkedList data) {
          int passes = 0;
          SortableLinkedList buckets[] = new SortableLinkedList[19];
          for (int i = 0; i < 19; i++) buckets[i] = new SortableLinkedList();
          int s = data.size();
          int k;
          while (s-->0) {
               passes = Math.max(passes, Math.abs(data.get(0)));
               data.add(data.remove(0));
          }
          passes = length(passes);
          for (int digit = 0; digit < passes; digit++) {
               s = data.size();
               while (s-->0) {
                    k = data.remove(0);
                    buckets[nth(k, digit)+9].add(k);
               }
               merge(data, buckets);
          }
     }

}
