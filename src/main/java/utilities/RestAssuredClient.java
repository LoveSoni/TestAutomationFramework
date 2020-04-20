package utilities;

import java.util.Comparator;
import java.util.TreeSet;

public class RestClient implements Comparator {

    public int compare(Object obj1,Object obj2){
       String i = (String)obj1;
       String i2 = (String)obj2;
       return -i.compareTo(i2);
    }
  public static void main(String args[]){
      TreeSet treeSet = new TreeSet(new RestClient());
      treeSet.add("hii");
      treeSet.add("asdb");
      treeSet.add("demo");
      treeSet.add("slash");
      treeSet.add("peek");
      System.out.print(treeSet);
      System.out.print(System.getProperty("define"));
  }
}

