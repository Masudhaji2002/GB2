//Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
//Требуется перехватить все возможные ошибки и вывести их в логгер.
//
//После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task0 {
  private static final Logger LOGGER = Logger.getLogger(Task0.class.getName());
  private static final String FILE_NAME = "result.txt";
  private static final String LOG_FILE_NAME = "log.txt";
  private static final int BYTE_MAX_VALUE = 127;

  public static void main(String[] args) {
    try {
      FileHandler handler = new FileHandler(LOG_FILE_NAME, true);
      handler.setFormatter(new SimpleFormatter());
      LOGGER.addHandler(handler);

      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a number in byte format: ");
      int number = scanner.nextInt();

      if (number > BYTE_MAX_VALUE) {
        LOGGER.log(Level.WARNING, "The entered number is greater than the maximum value that can be stored in a byte.");
        System.out.println("The entered number is greater than the maximum value that can be stored in a byte.");
        return;
      }

      byte byteNumber = (byte) number;
      File file = new File(FILE_NAME);
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(byteNumber);
      fos.close();

      System.out.println("The number was successfully written to the file " + FILE_NAME);
    } catch (IOException ex) {
      LOGGER.log(Level.SEVERE, ex.toString(), ex);
    } catch (NumberFormatException ex) {
      LOGGER.log(Level.WARNING, "The entered value is not a valid number.");
      System.out.println("The entered value is not a valid number.");
    }
  }

  public String findJewelsInStones(String jewels, String stones) {
    return "";
  }
}
