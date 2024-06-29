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
            CARD_N_ERROR_MSG = "Card number not valid",
            INVALID_EMAIL_ERROR_MESSAGE = "Make sure the email address you entered is correct.",
            AUTH_SUCCESS = "auth_success=1",
            ACCOUNT_CREATED = "account_created=1",
            CONFIG = "config.properties",
            EMAIL = "email",
            PASSWORD = "password",
            US_DOLLAR = "U.S. Dollar",
            USD = "USD",
            PRICE_USD = "US$",
            LANGUAGE = "Deutsch",
            DE = "de";


    public static final LocalDate CHECK_IN_DATE = LocalDate.of(2024, 7, 8),
            CHECK_OUT_DATE = LocalDate.of(2024, 7, 9);
}
