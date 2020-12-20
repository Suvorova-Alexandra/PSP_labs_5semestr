package LAB7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditAuditorium extends JDialog {
    private JPanel contentPane;
    private JButton edit;
    private JTextField class_id;
    private JTextField class_name;
    private JLabel errorName;

    public EditAuditorium(java.awt.Frame parent, boolean modal) {
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
        errorName.setVisible(false);
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });
        class_name.addKeyListener(new KeyListener() {
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

    public String getClass_id() {
        return class_id.getText();
    }

    public String getClass_name() {
        return class_name.getText();
    }

    public void setClass_id(String class_id) {
        this.class_id.setText(class_id);
    }

    public void setClass_name(String class_name) {
        this.class_name.setText(class_name);
    }
    private void NameCheckLetters(java.awt.event.KeyEvent evt) {
        String text4 = class_name.getText();
        boolean match = text4.matches("[a-zA-Z]+");
        if (!match) {
            errorName.setText("Неправильный ввод! Должны быть только буквы.");
            errorName.setForeground(Color.RED);
            errorName.setVisible(true);
        } else {
            errorName.setVisible(false);
        }
    }
}
