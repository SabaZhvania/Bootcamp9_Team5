package ge.tbcitacademy.data;

import java.time.LocalDate;

public class Constants {
    public static final String LOCATION = "Tbilisi",
            STAYS = "Stays", FLIGHTS = "Flights", CAR_RENTALS = "Car rentals",
            BOOKING_URL = "https://booking.com",
            ROOMS_AND_PERSONS_DETAIL = "1 room for 2 adults",
            CHECK_IN = "Mon, Jul 8, 2024",
            CHECK_OUT = "Tue, Jul 9, 2024",
            CVC_ERROR_MSG = "Enter your 3 or 4-digit security code",
            EXPIRATION_ERROR_MSG = "Your card has to have a valid expiration date",
            CARD_N_ERROR_MSG = "Card number not valid";

    public static final LocalDate CHECK_IN_DATE = LocalDate.of(2024, 7, 8),
            CHECK_OUT_DATE = LocalDate.of(2024, 7, 9);
}
