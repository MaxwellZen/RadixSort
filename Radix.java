import java.util.*;
import java.io.*;
public class Radix {

     public static int nth (int n, int col) {
          int ans = (int)(n/Math.pow(10, col)) % 10;
          return ans;
     }

     public static int length (int n) {
          return (int) Math.log10(Math.abs(n)) + 1;
     }

     public static void merge (SortableLinkedList original, SortableLinkedList[] buckets) {
          for (int i = 0; i < buckets.length; i++) {
               original.extend(buckets[i]);
          }
     }

     public static void radixSortSimple(SortableLinkedList data) {
          boolean cont = true;
          int digit = 0;
          SortableLinkedList buckets[] = new SortableLinkedList[10];
          for (int i = 0; i < 10; i++) {
               buckets[i] = new SortableLinkedList();
          }
          int c, bucket;
          while (cont) {
               cont = false;
               while (data.size()>0) {
                    c = data.remove(0);
                    buckets[nth(c, digit)].add(c);
                    if (length(c) > digit+1) cont=true;
               }
               merge(data, buckets);
               digit++;
          }
     }

     public static void radixSort(SortableLinkedList data) {
          boolean cont = true;
          int digit = 0;
          SortableLinkedList buckets[] = new SortableLinkedList[19];
          for (int i = 0; i < 19; i++) {
               buckets[i] = new SortableLinkedList();
          }
          int c, bucket;
          while (cont) {
               cont = false;
               while (data.size()>0) {
                    c = data.remove(0);
                    buckets[nth(c, digit)+9].add(c);
                    if (length(c) > digit+1) cont=true;
               }
               merge(data, buckets);
               digit++;
          }
     }

}
