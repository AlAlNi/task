package part1.lesson10;


import part1.lesson10.multisockets.clientSide.ChatClient;

public class ClientTest {
    public static void main(String[] args) {
        ChatClient chatClient1 = new ChatClient(8788, "Ash");
    }
}
