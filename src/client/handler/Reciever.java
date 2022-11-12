package client.handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.nio.Buffer;

import org.json.JSONObject;

import client.App;

public class Reciever extends Thread {
    
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    
    public Reciever(Socket s, BufferedReader reader, BufferedWriter writer) {
        this.socket = socket;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        String line;
        try {
            while (true) {
                line = reader.readLine();
                ResponseHandler.ResponseHandler(line);
            }
        } catch (IOException e) {}
    }
}