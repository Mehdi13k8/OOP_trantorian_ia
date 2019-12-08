import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.*;

//public
class mainclass {
    static String name = mainclass.class.getName();
    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.print("Usage: ./");
            System.out.print(name);
            System.err.println(" host port team number_of_clients");
            System.exit(84);
        }
        try{
            int i = Integer.parseInt(args[1]);
            System.out.println("int i = " + i);
            }
            catch (NumberFormatException nfe)
            {
            System.out.println(args[1] + " is false you did a NumberFormatException: " + nfe.getMessage());
            System.exit(84);
        }
        try{
            int i = Integer.parseInt(args[3]);
            System.out.println("int i = " + i);
            }
            catch (NumberFormatException nfe)
            {
            System.out.println(args[3] + " is false you did a NumberFormatException: " + nfe.getMessage());
            System.exit(84);
        }
        //AI nw_ai = new AI(args[0], Integer.valueOf(args[1]), args[2], Integer.valueOf(args[3]));
        //nw_ai.start();
        //ArrayList<AI> listai = new ArrayList<AI>();
        //int x = 0;
        /*while (x != Integer.parseInt(args[3])) {
            listai.add(new AI(args[0], Integer.valueOf(args[1]), args[2], Integer.valueOf(args[3])));
            x++;
        }*/ 
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try{
            for (int i=0; i < Integer.parseInt(args[3]); i++){
                AI stk = new AI(args[0], Integer.valueOf(args[1]), args[2], Integer.valueOf(args[3]), executor);
                if (i == 0)
                    stk.IMBOSS = true;
                executor.execute(stk);
            }
        }catch(Exception err){
            err.printStackTrace();
        }
        executor.shutdown();
    }
}
