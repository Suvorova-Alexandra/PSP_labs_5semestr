package LAB7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertGroup extends JFrame {
    private JPanel contentPane;
    private JTextField group_id;
    private JTextField group_number;
    private JButton add;
    private JTable tableGroups;
    private JButton edit;
    private JButton delete;
    private JLabel errorId;
    private JLabel errorNumber;
    private JButton exit;
    private JLabel CommentLabel;
    private EnterDialog enter;
    private ConnectionDB mdbc;
    private java.sql.Statement stmt;
    private EditGroup dlg;

    public InsertGroup() {
        dlg = new EditGroup(this, true);
        setTitle("Управление группами");
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
        errorNumber.setVisible(false);
        group_number.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                NumberCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                NumberCheckLetters(e);
                SendButtonEnable(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                NumberCheckLetters(e);
                SendButtonEnable(e);
            }
        });
        group_id.addKeyListener(new KeyListener() {
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
        tableGroups.setModel(new Group(rs));
        tableGroups.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mdbc.close(rs);
        tableGroups.addMouseListener(new MouseListener() {
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
                group_id.setText("");
                group_number.setText("");
            }
        });
        edit.setEnabled(false);
        edit.addActionListener(new ActionListener() {
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
            rs = stmt.executeQuery("SELECT * FROM students_group");
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
        String groupId = group_id.getText();
        String groupNumber = group_number.getText();
        String insertStr = "";
        try {
            insertStr = "INSERT INTO students_group VALUES ("
                    + quotate(groupId) + ","
                    + quotate(groupNumber) + ")";
            System.out.println(insertStr);
            int done = stmt.executeUpdate(insertStr);
            CommentLabel.setText("1 row inserted");
            initComponents();
        } catch (Exception e) {
            CommentLabel.setText("Error occured in inserting data");
        }
    }

    private void SendButtonEnable(java.awt.event.KeyEvent evt) {
        if (!errorId.isVisible() && !errorNumber.isVisible() &&
                !group_id.getText().equals("") && !group_number.getText().equals("")) {
            add.setEnabled(true);
        } else add.setEnabled(false);
    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(tableGroups.getSelectedRow());
        if (tableGroups.getSelectedRowCount() > 0) {
            String groupId = (String) tableGroups.getValueAt(tableGroups.getSelectedRow(), 0);

            String insertStr = "";
            try {
                insertStr = "DELETE FROM students_group WHERE group_id=" + groupId;
                int done = stmt.executeUpdate(insertStr);
                CommentLabel.setText("1 row deleted");
                initComponents();
            } catch (Exception e) {
                CommentLabel.setText("Error occured in deleting data");
            }
        }
    }

   private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (tableGroups.getSelectedRowCount() > 0) {
            dlg.setGroup_id((String) tableGroups.getValueAt(tableGroups.getSelectedRow(), 0));
            dlg.setGroup_name((String) tableGroups.getValueAt(tableGroups.getSelectedRow(), 1));
            dlg.setVisible(true);
            try {
                String insertStr = "UPDATE students_group SET group_id="
                        + quotate(dlg.getGroup_id()) + "WHERE group_id =" + (String) tableGroups.getValueAt(tableGroups.getSelectedRow(), 0);
                int done = stmt.executeUpdate(insertStr);
                insertStr = "UPDATE students_group SET group_number="
                        + quotate(dlg.getGroup_name()) + "WHERE group_id =" + (String) tableGroups.getValueAt(tableGroups.getSelectedRow(), 0);
                done = stmt.executeUpdate(insertStr);
                initComponents();
            } catch (Exception e) {
                System.out.println("Error occured in editing data");
            }
        }
    }

    private void CarTableMouseClicked(java.awt.event.MouseEvent evt) {
        if (tableGroups.getSelectedRowCount() > 0) {
            edit.setEnabled(true);
            delete.setEnabled(true);
        } else {
            edit.setEnabled(false);
            delete.setEnabled(false);
        }
    }


    private void IdCheckLetters(java.awt.event.KeyEvent evt) {
        String text3 = group_id.getText();
        ResultSet rs=getResultFromProfessor();
        Group profSet=new Group(rs);
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

    private void NumberCheckLetters(java.awt.event.KeyEvent evt) {
        String text4 = group_number.getText();
        boolean match = text4.matches("[0-9]+");
        if (!match) {
            errorNumber.setText("Неправильный ввод! Должны быть только цифры.");
            errorNumber.setForeground(Color.RED);
            errorNumber.setVisible(true);
        } else {
            errorNumber.setVisible(false);
        }
    }
}
