package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket(
            "Moskow",
            "Vladivostok",
            3_500,
            7,
            21
    );
    Ticket ticket2 = new Ticket(
            "Moskow",
            "Vladivostok",
            13_800,
            1,
            10
    );
    Ticket ticket3 = new Ticket(
            "Moskow",
            "Vladivostok",
            9_200,
            3,
            13
    );
    Ticket ticket4 = new Ticket(
            "Moskow",
            "Vladivostok",
            25_500,
            5,
            13
    );
    Ticket ticket5 = new Ticket(
            "Moskow",
            "Vladivostok",
            6_200,
            3,
            20
    );
    @Test
    public void shouldCompareFirstAndSecond(){
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void shouldCompareSecondAndFirst(){
        int expected = 1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void shouldCompareFirstAndFifth(){
        int expected = - 1;
        int actual = ticket1.compareTo(ticket5);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void shouldCompareFifthAndFirst(){
        int expected =  1;
        int actual = ticket5.compareTo(ticket1);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void shouldCompareThirdAndFourth(){
        int expected = - 1;
        int actual = ticket3.compareTo(ticket4);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void shouldCompareFourthAndThird(){
        int expected =  1;
        int actual = ticket4.compareTo(ticket3);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void shouldSortByPriceIncreaseAll(){
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket1,ticket5,ticket3,ticket2,ticket4};
        Ticket[] actual =aviaSouls.search("Moskow","Vladivostok");
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldSortByPriceIncreaseFirstThirdFifth(){
        aviaSouls.add(ticket1);
        //aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        //aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket1,ticket5,ticket3};
        Ticket[] actual =aviaSouls.search("Moskow","Vladivostok");
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldSortByPriceIncreaseIfZero(){

        Ticket[] expected = {};
        Ticket[] actual =aviaSouls.search("Moskow","Vladivostok");
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldTestOfTicketTimeComporator(){
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] expected = {ticket4,ticket2,ticket3,ticket1,ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moskow","Vladivostok", comparator);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldTestOfTicketTimeComporatorIfNoTicket(){
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moskow","Vladivostok", comparator);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldTestOfTicketTimeComporatorIfThreeTickets(){
        aviaSouls.add(ticket1);
        //aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        //aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] expected = {ticket3,ticket1,ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moskow","Vladivostok", comparator);
        Assertions.assertArrayEquals(expected,actual);
    }


}
