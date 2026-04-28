package fr.eql.autom13.demo.java.basics;

import javax.swing.JOptionPane;

public class DemoDialog {

    static void main() {
        String name = JOptionPane.showInputDialog("Saisissez votre nom :)");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Saisissez votre âge"));
        JOptionPane.showMessageDialog(null, "Bonjour " + name + ", Vous avez " + age + " ans. :)");
    }
}
