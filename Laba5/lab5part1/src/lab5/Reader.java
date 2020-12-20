package lab5;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class Reader extends JFrame {

    static JLabel l1, l2;
    static DefaultListModel<String> list1 = new DefaultListModel();
    static DefaultListModel<String> list2 = new DefaultListModel();
    static DefaultListModel<String> list3 = new DefaultListModel();
    static JList<String> surname, name, midname;
    static JButton del;
    static JTextField text;
    static JDialog dialog;

    public Reader(String str) {
        super(str);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        del = new JButton("Очистить");
        text = new JTextField(9);
        l1 = new JLabel("Введите ФИО:");
        l2 = new JLabel("Фамилия Имя Отчество");
        surname = new JList(list1);
        name = new JList(list2);
        midname = new JList(list3);
        dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        setLayout(null);
        del.setSize(100, 30);
        del.setLocation(10, 400);
        text.setSize(220, 25);
        text.setLocation(250, 20);
        l1.setSize(200, 25);
        l1.setLocation(30, 20);
        l2.setSize(220, 25);
        l2.setLocation(30, 60);
        surname.setLocation(10, 100);
        surname.setSize(130, 200);
        name.setLocation(150, 100);
        name.setSize(130, 200);
        midname.setLocation(290, 100);
        midname.setSize(130, 200);
        list1.addListDataListener(new MesActionListener());
        surname.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Sel tltmt"+surname.getSelectedValue());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        text.addKeyListener(new KeyAdapter() {
                                @Override
                                public void keyTyped(KeyEvent e) {

                                }

                                @Override
                                public void keyPressed(KeyEvent e) {
                                    try {
                                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                            String string;
                                            string = text.getText();
                                            String str[] = string.split(" ");
                                            if (string.length() == 0) {
                                                JOptionPane.showMessageDialog(dialog,
                                                        "Вы ничего не ввели.",
                                                        "Inane warning",
                                                        JOptionPane.WARNING_MESSAGE);
                                            } else if (str.length == 1) {
                                                JOptionPane.showMessageDialog(dialog,
                                                        "Вы ввели только фамилию.",
                                                        "Inane warning",
                                                        JOptionPane.WARNING_MESSAGE);
                                                text.setText(null);
                                            } else if (str.length == 2) {
                                                JOptionPane.showMessageDialog(dialog,
                                                        "Вы ввели только фамилию и имя.",
                                                        "Inane warning",
                                                        JOptionPane.WARNING_MESSAGE);
                                                text.setText(null);
                                            } else if (str.length == 3) {
                                                list1.addElement((list1.getSize() + 1) + ". " + str[0]);
                                                list2.addElement(str[1]);
                                                list3.addElement(str[2]);
                                            }
                                        }

                                    } catch (ArrayIndexOutOfBoundsException e1) {
                                        throw new RuntimeException(e1);
                                    }
                                }

                                @Override
                                public void keyReleased(KeyEvent e) {

                                }
                            }
        );
        add(del);
        add(text);
        add(l1);
        add(l2);
        add(surname);
        add(name);
        add(midname);
        del.addActionListener(new DelActionListener());
    }


    public class MesActionListener implements ListDataListener {

        @Override
        public void intervalAdded(ListDataEvent e) {
            if (list1.getSize() > 10) {
                JOptionPane.showMessageDialog(dialog,
                        "Вы ввели уже 10 эелементов.",
                        "Inane warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {

        }

        @Override
        public void contentsChanged(ListDataEvent e) {

        }
    }

    public class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == del) {
                text.setText(null);
                list1.clear();
                list2.clear();
                list3.clear();

            }
        }
    }

}
