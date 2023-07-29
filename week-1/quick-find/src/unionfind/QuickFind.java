package unionfind;

/**
 * @author Rajan Chauhan
 * @version 1.0
 * @since 28/07/2023</p>
 * <b><i>{@link QuickFind} </i></b>QuickFind algorithm class will implement an array based
 * data structure that will have n number of objects, index of the array
 * will mimic as object whereas the actual value will mimic as index.
 * values will be equalized to connect all the objects.
 */
public class QuickFind {
    int[] arr;
    int numberOfObjects;

    int pIndex;
    int qIndex;

    /**
     * Constructor for {@link QuickFind}
     *
     * @param n number of objects
     */
    public QuickFind(int n) {
        numberOfObjects = n;
        arr = new int[numberOfObjects];
        // n Array access - set id of each object to itself
        for (int i = 0; i < numberOfObjects; i++) {
            arr[i] = i;
        }
        showItems();
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

    /**
     * <b>find</b> method to check if two objects are connected
     *
     * @param p 1st object
     * @param q 2nd object
     * @return {@link Boolean} true if objects are connected and false if not.
     */
    boolean find(int p, int q) {
        boolean findResult = false;
        try {
            //2 array access but constant
            pIndex = arr[p];
            qIndex = arr[q];

            findResult = pIndex == qIndex;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("list does not contain the supplied objects");
        }
        return findResult;
    }

    void union(int p, int q) {
        // 2N array access
        for (int i = 0; i < numberOfObjects; i++) {
            if (arr[i] == qIndex) {
                arr[i] = pIndex;
            }
        }
    }
}
