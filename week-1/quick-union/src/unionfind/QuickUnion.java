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
 * given two objects p & q this DS technique will connected
 * if they have common root (parent) If not it will
 * replace the parent of p from that of q
 */
public class QuickUnion {
    int[] arr;
    int n;

    int pRoot;
    int qRoot;

    /**
     * Constructor for {@link QuickUnion}
     *
     * @param n number of objects
     */
    public QuickUnion(int n) {
        this.n = n;
        arr = new int[this.n];
        // n Array access - set id of each object to itself
        for (int i = 0; i < this.n; i++) {
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
     * <b>connected</b> method to check if two objects are connected
     * by backtracking their parent and find if they are similar
     *
     * @param p 1st object
     * @param q 2nd object
     * @return {@link Boolean} true if objects are connected and false if not.
     */

    boolean connected(int p, int q) {
        //TODO : need to check this assumption
        //worst case n*n access
        return root(p) == root(q);
    }

    void union(int p, int q) {
        // 1 array access
        pRoot = root(p);
        qRoot = root(q);
        arr[p] = qRoot;
    }

    /**
     * <b>showItems</b> method to show objets with their indexes
     */
    void showItems() {
        System.out.println("\nObject state\n");
        for (int i = 0; i < n; i++) {
            System.out.print("|" + arr[i]);
        }
        System.out.print("|\n");
        for (int i = 0; i < n; i++) {
            System.out.print("|" + i);
        }
        System.out.print("|");
    }
}
