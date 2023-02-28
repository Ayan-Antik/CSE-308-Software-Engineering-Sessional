import editor.Editor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editor editor = Editor.getinstance();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter filename: ");
        String extension = scn.nextLine().split("\\.")[1];
        //System.out.println(extension);

        editor.setContents(extension);
        editor.showContents();
    }
}
