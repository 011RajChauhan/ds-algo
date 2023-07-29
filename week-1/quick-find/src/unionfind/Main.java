package unionfind;

import java.util.Scanner;

/**
 * @author Rajan Chauhan
 * @version 1.0
 * @since 28/08/2023
 * <p>client class to test {@link QuickFind}</p>
 */
public class Main {
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(5);
        //first check if all objects are connected in array if not ask for objets to connect
        while (!isAllConnected(quickFind)) {
            System.out.println("\n\nObjects not fully connected to \nenter number to check if they are connected\n" +
                    "if not then it will get connected using union\n");

            int p, q;

            Scanner sc = new Scanner(System.in);

            System.out.println("enter value of p.");
            p = sc.nextInt();
            System.out.println("enter value of q.");
            q = sc.nextInt();

            //check if supplied numbers falls under the range
            if (isObjectValid(p, q, quickFind)) {
                System.out.printf("finding if %s and %s are connected objects.%n%n", p, q);

                if (quickFind.find(p, q)) {
                    System.out.printf("%s and %s are connected objects", p, q);
                } else {
                    System.out.printf("connecting objects %s and %s", p, q);
                    quickFind.union(p, q);
                }
                quickFind.showItems();
            } else {
                System.out.printf("please check if %s OR %s are valid objects. Objects should be less then %s ", p, q, quickFind.numberOfObjects);
            }
        }
        System.out.println("CONGRATULATION ! ALL OBJECTS CONNECTED...");

    }

    public static boolean isObjectValid(int p, int q, QuickFind quickFind) {
        return p < quickFind.numberOfObjects && q < quickFind.numberOfObjects;
    }

    public static boolean isAllConnected(QuickFind quickFind) {
        boolean result = true;
        int connectingIndex = quickFind.arr[0];
        for (int i = 1; i < quickFind.numberOfObjects; i++) {
            if (quickFind.arr[i] != connectingIndex) {
                result = false;
                break;
            }
        }
        return result;
    }
}