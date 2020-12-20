package server;

import java.net.*;
import java.io.*;

class Server {
    static int countclients = 0;//счетчик подключившихся клиентов

    public static void main(String args[]) throws IOException {
        ServerSocket sock = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            sock = new ServerSocket(1024); //создаем серверный сокет работающий локально по порту 1024
            while (true) { //бесконечный цикл для возможности подключения последовательно нескольних клиентов
                Socket client = sock.accept(); //сработает, когда клиент подключится,
//                для него выделится отдельный сокет client
                countclients++; //количество подключившихся клиентов увеличивается на 1
                System.out.println("=======================================");
                System.out.println("Client " + countclients + " connected");
                is = client.getInputStream(); //получили входной поток для чтения данных
                os = client.getOutputStream();//получили выходной поток для записи данных

                byte[] bytes = new byte[1024];
                int count = -1;

                count = is.read(bytes); //чтение иформации, посланной клиентом, из вхоного потока в массив bytes[]
                System.out.println("Count " + count);
                String str = new String(bytes, "UTF-8"); // переводим тип byte в тип String
                System.out.println("клиент sended " + str);
                String[] numbers = str.split(" "); // разбиваем строку на подстроки пробелами
                String m = ""; //переменнная,в которую будут записываться числа делящиеся на 3
                bytes = new byte[1024];
                for (int i = Math.min(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])); i > 0; i--) {
                    if (Integer.parseInt(numbers[0]) % i == 0 && Integer.parseInt(numbers[1]) % i == 0) {
                        m += i + " "; // записываютмя числа,которые деляется на 3
                        break;
                    }
                }
                System.out.println("Ответ " + m);
                bytes = m.getBytes();
                os.write(bytes); // отправляем клиенту информацию
                bytes = null;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        } finally {
            is.close();//закрытие входного потока
            os.close();//закрытие входного потока
            sock.close();//закрытие сокета, выделенного для работы с подключившимся клиентом
            System.out.println("Client " + countclients + " disconnected");
        }

    }
}
