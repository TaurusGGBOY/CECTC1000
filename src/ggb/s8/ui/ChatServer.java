package ggb.s8.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

//�����ҷ�������
public class ChatServer {
    // �������������׽���ServerSocket
    ServerSocket serverSocket;
    // �������б���
    ArrayList<BufferedReader> bReaders = new ArrayList<BufferedReader>();
    // ������б���
    ArrayList<PrintWriter> pWriters = new ArrayList<PrintWriter>();
    // ������Ϣ������
    LinkedList<String> msgList = new LinkedList<String>();

    public ChatServer() {
        try {
            // �������������׽���ServerSocket����28888�˿ڼ���
            serverSocket = new ServerSocket(28888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // �������տͻ���Socket���߳�ʵ����������
        new AcceptSocketThread().start();
        // �������ͻ��˷�����Ϣ���߳�ʵ����������
        new SendMsgToClient().start();
        System.out.println("������������...");
    }

    // ���տͻ���Socket�׽����߳�
    class AcceptSocketThread extends Thread {
        public void run() {
            while (this.isAlive()) {
                try {
                    // ����һ���ͻ���Socket����
                    Socket socket = serverSocket.accept();
                    // �����ÿͻ��˵�ͨ�Źܵ�
                    if (socket != null) {
                        // ��ȡSocket�����������
                        BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        // ����������ӵ��������б�����
                        bReaders.add(bReader);
                        // ����һ���߳̽��ոÿͻ��˵�������Ϣ
                        new GetMsgFromClient(bReader).start();

                        // ��ȡSocket����������������ӵ���������б�����
                        pWriters.add(new PrintWriter(socket.getOutputStream()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    // ���տͻ��˵�������Ϣ���߳�
    class GetMsgFromClient extends Thread {
        BufferedReader bReader;

        public GetMsgFromClient(BufferedReader bReader) {
            this.bReader = bReader;
        }

        public void run() {
            while (this.isAlive()) {
                try {
                    // ���������ж�һ����Ϣ
                    String strMsg = bReader.readLine();
                    if (strMsg != null) {
                        // SimpleDateFormat���ڸ�ʽ���ָ࣬�����ڸ�ʽΪ"��-��-�� ʱ:��:��",����"2015-11-06 13:50:26"
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        // ��ȡ��ǰϵͳʱ�䣬��ʹ�����ڸ�ʽ�����ʽ��Ϊָ����ʽ���ַ���
                        String strTime = dateFormat.format(new Date());
                        // ��ʱ�����Ϣ��ӵ���Ϣ��������
                        msgList.addFirst("<== " + strTime + " ==>\n" + strMsg);
                    }
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            }
        }
    }

    // �����пͻ�����������Ϣ���߳�
    class SendMsgToClient extends Thread {
        public void run() {
            while (this.isAlive()) {
                try {
                    // �����Ϣ�����ϲ��գ�����������Ϣδ���ͣ�
                    if (!msgList.isEmpty()) {
                        // ȡ��Ϣ�������е����һ��,���Ƴ�
                        String msg = msgList.removeLast();
                        // ��������б��Ͻ��б�����ѭ��������Ϣ�����пͻ���
                        for (int i = 0; i < pWriters.size(); i++) {
                            pWriters.get(i).println(msg);
                            pWriters.get(i).flush();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        new ChatServer();
    }
}
