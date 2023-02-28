package subject.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin implements Runnable {
    @Override
    public void run() {
        System.out.println("Admin Thread Started...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            while (true){


                String line = br.readLine();

                String[] split = line.split(" ");
                if(split[0].equalsIgnoreCase("i")){
                    for (int i = 0; i< Publisher.stocks.size(); i++){
                        if(Publisher.stocks.get(i).getName().equals(split[1])){
                            Publisher.stocks.get(i).increasePrice(Float.parseFloat(split[2]));
                        }
                    }
                }

                else if(split[0].equalsIgnoreCase("d")){
                    for (int i = 0; i< Publisher.stocks.size(); i++){
                        if(Publisher.stocks.get(i).getName().equals(split[1])){
                            Publisher.stocks.get(i).decreasePrice(Float.parseFloat(split[2]));
                        }
                    }
                }

                else if(split[0].equalsIgnoreCase("c")){
                    for (int i = 0; i< Publisher.stocks.size(); i++){
                        if(Publisher.stocks.get(i).getName().equals(split[1])){
                            Publisher.stocks.get(i).setCount(Integer.parseInt(split[2]));
                        }
                    }
                }
            }

        } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

