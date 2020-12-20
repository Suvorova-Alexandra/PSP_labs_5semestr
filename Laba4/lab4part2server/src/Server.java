import java.net.*;
import java.io.*;

public class Server {
    public static double determinate(double x, double y,double z){
        double f=0;
        f=y+(Math.exp(x-y)/(y+Math.pow(x,2)/(y+Math.pow(x,3)/y))*(1+Math.pow(Math.pow(Math.tan(z/3),2), Math.pow(Math.abs(y)+7,1/2))));
        System.out.println("Результат:"+f);

        return f;
    }
    public static void toFile(double x, double y,double z,double f)   {
        try {
            File file = new File("file.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file,true);

            fileWriter.append("x:" + x + " y:" + y + " z:" + z + " Ответ:" + f + "\n");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Данные записаны в файл:"+file.getName());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String args[]) throws IOException {

        System.out.println("Сервер запущен!");
        String str="";
        double x,y,z,f;

        DatagramSocket socket=new DatagramSocket(8189);
        byte[]buf = new byte[256];

        while (true){
            DatagramPacket recvPacket=new DatagramPacket(buf,buf.length);
            socket.receive(recvPacket);
            String received
                    = new String(recvPacket.getData(), 0, recvPacket.getLength());
            System.out.println("Переменные:"+received);


            String strs[]=received.split(" ");

            InetAddress address = recvPacket.getAddress();
            int port = recvPacket.getPort();

            x=Double.parseDouble(strs[0]);
            y=Double.parseDouble(strs[1]);
            z=Double.parseDouble(strs[2]);


            buf=(""+(f=determinate(x,y,z))).getBytes();

            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, address, port);
            socket.send(sendPacket);
            toFile(x,y,z,f);
        }
    }
}
