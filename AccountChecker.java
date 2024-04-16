import java.util.Scanner;

public class AccountChecker {
  public static boolean search(int[] validNums, int userInp) {
      for (int i = 0; i < validNums.length; i++) {
          if (validNums[i] == userInp) {
              return true;
          }
      }
      return false;
  }

    public static void main(String[] args) {
        int[] validNums = {
            5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
            8080152, 4562555, 5552012, 5050552, 7825877, 1250255,
            1005231, 6545231, 3852085, 7576651, 7881200, 4581002
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a valid charge account number: ");
        int userNum = scanner.nextInt();

        if (search(validNums, userNum)) {
            System.out.println("The number you put is valid.");
        } else {
            System.out.println("The number you put is invalid.");
        }
    }
}
