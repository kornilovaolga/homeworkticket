import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    AviaSouls avia = new AviaSouls();

    Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 20, 22);
    Ticket ticket2 = new Ticket("MSK", "SPB", 15_000, 10, 11);
    Ticket ticket3 = new Ticket("MSK", "SPB", 15_000, 1, 12);
    Ticket ticket4 = new Ticket("MSK", "KHB", 3_000, 0, 7);
    Ticket ticket5 = new Ticket("MSK", "SPB", 14_000, 13, 14);

    @org.junit.Test
    public void compareToMore() {

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareToLess() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareToEqual() {

        int expected = 0;
        int actual = ticket2.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void addTicketsAndFind() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = avia.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SearchAndSortFromYesToYes() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket1, ticket5, ticket2, ticket3};
        Ticket[] actual = avia.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SearchAndSortFromYesToNo() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = avia.search("MSK", "IRK");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SearchAndSortFromNoToYes() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = avia.search("IRK", "SPB");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SearchAndSortFromNoToNo() {

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = avia.search("IRK", "MSK");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void comparatorTimeMore() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 1;
        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void comparatorTimeLess() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = -1;
        int actual = comparator.compare(ticket2, ticket1);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void comparatorTimeEqual() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 0;
        int actual = comparator.compare(ticket2, ticket5);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchAndSortByYesToYes() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket5, ticket2, ticket1, ticket3};
        Ticket[] actual = avia.searchAndSortBy("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchAndSortByNoToNo() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = avia.searchAndSortBy("IRK", "MSK", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }


}