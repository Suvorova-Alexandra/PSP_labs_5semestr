package lab4part1client;
import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                // адрес - локальный хост, порт - 4004, такой же как у сервера
                clientSocket = new Socket("localhost", 4004); // этой строкой мы запрашиваем
                //  у сервера доступ на соединение
                reader = new BufferedReader(new InputStreamReader(System.in));
                // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать туда же
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Введите максимальную стоимость квартиры:");
                String word = reader.readLine(); // ждём пока клиент что-нибудь
                // не напишет в консоль
                out.write(word + "\n"); // отправляем сообщение на серве
                out.flush();

               String serverWord = in.readLine(); // ждём, что скажет сервер
              // получив - выводим на экран
              // int number=Integer.parseInt(serverWord);
                String number = serverWord;
                System.out.println(number);
                int valueOfnumber=Integer.parseInt(number);
                if(valueOfnumber==0){  System.out.println("Квартир с такой стоимостью нет.");}
                else {
                    for (int i = 0; i < valueOfnumber; i++) {
                        out.flush();
                        String flats = in.readLine(); // ждём, что скажет сервер
                        System.out.println( flats);
                    }
                }
            } finally { // в любом случае необходимо закрыть сокет и потоки
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
