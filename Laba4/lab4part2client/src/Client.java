import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {

        public static void main(String args[]) throws IOException {
            String str="";
            byte buf[]=new byte[256];
            try{
                Scanner scanner=new Scanner(System.in);
                DatagramSocket socket=new DatagramSocket();

                System.out.print("Введите x:");
                str+=""+scanner.nextInt()+" ";
                System.out.print("Введите y:");
                str+=""+scanner.nextInt()+" ";
                System.out.print("Введите z:");
                str+=""+scanner.nextInt()+" ";

                InetAddress address= InetAddress.getByName("localhost");
                buf=str.getBytes();
                DatagramPacket sendPacket
                        = new DatagramPacket(buf, buf.length, address, 8189);
                socket.send(sendPacket);

                byte[] buff=new byte[100];
                DatagramPacket recvPacket = new DatagramPacket(buff, buff.length);
                socket.receive(recvPacket);
                String received
                        = new String(recvPacket.getData(), 0, recvPacket.getLength());
                System.out.println("Ответ:"+received);
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }


        }



}
