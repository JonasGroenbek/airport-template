package dk.cphbusiness.airport.template;

import dk.cphbusiness.algorithm.examples.queues.*;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private static List<Plane> planes = new ArrayList<>();
    private static PassengerProducer producer;
    private static PassengerConsumer consumer;
    private static PriorityQueue<Passenger> queue;
    private static Clock clock;

    private static Passenger[] passengers = new Passenger[0];

    private static void setup() {
        /*for (int hour = 7; hour <= 22; hour++) {
            planes.add(new Plane(new Time(hour, 00, 00)));
        }*/
        planes.add(new Plane(new Time(7, 00, 00)));
        queue = new ArrayPriorityQueue(passengers);
        //queue = new NotPrioritisingPassengerArrayQueue(1000);
        producer = new PassengerProducer(planes, queue);
        consumer = new PassengerConsumer(planes, queue);
        clock = new Clock(producer, consumer, new Time(05, 00, 00));
    }

    public static void main(String[] args) {
        setup();
        new Thread(clock).start();
    }
}
