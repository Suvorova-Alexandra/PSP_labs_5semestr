package LAB7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField professor_id;
    private JTextField surname;
    private JTextField profName;
    private JTextField midname;
    private JLabel errorSurname;
    private JLabel errorName;
    private JLabel errorMidname;

    public EditDialog(java.awt.Frame parent, boolean modal) {
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
        errorMidname.setVisible(false);
        errorName.setVisible(false);
        errorSurname.setVisible(false);
        setResizable(false);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });
        surname.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SurnameCheckLetters(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                SurnameCheckLetters(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                SurnameCheckLetters(e);
            }
        });
        profName.addKeyListener(new KeyListener() {
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
        midname.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                MidnameCheckLetters(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                MidnameCheckLetters(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                MidnameCheckLetters(e);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);


    }

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public String getProfessorID() {
        return professor_id.getText();
    }

    public String getProfessorName() {
        return profName.getText();
    }

    public String getProfessorSurname() {
        return surname.getText();
    }

    public String getProfessorMidname() {
        return midname.getText();
    }

    public void setProfessorID(String CarID) {
        professor_id.setText(CarID);
    }

    public void setProfessorName(String Name) {
        profName.setText(Name);
    }

    public void setProfessorSurame(String Surname) {
        surname.setText(Surname);
    }

    public void setProfessorMidname(String Midname) {
        midname.setText(Midname);
    }

    private void SurnameCheckLetters(java.awt.event.KeyEvent evt) {
        String text = surname.getText();
        boolean match = text.matches("[a-zA-Z]+");
        if (!match) {
            errorSurname.setText("Неправильный ввод! Должны быть только буквы.");
            errorSurname.setForeground(Color.RED);
            errorSurname.setVisible(true);
        } else {
            errorSurname.setVisible(false);
        }
    }

    private void NameCheckLetters(java.awt.event.KeyEvent evt) {
        String text1 = profName.getText();
        boolean match = text1.matches("[a-zA-Z]+");
        if (!match) {
            errorName.setText("Неправильный ввод! Должны быть только буквы.");
            errorName.setForeground(Color.RED);
            errorName.setVisible(true);
        } else {
            errorName.setVisible(false);
        }
    }

    private void MidnameCheckLetters(java.awt.event.KeyEvent evt) {
        String text2 = midname.getText();
        boolean match = text2.matches("[a-zA-Z]+");
        if (!match) {
            errorMidname.setText("Неправильный ввод! Должны быть только буквы.");
            errorMidname.setForeground(Color.RED);
            errorMidname.setVisible(true);
        } else {
            errorMidname.setVisible(false);
        }
    }
}
