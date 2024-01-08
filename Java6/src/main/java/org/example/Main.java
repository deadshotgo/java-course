package org.example;

public class Main {
    private int[][][] seats;

    public Main(int halls, int rows, int seatsPerRow) {
        seats = new int[halls][rows][seatsPerRow];
    }
    public static void main(String[] args) {
        Main cinema = new Main(5, 10, 20);
        cinema.bookSeats(1, 5, new int[]{1, 2, 3});
        cinema.printSeatingArrangement(1);
        cinema.checkAvailability(1, 18);
        cinema.cancelBooking(1, 5, new int[]{1, 2, 3});
        cinema.autoBook(1, 3);
        cinema.printSeatingArrangement(1);
    }
    public void bookSeats(int hallNumber, int row, int[] seatsToBook) {
       hallNumber--;
       row--;
        if (isValidHallRow(hallNumber, row)) {
            for (int seat : seatsToBook) {
                seat--;
                if (isValidSeat(hallNumber, row, seat) && seats[hallNumber][row][seat] == 0) {
                    seats[hallNumber][row][seat] = 1;
                    System.out.println("Seat " + seat + " in row " + row + " in hall " + hallNumber + " booked.");
                } else {
                    System.out.println("Seat " + seat + " in row " + row + " in hall " + hallNumber + " cannot be booked.");
                }
            }
        } else {
            System.out.println("Invalid hall number or row.");
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seatsToCancel) {
        hallNumber--;
        row--;
        if (isValidHallRow(hallNumber, row)) {
            for (int seat : seatsToCancel) {
                seat--;
                if (isValidSeat(hallNumber, row, seat) && seats[hallNumber][row][seat] == 1) {
                    seats[hallNumber][row][seat] = 1;
                    System.out.println("Cancellation of seat " + seat + " in row " + row + " in hall " + hallNumber + " successful.");
                } else {
                    System.out.println("Seat " + seat + " in row " + row + " in hall " + hallNumber + " was not booked.");
                }
            }
        } else {
            System.out.println("Invalid hall number or row.");
        }
    }
    public boolean checkAvailability(int hallNumber, int numSeats) {
        hallNumber--;

        for (int row = 0; row < seats[hallNumber].length; ++row) {
            int availableSeatsCount = seats[hallNumber][row].length - numSeats + 1;

            for (int seat = 0; seat < availableSeatsCount; ++seat) {
                if (areSeatsAvailable(hallNumber, row, seat, numSeats)) {
                    System.out.println(numSeats + " seats available in row " + (row + 1) + " in hall " + hallNumber + ".");
                    return true;
                }
            }
        }

        System.out.println(numSeats + " seats not available in hall " + hallNumber + ".");
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        hallNumber--;
        System.out.println("Seating arrangement in hall " + hallNumber + ":");
        for (int row = 0; row < seats[hallNumber].length; row++) {
            System.out.print("Row " + (row + 1) + ": ");
            for (int seat = 0; seat < seats[hallNumber][row].length; seat++) {
                System.out.print(seats[hallNumber][row][seat] + " ");
            }
            System.out.println();
        }
    }

    public int[] findBestAvailable(int hallNumber, int numSeats) {
        hallNumber--;
        for (int row = 0; row < seats[hallNumber].length; row++) {
            for (int seat = 0; seat <= seats[hallNumber][row].length - numSeats; seat++) {
                boolean available = true;
                for (int i = 0; i < numSeats; i++) {
                    if (seats[hallNumber][row][seat + i] == 1) {
                        available = false;
                        break;
                    }
                }
                if (available) {
                    System.out.println(
                            numSeats + " best available seats found in row " + (row + 1) + " in hall " + hallNumber + ".");
                    return new int[]{row + 1, seat + 1};
                }
            }
        }
        System.out.println("No best available seats found in hall " + hallNumber + ".");
        return null;
    }

    public void autoBook(int hallNumber, int numSeats) {
        int[] bestAvailable = findBestAvailable(hallNumber, numSeats);
        if(bestAvailable == null) {
            System.out.println("No best available seats booked in hall " + hallNumber + ".");
            return;
        };
        int row = bestAvailable[0];
        int startSeat = bestAvailable[1];

        for (int i = startSeat; i < startSeat + numSeats; i++) {
            seats[hallNumber - 1][row - 1][i - 1] = 1;
        }
        System.out.println(
                numSeats + " best available seats booked in row " + row + " in hall " + hallNumber + ".");
    }

    private boolean isValidHallRow(int hallNumber, int row) {
        return hallNumber >= 0 && hallNumber < seats.length && row >= 0 && row < seats[hallNumber].length;
    }

    private boolean  isValidSeat(int hallNumber, int row, int seat) {
        return seat >= 0 && seat < seats[hallNumber][row].length;
    }
    private boolean areSeatsAvailable(int hallNumber, int row, int startSeat, int numSeats) {
        for (int i = 0; i < numSeats; ++i) {
            if (seats[hallNumber][row][startSeat + i] == 1) {
                return false;
            }
        }
        return true;
    }
}