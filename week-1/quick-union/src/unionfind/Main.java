package unionfind;

import java.util.Scanner;

/**
 * @author Rajan Chauhan
 * @version 1.0
 * @since 28/08/2023
 * <p>client class to test {@link QuickUnion}</p>
 */
public class Main {
    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(5);
        //first check if all objects are connected in array if not ask for objets to connect
        while (!isAllConnected(quickUnion)) {
            System.out.println("\n\nObjects not fully connected to \nenter number to check if they are connected\n" +
                    "if not then it will get connected using union\n");

            int p;
            int q;

            Scanner sc = new Scanner(System.in);

            System.out.println("enter value of p.");
            p = sc.nextInt();
            System.out.println("enter value of q.");
            q = sc.nextInt();

            //check if supplied numbers falls under the range
            if (isObjectValid(p, q, quickUnion)) {
                System.out.printf("finding if %s and %s are connected objects.%n%n", p, q);

                if (quickUnion.findRootAndIfNotSameThenConnectObjects(p, q)) {
                    System.out.printf("%s and %s are connected objects", p, q);
                }
                quickUnion.showItems();
            } else {
                System.out.printf("please check if %s OR %s are valid objects. Objects should be less then %s ", p, q, quickUnion.numberOfObjects);
            }
        }
        System.out.println("CONGRATULATION ! ALL OBJECTS CONNECTED...");

    }

    public static boolean isObjectValid(int p, int q, QuickUnion quickUnion) {
        return p < quickUnion.numberOfObjects && q < quickUnion.numberOfObjects;
    }

    public static boolean isAllConnected(QuickUnion quickUnion) {
        boolean result = true;
        int connectingIndex = quickUnion.arr[0];
        for (int i = 1; i < quickUnion.numberOfObjects; i++) {
            if (quickUnion.arr[i] != connectingIndex) {
                result = false;
                break;
            }
        }
        return result;
    }
}