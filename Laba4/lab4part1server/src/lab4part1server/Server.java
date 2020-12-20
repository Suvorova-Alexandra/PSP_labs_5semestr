package lab4part1server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(4004); // серверсокет прослушивает порт 4004
                System.out.println("Сервер запущен!"); // хорошо бы серверу
                //   объявить о своем запуске
                clientSocket = server.accept(); // accept() будет ждать пока
                //кто-нибудь не захочет подключиться
                try { // установив связь и воссоздав сокет для общения с клиентом можно перейти
                    // к созданию потоков ввода/вывода.
                    // теперь мы можем принимать сообщения
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // и отправлять
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    Flat array[];
                    array=new Flat[9];
                    array[0]=new Flat(56000,"г.Минск, ул. Тимирязева, 31-74");
                    array[1]=new Flat(20000,"г.Минск, пр-т Независимости, 164-4");
                    array[2]=new Flat(87000,"г.Минск, ул. Калиновского, 62-22");
                    array[3]=new Flat(67000,"г.Минск, ул. М.Богдановича, 133-155");
                    array[4]=new Flat(99000,"г.Минск, ул. Куйбышева, 19-100");
                    array[5]=new Flat(156000,"г.Минск, ул. Сурганова, 28-7");
                    array[6]=new Flat(190000,"г.Минск, ул. Шафарнянская, 37-111");
                    array[7]=new Flat(54000,"г.Минск, ул. Россиянова, 74-14");
                    array[8]=new Flat(200000,"г.Минск, ул. Скрипникова, 5-125");

                    String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
                    System.out.println(word);

                    int number=Integer.parseInt(word);
                    int count=0;

                    for (int i=0;i < array.length;i++) {
                        if (number >= array[i].getCost()) {
                            count += 1;
                        }
                    }
                    String s=String.valueOf(count);
                    System.out.println(s);
                    out.write(s+"\n");
                    out.flush();


                    for(int i=0;i< array.length;i++){
                        if(number >= array[i].getCost()){
                            String str="Квартира №: " + (i+1)  + ":"+array[i].toString();
                            out.write(str);
                            out.flush();
                            System.out.println(str);
                            // выталкиваем все из буфера
                        }

                    }
                    // не долго думая отвечает клиенту

                }

                finally { // в любом случае сокет будет закрыт
                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}