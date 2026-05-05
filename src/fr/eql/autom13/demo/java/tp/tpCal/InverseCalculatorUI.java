package fr.eql.autom13.demo.java.tp.tpCal;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class InverseCalculatorUI extends JFrame {

    // --- Pile ---
    private final List<Double> calculInverse = new ArrayList<>();

    // --- Composants UI ---
    private final DefaultListModel<String> pileModel = new DefaultListModel<>();
    private final JList<String> pileView = new JList<>(pileModel);
    private final JTextField inputField = new JTextField();
    private final JLabel statusLabel = new JLabel("Entrez un nombre et appuyez sur Empiler.");

    public InverseCalculatorUI() {
        super("Calculatrice NPI");
        buildUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 580);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // -------------------------------------------------------------------------
    // Construction de l'interface
    // -------------------------------------------------------------------------

    private void buildUI() {
        setLayout(new BorderLayout(8, 8));
        getRootPane().setBorder(new EmptyBorder(12, 12, 12, 12));
        getContentPane().setBackground(new Color(30, 30, 30));

        add(buildPilePanel(),   BorderLayout.CENTER);
        add(buildInputPanel(),  BorderLayout.NORTH);
        add(buildButtonPanel(), BorderLayout.SOUTH);
    }

    /** Panneau d'affichage de la pile (toujours visible) */
    private JPanel buildPilePanel() {
        JPanel panel = new JPanel(new BorderLayout(4, 4));
        panel.setOpaque(false);

        JLabel title = new JLabel("PILE");
        title.setForeground(new Color(180, 180, 180));
        title.setFont(new Font("Monospaced", Font.BOLD, 13));

        pileView.setBackground(new Color(20, 20, 20));
        pileView.setForeground(new Color(80, 220, 120));
        pileView.setFont(new Font("Monospaced", Font.PLAIN, 18));
        pileView.setBorder(new EmptyBorder(8, 12, 8, 12));
        pileView.setSelectionBackground(new Color(50, 50, 50));

        statusLabel.setForeground(new Color(140, 140, 140));
        statusLabel.setFont(new Font("Monospaced", Font.ITALIC, 11));

        panel.add(title,                          BorderLayout.NORTH);
        panel.add(new JScrollPane(pileView),      BorderLayout.CENTER);
        panel.add(statusLabel,                    BorderLayout.SOUTH);
        return panel;
    }

    /** Champ de saisie + bouton Empiler */
    private JPanel buildInputPanel() {
        JPanel panel = new JPanel(new BorderLayout(6, 0));
        panel.setOpaque(false);

        inputField.setFont(new Font("Monospaced", Font.PLAIN, 18));
        inputField.setBackground(new Color(45, 45, 45));
        inputField.setForeground(Color.WHITE);
        inputField.setCaretColor(Color.WHITE);
        inputField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(70, 70, 70)),
                new EmptyBorder(6, 10, 6, 10)));

        // Empiler aussi avec la touche Entrée
        inputField.addActionListener(e -> empiler());

        JButton btnEmpiler = makeButton("Empiler", new Color(50, 130, 200));
        btnEmpiler.addActionListener(e -> empiler());

        panel.add(inputField,  BorderLayout.CENTER);
        panel.add(btnEmpiler,  BorderLayout.EAST);
        return panel;
    }

    /** Grille de boutons de traitement */
    private JPanel buildButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 4, 6, 6));
        panel.setOpaque(false);

        // Opérations
        JButton btnAdd  = makeButton("+",  new Color(60, 160, 80));
        JButton btnSub  = makeButton("−",  new Color(60, 160, 80));
        JButton btnMul  = makeButton("×",  new Color(60, 160, 80));
        JButton btnDiv  = makeButton("÷",  new Color(60, 160, 80));

        btnAdd.addActionListener(e -> calculOperation(Operation.ADDITION));
        btnSub.addActionListener(e -> calculOperation(Operation.SOUSTRACTION));
        btnMul.addActionListener(e -> calculOperation(Operation.MULTIPLICATION));
        btnDiv.addActionListener(e -> calculOperation(Operation.DIVISION));

        // Traitements
        JButton btnSwap  = makeButton("Swap",  new Color(160, 100, 40));
        JButton btnDrop  = makeButton("Drop",  new Color(160, 100, 40));
        JButton btnClear = makeButton("Clear", new Color(160, 60,  60));
        JButton btnExit  = makeButton("Quitter", new Color(100, 40, 40));

        btnSwap.addActionListener(e  -> swap());
        btnDrop.addActionListener(e  -> drop());
        btnClear.addActionListener(e -> clear());
        btnExit.addActionListener(e  -> System.exit(0));

        panel.add(btnAdd);  panel.add(btnSub);
        panel.add(btnMul);  panel.add(btnDiv);
        panel.add(btnSwap); panel.add(btnDrop);
        panel.add(btnClear);panel.add(btnExit);

        return panel;
    }

    // -------------------------------------------------------------------------
    // Logique métier (identique à ta version, sans JOptionPane)
    // -------------------------------------------------------------------------

    private void empiler() {
        String input = inputField.getText().trim();
        if (input.isEmpty()) { setStatus("Aucune valeur saisie."); return; }
        try {
            double val = Double.parseDouble(input.replace(",", "."));
            calculInverse.add(val);
            inputField.setText("");
            refreshPile();
            setStatus("'" + val + "' empilé.");
        } catch (NumberFormatException ex) {
            setStatus("⚠ Valeur invalide : \"" + input + "\"");
        }
    }

    private void calculOperation(Operation operation) {
        if (calculInverse.size() < 2) {
            setStatus("⚠ Il faut au moins 2 opérandes dans la pile.");
            return;
        }
        double nbr1 = calculInverse.removeLast();
        double nbr2 = calculInverse.removeLast();
        double result;

        switch (operation) {
            case ADDITION      -> result = nbr2 + nbr1;
            case SOUSTRACTION  -> result = nbr2 - nbr1;
            case MULTIPLICATION-> result = nbr2 * nbr1;
            case DIVISION -> {
                if (nbr1 == 0) {
                    setStatus("⚠ Division par 0 impossible !");
                    calculInverse.add(nbr2);
                    calculInverse.add(nbr1);
                    refreshPile();
                    return;
                }
                result = nbr2 / nbr1;
            }
            default -> { return; }
        }

        calculInverse.add(result);
        refreshPile();
        setStatus(nbr2 + " " + operation.name().toLowerCase() + " " + nbr1 + " = " + result);
    }

    private void swap() {
        if (calculInverse.size() < 2) { setStatus("⚠ Pas assez d'éléments pour Swap."); return; }
        double nbr1 = calculInverse.removeLast();
        double nbr2 = calculInverse.removeLast();
        calculInverse.add(nbr1);
        calculInverse.add(nbr2);
        refreshPile();
        setStatus("Swap effectué : " + nbr1 + " ↔ " + nbr2);
    }

    private void drop() {
        if (calculInverse.isEmpty()) { setStatus("⚠ La pile est vide."); return; }
        double dropped = calculInverse.removeLast();
        refreshPile();
        setStatus("Drop : '" + dropped + "' supprimé.");
    }

    private void clear() {
        calculInverse.clear();
        refreshPile();
        setStatus("Pile vidée.");
    }

    // -------------------------------------------------------------------------
    // Utilitaires UI
    // -------------------------------------------------------------------------

    /** Met à jour l'affichage de la pile (sommet en bas, comme une vraie NPI) */
    private void refreshPile() {
        pileModel.clear();
        for (int i = 0; i < calculInverse.size(); i++) {
            String prefix = (i == calculInverse.size() - 1) ? "► " : "  ";
            pileModel.addElement(prefix + calculInverse.get(i));
        }
        // Scroll vers le bas pour toujours voir le sommet
        if (!pileModel.isEmpty()) {
            pileView.ensureIndexIsVisible(pileModel.size() - 1);
        }
    }

    private void setStatus(String message) {
        statusLabel.setText(message);
    }

    private JButton makeButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Monospaced", Font.BOLD, 14));
        btn.setBorder(new EmptyBorder(10, 8, 10, 8));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }
}