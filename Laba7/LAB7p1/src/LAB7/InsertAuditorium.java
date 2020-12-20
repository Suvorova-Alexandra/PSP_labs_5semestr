package LAB7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertAuditorium extends JFrame {
    private JPanel contentPane;
    private JButton exit;
    private JTextField class_id;
    private JTextField class_name;
    private JButton add;
    private JLabel errorId;
    private JLabel errorName;
    private JButton edit;
    private JButton delete;
    private JTable tableClasses;
    private JLabel CommentLabel;
    private EnterDialog enter;
    private ConnectionDB mdbc;
    private java.sql.Statement stmt;
    private EditAuditorium dlg;

    public InsertAuditorium() {
        dlg = new EditAuditorium(this, true);
        setTitle("Управление аудиториями");
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
        setContentPane(contentPane);
        setResizable(false);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        ResultSet rs = getResultFromProfessor();
        add.setEnabled(false);
        errorId.setVisible(false);
        errorName.setVisible(false);
        class_id.addKeyListener(new KeyListener() {
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
        class_name.addKeyListener(new KeyListener() {
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
        tableClasses.setModel(new Auditorium(rs));
        tableClasses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mdbc.close(rs);
        tableClasses.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                CarTableMouseClicked(e);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                CarTableMouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SendButtonActionPerformed(evt);
                class_id.setText("");
                class_name.setText("");
            }
        });
        edit.setEnabled(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        delete.setEnabled(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                enter = new EnterDialog();
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
            rs = stmt.executeQuery("SELECT * FROM auditorium");
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
        String classId = class_id.getText();
        String className = class_name.getText();
        String insertStr = "";
        try {
            insertStr = "INSERT INTO auditorium VALUES ("
                    + quotate(classId) + ","
                    + quotate(className) + ")";
            System.out.println(insertStr);
            int done = stmt.executeUpdate(insertStr);
            CommentLabel.setText("1 row inserted");
            initComponents();
        } catch (Exception e) {
            CommentLabel.setText("Error occured in inserting data");
        }
    }

    private void SendButtonEnable(java.awt.event.KeyEvent evt) {
        if (!errorId.isVisible() && !errorName.isVisible() &&
                !class_id.getText().equals("") && !class_name.getText().equals("")) {
            add.setEnabled(true);
        } else add.setEnabled(false);
    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(tableClasses.getSelectedRow());
        if (tableClasses.getSelectedRowCount() > 0) {
            String classId = (String) tableClasses.getValueAt(tableClasses.getSelectedRow(), 0);

            String insertStr = "";
            try {
                insertStr = "DELETE FROM auditorium WHERE class_id=" + classId;
                int done = stmt.executeUpdate(insertStr);
                CommentLabel.setText("1 row deleted");
                initComponents();
            } catch (Exception e) {
                CommentLabel.setText("Error occured in deleting data");
            }
        }
    }

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (tableClasses.getSelectedRowCount() > 0) {
            dlg.setClass_id((String) tableClasses.getValueAt(tableClasses.getSelectedRow(), 0));
            dlg.setClass_name((String) tableClasses.getValueAt(tableClasses.getSelectedRow(), 1));
            dlg.setVisible(true);
            try {
                String insertStr = "UPDATE auditorium SET class_id="
                        + quotate(dlg.getClass_id()) + "WHERE class_id =" + (String) tableClasses.getValueAt(tableClasses.getSelectedRow(), 0);
                int done = stmt.executeUpdate(insertStr);
                insertStr = "UPDATE auditorium SET class_name="
                        + quotate(dlg.getClass_name()) + "WHERE class_id =" + (String) tableClasses.getValueAt(tableClasses.getSelectedRow(), 0);
                done = stmt.executeUpdate(insertStr);
                initComponents();
            } catch (Exception e) {
                System.out.println("Error occured in editing data");
            }
        }
    }

    private void CarTableMouseClicked(java.awt.event.MouseEvent evt) {
        if (tableClasses.getSelectedRowCount() > 0) {
            edit.setEnabled(true);
            delete.setEnabled(true);
        } else {
            edit.setEnabled(false);
            delete.setEnabled(false);
        }
    }


    private void IdCheckLetters(java.awt.event.KeyEvent evt) {
        String text3 = class_id.getText();
        ResultSet rs=getResultFromProfessor();
        Auditorium profSet=new Auditorium(rs);
        boolean match = text3.matches("[0-9]+");
        if (!match) {
            errorId.setText("Неправильный ввод! Должны быть только цифры.");
            errorId.setForeground(Color.RED);
            errorId.setVisible(true);
        } else {
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

    private void NameCheckLetters(java.awt.event.KeyEvent evt) {
        String text4 = class_name.getText();
        boolean match = text4.matches("[a-zA-Z0-9]+");
        if (!match) {
            errorName.setText("Неправильный ввод!");
            errorName.setForeground(Color.RED);
            errorName.setVisible(true);
        } else {
            errorName.setVisible(false);
        }
    }
}
