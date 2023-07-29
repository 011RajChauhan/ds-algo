package unionfind;

/**
 * @author Rajan Chauhan
 * @version 1.0
 * @since 28/07/2023</p>
 * <b><i>{@link QuickUnion} </i></b>QuickUnion algorithm class will implement an array based
 * data structure that will have n number of objects, index of the array
 * will mimic as object whereas the actual value will mimic as index.
 * values will be equalized to connect all the objects.
 * <p>
 * given two objects p & q this DS technique will findRootAndIfNotSameThenConnectObjects
 * if they have common root (parent) If not it will
 * replace the parent of p from that of q
 */
public class QuickUnion {
    int[] arr;
    int numberOfObjects;

    int pRoot;
    int qRoot;

    /**
     * Constructor for {@link QuickUnion}
     *
     * @param n number of objects
     */
    public QuickUnion(int n) {
        numberOfObjects = n;
        arr = new int[numberOfObjects];
        // n Array access - set id of each object to itself
        for (int i = 0; i < numberOfObjects; i++) {
            arr[i] = i;
        }
        showItems();
    }

    /**
     * method <b>root</b>
     *
     * @param num object who's root needs to be found
     * @return {@link Integer} root value
     */
    public int root(int num) {
        while (arr[num] != num) {
            num = arr[num];
            root(num);
        }
        return num;
    }

    /**
     * <b>findRootAndIfNotSameThenConnectObjects</b> method to check if two objects are connected
     *
     * @param p 1st object
     * @param q 2nd object
     * @return {@link Boolean} true if objects are connected and false if not.
     */
    boolean findRootAndIfNotSameThenConnectObjects(int p, int q) {
        boolean findResult = false;
        try {
            //todo : need to check this assumption
            //worst case n*n access
            if (root(p) == root(q)) {
                findResult = true;
            } else {
                union(p, q);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("list does not contain the supplied objects");
        }
        return findResult;
    }

    void union(int p, int q) {
        System.out.println("%s and $s were not connect, now connected.");
        // 1 array access
        arr[p] = qRoot;
    }

    /**
     * <b>showItems</b> method to show objets with their indexes
     */
    void showItems() {
        System.out.println("\nObject state\n");
        for (int i = 0; i < numberOfObjects; i++) {
            System.out.print("|" + arr[i]);
        }
        System.out.print("|\n");
        for (int i = 0; i < numberOfObjects; i++) {
            System.out.print("|" + i);
        }
        System.out.print("|");
    }
}
