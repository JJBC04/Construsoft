package CopiaSeguridad;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author jjbue
 */
public class Backup {
   public  void copiaSeguridad() {
   try {
      Process p = Runtime
            .getRuntime()
            .exec("D:\\xampp\\mysql\\bin\\mysqldump -u root -p password database");

      InputStream is = p.getInputStream();
      FileOutputStream fos = new FileOutputStream("backup_Construsoft.sql");
      byte[] buffer = new byte[1000];

      int leido = is.read(buffer);
      while (leido > 0) {
         fos.write(buffer, 0, leido);
         leido = is.read(buffer);
      }

      fos.close();

   } catch (Exception e) {
      e.printStackTrace();
   }
} 
}
