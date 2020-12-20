package butterfly;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CautchingButterflies extends JFrame {

    public CautchingButterflies() {
        setTitle("Бабочка и сачок");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE)


        ;
        start = new JButton("Старт");
        stop = new JButton("Стоп");
        button = new JButton("Ловить");
        counts = new JLabel();
        JPanel content = new JPanel(new BorderLayout());
        setContentPane(content);
        button.setSize(100, 20);
        stop.setSize(100, 20);
        start.setSize(100, 20);
        button.setLocation(100, 10);
        stop.setLocation(200, 10);
        start.setLocation(0, 10);
        counts.setSize(300, 20);
        counts.setLocation(10, 40);
        content.add(button);
        content.add(start);
        content.add(stop);
        content.add(counts);
        setLayout(null);
        Thread butter = new Thread(new ButterflyTread());
        Thread sachok = new Thread(new NetThread());
        FieldNet fil = new FieldNet();
        fil.setSize(600, 600);
        counts.setText("Всего попаданий: 0");
        start.addActionListener(e -> {
            //counts.setVisible(true);
            if (!butter.isAlive())
                butter.start();
            else butter.resume();

        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                func = true;
                counter = 0;
                slips = 0;
                //  counts.setVisible(false);

                if (!sachok.isAlive())
                    sachok.start();
                else sachok.resume();

            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                func = false;
                counts.setText("Всего попаданий:" + counter + "; Всего промахов:" + slips);
                // counts.setVisible(true);
                butter.suspend();
                sachok.suspend();


            }
        });
        content.add(fil);

    }

    public void check() {
        int k = buffImg2X, z = buffImg2Y;
        checkout = 0;
        if (flag == 0) {

            while (k <= buffImg2Width + buffImg2X) {
                z = buffImg2Y;
                while (z <= buffImg2Height + buffImg2Y) {
                    for (int i = buffImg1X; i < buffImg1Width + buffImg1X; i++) {
                        for (int j = buffImg1Y; j < buffImg1Height + buffImg1Y; j++) {

                            if (k == i && j == z) {
                                checkout++;
                            }
                        }
                    }
                    z++;
                }
                k++;
            }
        }
        System.out.println("X1." + buffImg1X);
        System.out.println("Y1." + buffImg1Y);
        System.out.println("X2/" + buffImg2X);
        System.out.println("Y2/" + buffImg2Y);
        System.out.println("check" + checkout);
        if (checkout >=3600) {
            counter++;
            System.out.println("counter" + counter);
            counts.setText("Всего попаданий:" + counter);
            flag=1;

        } else {
            slips++;
        }
        if(checkout==0){
            flag=0;
        }

    }


    private class FieldNet extends JPanel {

        public FieldNet() {
            setPreferredSize(new Dimension(600, 600));
            setBackground(Color.white);
            try {
                buffImg1 = ImageIO.read(new File("D:\\Butterfly1.jpg"));
                buffImg2 = ImageIO.read(new File("D:\\sachok.jpg"));
            } catch (IOException exc) {
            }
            ;

        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g.create();

            graphics2D.drawImage(buffImg1, buffImg1X, buffImg1Y, buffImg1Width, buffImg1Height, this);

            graphics2D.drawImage(buffImg2, buffImg2X, buffImg2Y, buffImg2Width, buffImg2Height, this);

        }
    }


    private class ButterflyTread implements Runnable {
        private int velocityX = 10;
        private int velocityY = 5;

        public void update() {
            if (buffImg1X < 0 && buffImg1Y < 0) {
                buffImg1X = getWidth() / 2;
                buffImg1Y = getHeight() / 2;

            } else {
                buffImg1X += velocityX;
                buffImg1Y += velocityY;
                if ((buffImg1X > getWidth() - buffImg1Width) || (buffImg1X < 0)) {
                    velocityX = velocityX * -1;
                }
                if ((buffImg1Y > getHeight() - buffImg1Height) || (buffImg1Y < 0)) {

                    velocityY = velocityY * -1;
                }
            }


        }

        @Override
        public void run() {
            while (buffImg1Height != 0) {
                update();


                repaint();
                try {

                    Thread.sleep(10);
                } catch (Exception exc) {
                }
                ;
            }
        }
    }

    private class NetThread implements Runnable {
        private int velocityY = 2;

        public void update() {
            if (drop % 2 == 0) {

                buffImg2Y += velocityY;

            } else {
                buffImg2Y -= velocityY;

            }

        }

        @Override
        public void run() {
            while (buffImg1Height != 0) {

                update();

                repaint();
                if (func == true) {
                    check();
                }
                if (buffImg2Y == 200 || buffImg2Y == 400)
                    drop += 1;

                try {
                    Thread.sleep(25);
                } catch (Exception exc) {
                }
                ;
            }
        }

    }

    private BufferedImage buffImg1, buffImg2;
    private int buffImg1Width = 60, buffImg1Height = 60, buffImg2Width = 100, buffImg2Height = 100, X, Y;
    private int buffImg1X = 50, buffImg1Y = 50, buffImg2X = 400, buffImg2Y = 200;
    static JButton start, stop, button;
    static JLabel counts;
    static int counter = 0, drop = 0, slips = 0, checkout = 0, flag=0;
    static boolean func = false;

}

