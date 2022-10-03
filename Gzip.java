package Assignment1;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Gzip {
    
    public static void main(String args[]){

        ExecutorService service = Executors.newCachedThreadPool();
        
        for(int i=0; i<args.length; i++){
            File directory = new File(args[i]);
            File[] files = directory.listFiles();
            for(int j=0; j<files.length; j++){
                if(!(files[j].isDirectory())){
                    if((!(files[j].getName().contains(".zip"))) ){
                        service.execute(new Task(files[j]));
                    }
                }
            }
        }
        service.shutdown();                                                                     
    }
}
