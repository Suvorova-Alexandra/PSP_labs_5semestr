package LAB7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditSubject extends JDialog {
    private JPanel contentPane;
    private JButton edit;
    private JTextField subject_id;
    private JTextField subject_name;
    private JLabel errorName;

    public EditSubject(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setContentPane(contentPane);
        setModal(true);
        pack();
        setResizable(false);
        errorName.setVisible(false);
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });
subject_name.addKeyListener(new KeyListener() {
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
        this.setVisible(false);
    }

    public String getSubject_id() {
        return subject_id.getText();
    }

    public String getSubject_name() {
        return subject_name.getText();
    }

    public void setSubject_id(String subject_id) {
        this.subject_id.setText(subject_id);
    }

    public void setSubject_name(String subject_name) {
        this.subject_name.setText(subject_name);
    }
    private void NameCheckLetters(java.awt.event.KeyEvent evt) {
        String text4 = subject_name.getText();
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
