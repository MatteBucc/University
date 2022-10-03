package Assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;

public class Task implements Runnable {

    private File file;

    public Task(File file){this.file = file;}

    public void run(){
        Path source = Paths.get(file.getAbsolutePath());
        Path target = Paths.get(file.getAbsolutePath()+".zip");
        try {
            compressGzip(source, target);
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void compressGzip(Path source, Path target) throws IOException {

        try (GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(target.toFile()));
             FileInputStream fis = new FileInputStream(source.toFile())) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    gos.write(buffer, 0, len);
                }
        }   
    }
}
