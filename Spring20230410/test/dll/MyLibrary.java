package dll;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface MyLibrary extends Library {
  MyLibrary INSTANCE = Native.load("C:\\Users\\student\\eclipse-workspace-spring\\Spring20230410\\test\\dll\\Dll1", MyLibrary.class);
  int getFive();
  int add_int(int a, int b);
  double add_double(double a, double b);
}
