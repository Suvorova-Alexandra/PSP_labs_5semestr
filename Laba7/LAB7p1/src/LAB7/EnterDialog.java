package LAB7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterDialog extends JDialog {
    private JPanel contentPane;
    private JButton professors;
    private JButton classes;
    private JButton groups;
    private JButton subjects;

    public EnterDialog() {
        setContentPane(contentPane);
        setResizable(false);
        setModal(true);
        professors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InsertProfessor().setVisible(true);
            }
        });
        classes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InsertAuditorium().setVisible(true);
            }
        });
        subjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InsertSubject().setVisible(true);
            }
        });
        groups.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InsertGroup().setVisible(true);
            }
        });
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 416) / 2, (screenSize.height - 636) / 2, 600, 600);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
