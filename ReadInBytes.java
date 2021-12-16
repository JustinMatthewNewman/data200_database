import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadInBytes
{
  public static void main(String[] args)
  {
    String filePath = args[0];
    
    readAllBytes( filePath ) ;
    
  }
  
  //Read file content into string with - Files.readAllBytes(Path path)
  
  private static String readAllBytes(String filePath) 
  {
      String content = "";

      try
      {
          int c = 0;
          int a = 0;
          PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(
              "/Users/justinnewman/Desktop/" + "file_0" + ".csv")), true);
          Scanner in = new Scanner(new File(filePath));
          in.useDelimiter("\n");
          while(in.hasNext()) {
            c++;
            String i = in.next().replace(" ", "_");
            
            System.setOut(out);
            
            System.out.println(i);
            if (c % 262677 == 0) {
              a++;
              out = new PrintStream(new BufferedOutputStream(new FileOutputStream(
                  "/Users/justinnewman/Desktop/" + "file_" + a + ".csv")), true);
              System.out.println("Severity,Start_Time,End_Time,Start_Lat,Start_Lng,End_Lat,End_Lng");
              c = 0;
            }
          }
          
          
          
      } 
      catch (IOException e) 
      {
          e.printStackTrace();
      }

      return content;
  }
}
