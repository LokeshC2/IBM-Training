package Sysargs;
import java.util.Properties;

public class Test {
  public static void main(String[] args) {
    for (String arg : args) System.out.println(arg);
    Properties props = System.getProperties();
    props.list(System.out);
  }
}
