package part1.lesson10;

import part1.lesson10.multisockets.clientSide.ChatClient;

public class ClientTest2 {
    public static void main(String[] args) {
        ChatClient chatClient2 = new ChatClient(8788, "Meowth");
    }
}