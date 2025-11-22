/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package quick_chat_app3;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Thabani Buthelezi
 */
public class Quick_Chat_App3Test {
    @Test
    public void testAddMessage() {
        MessageService ms = new MessageService();
        ms.setFilePath("test_messages.txt");

        Message m = new Message(1, "Alice", "Bob", "Hello Bob!", "hash123");
        ms.addMessage(m);

        assertEquals(1, ms.getTotalMessages());
    }

    @Test
    public void testSearchByID() {
        MessageService ms = new MessageService();
        ms.setFilePath("test_messages.txt");

        Message m1 = new Message(1, "Alice", "Bob", "Hi", "h1");
        Message m2 = new Message(2, "Carol", "Dave", "Hello", "h2");

        ms.addMessage(m1);
        ms.addMessage(m2);

        Message found = ms.searchByID(2);

        assertNotNull(found);
        assertEquals("Carol", found.sender);
    }

    @Test
    public void testSearchByRecipient() {
        MessageService ms = new MessageService();
        ms.setFilePath("test_messages.txt");

        Message m1 = new Message(1, "Alice", "Bob", "Msg1", "h1");
        Message m2 = new Message(2, "Carol", "Bob", "Msg2", "h2");
        Message m3 = new Message(3, "John", "Mary", "Msg3", "h3");

        ms.addMessage(m1);
        ms.addMessage(m2);
        ms.addMessage(m3);

        ArrayList<Message> results = ms.searchByRecipient("Bob");

        assertEquals(2, results.size());
    }

    @Test
    public void testDeleteMessageByHash() {
        MessageService ms = new MessageService();
        ms.setFilePath("test_messages.txt");

        Message m1 = new Message(1, "Alice", "Bob", "Hi", "hash111");
        Message m2 = new Message(2, "Carol", "Dave", "Hello", "hash222");

        ms.addMessage(m1);
        ms.addMessage(m2);

        boolean deleted = ms.deleteMessageByHash("hash111");

        assertTrue(deleted);
        assertEquals(1, ms.getTotalMessages());
    }

    @Test
    public void testGetLongestMessage() {
        MessageService ms = new MessageService();
        ms.setFilePath("test_messages.txt");

        Message m1 = new Message(1, "Alice", "Bob", "Short", "h1");
        Message m2 = new Message(2, "Carol", "Dave", "This is the longest message.", "h2");

        ms.addMessage(m1);
        ms.addMessage(m2);

        Message longest = ms.getLongestMessage();

        assertEquals("Carol", longest.sender);
    }

    @Test
    public void testLoadAndSaveFile() {
        MessageService ms = new MessageService();
        ms.setFilePath("test_messages.txt");

        Message m1 = new Message(10, "Tester", "Receiver", "File save test", "hh10");

        ms.addMessage(m1);

        MessageService ms2 = new MessageService();
        ms2.setFilePath("test_messages.txt");
        ms2.loadMessagesFromFile();

        assertEquals(1, ms2.getTotalMessages());
    }

}