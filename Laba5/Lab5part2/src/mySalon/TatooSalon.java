package mySalon;


import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TatooSalon extends JFrame {
    File file = new File("Salon.txt");
    String text1;
    int k;
    MaskFormatter phoneFormatter;
    Object boxA;
    static JButton del;
    static JButton load;
    static JTextField name, email;
    static JFormattedTextField tel;
    static JCheckBox box;
    static JRadioButton but1, but2, but3, but4, but5, but6;
    static JLabel la1, la2, la3, la4, la5, la6, errorname, errorservice, errortel;
    static JComboBox list;
    static JDialog dialog;
    ButtonGroup bg;
    static String[] box2 = {"Не выбрано", "На ноге", "На икре", "На лодыжке", "На ступне", "На плече", "На предплечье", "На запястье",
            "На руке", "На шее", "На голове", "На спине", "На ягодцах", "В интимной зоне", "В другом месте"};


    TatooSalon(String str) {
        super(str);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        del = new JButton("Очистить");
        load = new JButton("Занести в базу");
        la1 = new JLabel("Введите свое имя: ");
        la2 = new JLabel("Введите свой телефон: ");
        la5 = new JLabel("Введите свою электронную почту: ");
        la3 = new JLabel("Нажмите, если вам есть 18 лет");
        la4 = new JLabel("Что вас интересует?");
        la6 = new JLabel("На какой части тела?");

        try {
            phoneFormatter = new MaskFormatter("+375-##-###-##-##");
            phoneFormatter.setPlaceholderCharacter('0');
            tel = new JFormattedTextField(phoneFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        list = new JComboBox(box2);
        email = new JTextField();
        name = new JTextField();
        errorname = new JLabel("Поле не должно быть пустым!");
        errorservice = new JLabel("Выберите услугу!");
        errortel = new JLabel("Введите телефон!");

        box = new JCheckBox();
        but1 = new JRadioButton("Татуировка");
        but2 = new JRadioButton("Пирсинг");
        but3 = new JRadioButton("Татуаж");
        but4 = new JRadioButton("Выведение");
        but5 = new JRadioButton("Мехенди");
        but6 = new JRadioButton("Маникюр");
        bg = new ButtonGroup();
        bg.add(but1);
        bg.add(but2);
        bg.add(but3);
        bg.add(but4);
        bg.add(but5);
        bg.add(but6);

        setLayout(null);
        la1.setSize(150, 15);
        la1.setLocation(10, 10);
        name.setSize(150, 20);
        name.setLocation(180, 10);
        errorname.setSize(200, 15);
        errorname.setLocation(180, 30);
        errorname.setForeground(Color.red);
        errorname.setVisible(false);
        errortel.setSize(200, 15);
        errortel.setLocation(180, 80);
        errortel.setForeground(Color.red);
        errortel.setVisible(false);
        errorservice.setSize(200, 15);
        errorservice.setLocation(10, 260);
        errorservice.setForeground(Color.red);
        errorservice.setVisible(false);
        la2.setSize(150, 15);
        la2.setLocation(10, 60);
        tel.setSize(150, 20);
        tel.setLocation(180, 60);
        la3.setSize(200, 15);
        la3.setLocation(10, 110);

        la4.setSize(150, 15);
        la4.setLocation(10, 160);
        box.setSize(20, 20);
        box.setLocation(200, 110);
        but1.setSize(100, 15);
        but1.setLocation(10, 200);
        but2.setSize(100, 15);
        but2.setLocation(130, 200);
        but3.setSize(100, 15);
        but3.setLocation(250, 200);
        but4.setSize(100, 15);
        but4.setLocation(10, 240);
        but5.setSize(100, 15);
        but5.setLocation(130, 240);
        but6.setSize(100, 15);
        but6.setLocation(250, 240);
        la6.setSize(250, 15);
        la6.setLocation(10, 290);
        list.setLocation(10, 320);
        list.setSize(320, 20);
        la5.setSize(250, 15);
        la5.setLocation(10, 350);
        email.setLocation(10, 380);
        email.setSize(250, 20);
        load.setSize(200, 20);
        load.setLocation(100, 450);
        del.setSize(100, 20);
        del.setLocation(320, 450);
        add(la1);
        add(la2);
        add(la3);
        add(la4);
        add(box);
        add(name);
        add(tel);
        add(email);
        add(but1);
        add(but2);
        add(but3);
        add(but4);
        add(but5);
        add(but6);
        add(la5);
        add(email);
        add(la6);
        add(list);
        add(del);
        add(load);
        add(errorname);
        add(errorservice);
        add(errortel);
        del.addActionListener(new DelActionListener());
        load.addActionListener(new ButtonActionListener());
        box.addActionListener(new FlagActionListener());
        list.addActionListener(new BoxActionListener());
        but1.addActionListener(new RadioActionLisener());
        but2.addActionListener(new RadioActionLisener());
        but3.addActionListener(new RadioActionLisener());
        but4.addActionListener(new RadioActionLisener());
        but5.addActionListener(new RadioActionLisener());
        but6.addActionListener(new RadioActionLisener());
        //load.setEnabled(false);
    }

    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter out = new FileWriter(file, true);
                try {
                    String text = name.getText();
                    System.out.println(text);
                    String text2 = tel.getText();
                    System.out.println(text2);
                   /* if (email == null || email.getText() == null ||
                            !(email.getText().trim().contains("@") && email.getText().trim().contains("."))) {
                        JOptionPane.showMessageDialog(dialog,
                                "Неправильный email.",
                                "Inane warning",
                                JOptionPane.WARNING_MESSAGE);

                    }*/

                    if (name == null || name.getText() == null || name.getText().trim().length() == 0 || text == "") {
                        errorname.setVisible(true);
                    }
                    else if (text1 == null || text1== "") {

                        errorservice.setVisible(true);
                    }
                    /* else  if (boxA == null) {
                        JOptionPane.showMessageDialog(dialog,
                                "Выберите часть тела.",
                                "Inane warning",
                                JOptionPane.WARNING_MESSAGE);
                    }*/
                    else {
                       // load.setEnabled(true);
                        errorname.setVisible(false);
                        errorservice.setVisible(false);
                        errortel.setVisible(false);
                        out.write(text + "\n");
                        out.write(text2 + "\n");
                        if (k == 1)
                            out.write("Клиенту есть 18 лет. " + "\n");
                        else
                            out.write("Клиенту нет 18 лет. " + "\n");
                        out.write("Что делаем: " + text1 + "\n");

                        out.write("Часть тела: " + boxA + "\n");

                        String text3 = email.getText();
                        out.write("Электронная почта: " + text3 + "\n");
                    }


                } finally {

                    out.close();
                }
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    public class FlagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            k = 0;
            if (e.getSource() == box) {
                k++;
            } else {
                k--;
            }
        }
    }

    public class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == del) {
                name.setText(null);
                tel.setText(null);
                email.setText(null);
                box.setSelected(false);
                bg.clearSelection();
                list.setSelectedIndex(0);
            }
        }
    }

    public class BoxActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == list) {
                boxA = list.getSelectedItem();
            }
        }
    }

    public class RadioActionLisener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            {
                if (e.getSource() == but1) {
                    text1 = but1.getText();
                } else if (e.getSource() == but2) {
                    text1 = but2.getText();
                } else if (e.getSource() == but3) {
                    text1 = but3.getText();

                } else if (e.getSource() == but4) {
                    text1 = but4.getText();
                } else if (e.getSource() == but5) {
                    text1 = but5.getText();
                } else if (e.getSource() == but6) {
                    text1 = but6.getText();
                }
            }
        }
    }


}
