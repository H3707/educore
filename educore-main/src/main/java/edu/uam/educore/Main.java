package edu.uam.educore;

import edu.uam.educore.view.MenuPrincipalView;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    new MenuPrincipalView(scanner).iniciar();
    scanner.close();
  }
}
