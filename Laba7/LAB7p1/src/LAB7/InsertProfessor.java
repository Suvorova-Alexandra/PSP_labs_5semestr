package LAB7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertProfessor extends JFrame {
    private JPanel contentPane;
    private JTextField professor_id;
    private JTextField surname;
    private JTextField midname;
    private JButton send;
    private JTable table1;
    private JTextField profName;
    private JLabel CommentLabel;
    private JButton editButton;
    private JButton deleteButton;
    private JLabel errorId;
    private JLabel errorSurname;
    private JLabel errorName;
    private JLabel errorMidname;
    private JPanel Panel;
    private JButton exit;
    private ConnectionDB mdbc;
    private java.sql.Statement stmt;
    private EditDialog dlg;
    private EnterDialog enter;

    public InsertProfessor() {
        dlg = new EditDialog(this, true);
        setTitle("Управление преподавателями");
        try {
            mdbc = new ConnectionDB();
            mdbc.init();
            Connection conn = mdbc.getMyConnection();
            stmt = conn.createStatement();
        } catch (Exception e) {
        }
        initComponents();


    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        setContentPane(contentPane);
        ResultSet rs = getResultFromProfessor();
        send.setEnabled(false);
        errorId.setVisible(false);
        errorSurname.setVisible(false);
        errorName.setVisible(false);
        errorMidname.setVisible(false);
        professor_id.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                IdCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                IdCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                IdCheckLetters(e);
                SendButtonEnable(e);
            }
        });
        surname.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SurnameCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                SurnameCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                SurnameCheckLetters(e);
                SendButtonEnable(e);
            }


        });
        profName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                NameCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                NameCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                NameCheckLetters(e);
                SendButtonEnable(e);
            }


        });
        midname.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                MidnameCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                MidnameCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                MidnameCheckLetters(e);
                SendButtonEnable(e);
            }


        });
        table1.setModel(new Professor(rs));
        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mdbc.close(rs);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarTableMouseClicked(evt);
            }
        });
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SendButtonActionPerformed(evt);
                professor_id.setText("");
                midname.setText("");
                profName.setText("");
                midname.setText("");
            }
        });
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                enter=new EnterDialog();
                enter.setTitle("Расписание предметов");
                enter.pack();
                enter.setLocationRelativeTo(null);
                enter.setVisible(true);
            }
        });
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 416) / 2, (screenSize.height - 636) / 2, 600, 600);
    }

    public ResultSet getResultFromProfessor() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM professor");
        } catch (SQLException e) {
        }
        return rs;
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        try {
            mdbc.close(stmt.getResultSet());
            mdbc.destroy();
        } catch (SQLException ex) {
        }
    }

    public String quotate(String content) {
        return "'" + content + "'";
    }

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String profId = professor_id.getText();
        String profSurname = surname.getText();
        String professorName = profName.getText();
        String profMidname = midname.getText();
        String insertStr = "";
        try {
            insertStr = "INSERT INTO professor VALUES ("
                    + quotate(profId) + ","
                    + quotate(profSurname) + ","
                    + quotate(professorName) + ","
                    + quotate(profMidname) + ")";
            System.out.println(insertStr);
            int done = stmt.executeUpdate(insertStr);
            CommentLabel.setText("1 row inserted");
            initComponents();
        } catch (Exception e) {
            CommentLabel.setText("Error occured in inserting data");
        }
    }

    private void SendButtonEnable(java.awt.event.KeyEvent evt) {
        if (!errorId.isVisible() && !errorSurname.isVisible() && !errorName.isVisible() && !errorMidname.isVisible() &&
                !professor_id.getText().equals("") && !surname.getText().equals("") && !profName.getText().equals("") && !midname.getText().equals("")) {
            send.setEnabled(true);
        } else send.setEnabled(false);
    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(table1.getSelectedRow());
        if (table1.getSelectedRowCount() > 0) {
            String profId = (String) table1.getValueAt(table1.getSelectedRow(), 0);

            String insertStr = "";
            try {
                insertStr = "DELETE FROM professor WHERE professor_id=" + profId;
                int done = stmt.executeUpdate(insertStr);
                CommentLabel.setText("1 row deleted");
                initComponents();
            } catch (Exception e) {
                CommentLabel.setText("Error occured in deleting data");
            }
        }
    }

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (table1.getSelectedRowCount() > 0) {
            dlg.setProfessorID((String)table1.getValueAt(table1.getSelectedRow(), 0));
            dlg.setProfessorSurame((String)table1.getValueAt(table1.getSelectedRow(), 1));
            dlg.setProfessorName((String)table1.getValueAt(table1.getSelectedRow(), 2));
            dlg.setProfessorMidname((String)table1.getValueAt(table1.getSelectedRow(), 3));
            dlg.setVisible(true);
            try {
                String insertStr = "UPDATE professor SET professor_id="
                        + quotate(dlg.getProfessorID()) + "WHERE professor_id =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
                int done = stmt.executeUpdate(insertStr);
                insertStr = "UPDATE professor SET surname="
                        + quotate(dlg.getProfessorSurname()) + "WHERE professor_id =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
                done = stmt.executeUpdate(insertStr);
                insertStr = "UPDATE professor SET professor_name="
                        + quotate(dlg.getProfessorName()) + "WHERE professor_id =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
                done = stmt.executeUpdate(insertStr);
                insertStr = "UPDATE professor SET midname="
                        + quotate(dlg.getProfessorMidname()) + "WHERE professor_id =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
                done = stmt.executeUpdate(insertStr);
                initComponents();
            } catch (Exception e) {
                System.out.println("Error occured in editing data");
            }
        }
    }

    private void CarTableMouseClicked(java.awt.event.MouseEvent evt) {
        if (table1.getSelectedRowCount() > 0) {
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
        } else {
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
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

    private void IdCheckLetters(java.awt.event.KeyEvent evt) {
        String text3 = professor_id.getText();
        ResultSet rs=getResultFromProfessor();
        Professor profSet=new Professor(rs);

        boolean match = text3.matches("[0-9]+");
        if (!match) {
            errorId.setText("Неправильный ввод! Должны быть только цифры.");
            errorId.setForeground(Color.RED);
            errorId.setVisible(true);
        }
        else {
            for(int i=0;i<profSet.getRowCount();i++){
                if(text3.equals(profSet.getValueAt(i,0))){
                    errorId.setText("Неправильный ввод! ID должен быть уникальным.");
                    errorId.setForeground(Color.RED);
                    errorId.setVisible(true);
                    break;
                }
                else  errorId.setVisible(false);
            }


        }
    }
}
