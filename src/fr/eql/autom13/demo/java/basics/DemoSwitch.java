package fr.eql.autom13.demo.java.basics;

import javax.swing.JOptionPane;

public class DemoSwitch {

    static void main() {

        String message;
        String weapon = JOptionPane.showInputDialog("Un troll nous attaque." + "\r\nQuelle areme souhaitez vous utiliser ? (épée/arc/magie");
        switch (weapon) {
            case "épée" :
                message = "Vous avez choisi la voie du guerrier." + "\r\nVotre coup d'épée fait perdre 2PV au troll";
                break;

            case "arc" :
                message = "Vous avez choisi la voie du chasseur." + "\r\nVotre flêche fait perdre 1PV au troll";
                break;

            case "magie" :
                message = "Vous avez choisi la voie du sorcier." + "\r\nmalheuresement le troll est resistant a la magie" + "\r\nIl vous mage";
                break;

            default:
                message = "Vous faites le malin, Vous vous retrouvez tout nu." + "\r\nLe troll vous mange";

        }
        JOptionPane.showMessageDialog(null, message);
    }
}
