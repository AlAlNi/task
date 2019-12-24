package part1.lesson10;

import part1.lesson10.multisockets.serverSide.ChatServer;

import java.io.IOException;

public class ServerTest {
    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer(8788);
    }
}