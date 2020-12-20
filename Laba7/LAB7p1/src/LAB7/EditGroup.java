package LAB7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditGroup extends JDialog {
    private JPanel contentPane;
    private JButton edit;
    private JTextField group_id;
    private JTextField group_number;
    private JLabel errorNumber;

    public EditGroup(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setContentPane(contentPane);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        pack();
        setResizable(false);
        errorNumber.setVisible(false);
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });
        group_number.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                NameCheckLetters(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                NameCheckLetters(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                NameCheckLetters(e);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);


    }
    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public String getGroup_id() {
        return group_id.getText();
    }

    public String getGroup_name() {
        return group_number.getText();
    }

    public void setGroup_id(String group_id) {
        this.group_id.setText(group_id);
    }

    public void setGroup_name(String group_number) {
        this.group_number.setText(group_number);
    }
    private void NameCheckLetters(java.awt.event.KeyEvent evt) {
        String text4 = group_number.getText();
        boolean match = text4.matches("[a-zA-Z]+");
        if (!match) {
            errorNumber.setText("Неправильный ввод! Должны быть только буквы.");
            errorNumber.setForeground(Color.RED);
            errorNumber.setVisible(true);
        } else {
            errorNumber.setVisible(false);
        }
    }
}
