import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.*;

public class AI implements Runnable {
    protected String _team = "";
    protected int _nb_client = 0;
    protected Socket sock;
    protected BufferedReader in;
    protected PrintWriter out;
    protected int _food = 10;
    protected int _port = 0;
    protected String _host = "";
    protected ExecutorService executor;
    public boolean IMBOSS = false;
    protected int ready = 0;
    
    public AI(String host, int port, String team, int nb_client, ExecutorService executor) {
        _team = team;
        _nb_client = nb_client;
        _port = port;
        this.executor = executor;
        if (_nb_client > 0) {
    //        final Socket client;
    //       ServerSocket serverSocket = null;
    //        int inteam = 0;
    //        int lvl = 1;
        } 
    }

    public void start() {
        try { 
            sock = new Socket(_host, _port);
            out = new PrintWriter(sock.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    /**/    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            String userinpt;
            userinpt = this._team;
            out.println(userinpt);
            userinpt = "";
            userinpt = in.readLine();
            userinpt = in.readLine();
            userinpt = in.readLine();
            String end = "";
    /**/    while (true) {// algo dans la boucle userinpt = stdin.readLine()) != null
                if (IMBOSS == true) {
                    int randm = (int)Math.random()*(0-2);
                    if (randm == 2)
                    out.println("broadcast Respect your padre! Madremia");
                    out.println("take food");
                    //out.println("broadcast i'mthere");
                    out.println("Incantation");
                    end = in.readLine();
                    if (end.length() > 17+9 && end.substring(17,9).equals("i'mready:"))
                        System.out.println("I'm there");
                    System.out.println("echo: master" + end);
                    if (!end.equals(""))
                    if (end.equals("dead")) {
                        System.out.println("dead bro");
                        break;
                    }
                    String parse = "";
                    int idx = 0;
                    while (idx < end.length() && end.charAt(idx) != ' ') {
                        idx++;
                    }
                    while (idx < end.length() && end.charAt(idx) != ':') {
                        parse += Character.toString(end.charAt(idx));
                        idx++;
                    }
                    idx = 0;
            //i'mready:
                /*out.println("Incantation");
            String sstr = in.readLine();
                    int ii = 0;
                    while (ii < sstr.length() && sstr.charAt(ii) != ':') {
                        ii++;
                    }
                    String strnb = "0";
                    
                    while (sstr.length() < ii) {
                        if (strnb.equals("0"))
                            strnb = "";
                        strnb += sstr.charAt(ii);
                        ii++;
                    }
                    String removespace = sstr.replaceAll("\\s","");
                    int readi = 0;
                    //readi = Integer.valueOf(removespace);
                    System.out.println(readi + " <- lvl");*/
                }
                else {
                    //out.println("take food");
                    //out.println("broadcast i'mthere");
                end = in.readLine();
                String parse = "";
                int idx = 0;
                while (idx < end.length() && end.charAt(idx) != ' ') {
                    idx++;
                }
                while (idx < end.length() && end.charAt(idx) != ',') {
                    parse += Character.toString(end.charAt(idx));
                    idx++;
                }
                idx = 0;
                int message = 0;
                String spaceremove = parse.replaceAll("\\s","");
                if (parse.length() > 0)
                    message = Integer.valueOf(spaceremove);
                    int rand = (int)Math.random()*(8-0);
                    if (rand == 0);
                        out.println("Take food");
                    if (rand == 1);
                        out.println("Take linemate");
                    if (rand == 2);
                        out.println("Take deraumere");
                    if (rand == 3);
                        out.println("Take sibur");
                    if (rand == 4);
                        out.println("Take mendiane");
                    if (rand == 5);
                        out.println("Take thystame");
                    if (rand == 6);
                        out.println("Fork");
                    if (rand == 7);
                        out.println("Look");
                    if (end == "ok") {
                        AI stk = this;//AI("0", 4242, "team1", 1, executor);
                    //stk.AI(this._host, this._port, this._team, this._nb_client, this.executor);
                        executor.execute(stk);
                }
//                System.out.println("So i go to : " + message);
                switch (message) {
                        case 1:
                        out.println("Forward");                
                        break;
                        case 2:
                            out.println("Forward");
                            out.println("Left");
                            out.println("Forward");
                            break;
                        case 3:
                            out.println("Left");
                            out.println("Forward");
                            break;
                        case 4:
                            out.println("Left");
                            out.println("Forward");
                            out.println("Left");
                            out.println("Forward");
                            break;
                        case 5:
                            out.println("Left");
                            out.println("Left");
                            out.println("Forward");
                            break;
                        case 6:
                            out.println("Right");
                            out.println("Forward");
                            out.println("Right");
                            out.println("Forward");
                            break;
                        case 7:
                            out.println("Right");
                            out.println("Forward");
                            break;
                        case 8:
                            out.println("Forward");
                            out.println("Right");
                            out.println("Forward");
                            break;
                        case 0:
                            out.println("Set linemate");
                            out.println("Set deraumere");
                            out.println("Set sibur");
                            out.println("Set mendiane");
                            out.println("Set thystame");
                            out.println("broadcast i'mready:");
                            //System.out.println("gg you are with me");
                            break;
                        default:
                            break;
                    }
                parse = "";
                spaceremove = "";
                //System.out.println("echo: " + end);
                        if (end.equals("dead")) {
                            System.out.println("dead bro");
                            break;
                        }
                }
            }
        } catch(UnknownHostException e) {
            e.printStackTrace();
            System.exit(84);
        } catch (IOException e) {
            e.printStackTrace();
            //System.err.println("Le port " + this._port + " est deja utilise ! ");
            System.exit(84);
        } catch (SecurityException e) {
            e.printStackTrace();
            System.exit(84);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.exit(84);
        }
    }

    @Override
    public void run() {
        this.start();
        this.executor.shutdown();
        //System.out.println("yes");
    }
}
