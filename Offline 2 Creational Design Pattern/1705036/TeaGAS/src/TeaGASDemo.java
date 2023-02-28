import TeaGASDirector.TeaGASDirector;

import java.util.Scanner;

public class TeaGASDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pack, net, web;
        System.out.println("Name of Package (Silver, Gold, Diamond, Platinum): ");
        pack = scanner.nextLine();
        System.out.println("Type of Internet Connection(SIM card, WiFi, Ethernet)");
        net = scanner.nextLine();
        System.out.println("Web Framework (Django, Spring, Laravel): ");
        web = scanner.nextLine();
        TeaGASDirector dir = new TeaGASDirector();
        TeaGASDirector dir2 = new TeaGASDirector();
        dir.constructSystem(pack, net, web);

    }
}
