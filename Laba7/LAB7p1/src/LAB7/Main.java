package LAB7;

public class Main {

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    EnterDialog dialog = new EnterDialog();
                    dialog.setTitle("Расписание предметов");
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
                catch(Exception e){}
            }
        });
    }

}
