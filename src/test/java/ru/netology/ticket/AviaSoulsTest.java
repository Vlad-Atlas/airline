package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Казань", 3000, 10_00, 14_25, 265);
    Ticket ticket2 = new Ticket("Москва", "Казань", 2000, 12_00, 16_00, 240);
    Ticket ticket3 = new Ticket("Москва", "Казань", 5000, 16_00, 20_45, 285);
    Ticket ticket4 = new Ticket("Н. Новгород", "Уфа", 1500, 11_00, 14_35, 215);
    Ticket ticket5 = new Ticket("Новосибирск", "Санкт-Петербург", 2000, 18_00, 23_00, 300);

    @Test
    public void sortByPriceOne() {
        AviaSouls ticket = new AviaSouls();

        ticket.add(ticket1);
        ticket.add(ticket2);

        Assertions.assertEquals(1, ticket1.compareTo(ticket2));

    }

    @Test
    public void sortByPriceTwo() {
        AviaSouls ticket = new AviaSouls();

        ticket.add(ticket3);
        ticket.add(ticket4);

        Assertions.assertEquals(-1, ticket4.compareTo(ticket3));

    }

    @Test
    public void sortByPriceEqual() {
        AviaSouls ticket = new AviaSouls();

        ticket.add(ticket2);
        ticket.add(ticket5);

        Assertions.assertEquals(0, ticket2.compareTo(ticket5));

    }

    @Test
    public void sortByPriceUp() {
        AviaSouls ticket = new AviaSouls();

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = ticket.search("Москва", "Казань");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortByPriceUpOneTicket() {
        AviaSouls ticket = new AviaSouls();

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        Ticket[] expected = {ticket5};
        Ticket[] actual = ticket.search("Новосибирск", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortByPriceUpZeroTicket() {
        AviaSouls ticket = new AviaSouls();

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = ticket.search("Ярославль", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void minimumFlightTime() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Москва", "Казань", 3000, 10_00, 14_25, 265);
        Ticket ticket2 = new Ticket("Москва", "Казань", 2000, 12_00, 16_00, 240);
        Ticket ticket3 = new Ticket("Москва", "Казань", 5000, 16_00, 20_45, 285);
        Ticket ticket4 = new Ticket("Москва", "Казань", 1500, 11_00, 14_35, 215);
        Ticket ticket5 = new Ticket("Москва", "Казань", 2000, 18_00, 23_00, 300);


        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets, ticketTimeComparator);

        Ticket[] expected = {ticket5, ticket3, ticket1, ticket2, ticket4};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void sortByPriceDown() {
        AviaSouls ticket = new AviaSouls();

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket1, ticket2};
        Ticket[] actual = ticket.searchAndSortBy("Москва", "Казань", ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPriceDownOneTicket() {
        AviaSouls ticket = new AviaSouls();

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        Ticket[] expected = {ticket5};
        Ticket[] actual = ticket.search("Новосибирск", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortByPriceDownZeroTicket() {
        AviaSouls ticket = new AviaSouls();

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = ticket.search("Ярославль", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);

    }
}