package com.example.tfp.Service;

import com.example.tfp.Api.ApiException;
import com.example.tfp.Model.Booking;
import com.example.tfp.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Integer bookingId) {
        Booking booking = bookingRepository.findBookingById(bookingId);
        if (booking == null)
            throw new ApiException("Booking not found");
        return booking;
    }

    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public void updateBooking(Integer bookingId, Booking updatedBooking) {
        Booking existing = bookingRepository.findBookingById(bookingId);
        if (existing == null)
            throw new ApiException("Booking not found");

        updatedBooking.setId(existing.getId());
        bookingRepository.save(updatedBooking);
    }

    public void deleteBooking(Integer bookingId) {
        Booking booking = bookingRepository.findBookingById(bookingId);
        if (booking == null)
            throw new ApiException("Booking not found");
        bookingRepository.delete(booking);
    }

    public List<Booking> getMyBookings(Integer userId) {
        List<Booking> bookings = new ArrayList<>();
        bookings.addAll(bookingRepository.findPrivateMatchBookingsByPlayerId(userId));
        bookings.addAll(bookingRepository.findPublicMatchBookingsByOrganizerId(userId));
//        bookings.addAll(bookingRepository.findPublicMatchBookingsByTeamAPlayerId(userId));
//        bookings.addAll(bookingRepository.findPublicMatchBookingsByTeamBPlayerId(userId));
        return bookings;
    }
}
