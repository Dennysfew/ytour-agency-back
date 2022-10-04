package com.lab.ytour.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TourService {
private final TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getTours() {
      return tourRepository.findAll();
    }

    public void addNewTour(Tour tour) {
        Optional<Tour> tourOptional = tourRepository.findTourByDescription(tour.getDescription());
        if (tourOptional.isPresent()) {
            throw new IllegalStateException("Description taken");
        }
        tourRepository.save(tour);
    }

    public void deleteTour(Long tourId) {
       boolean exists = tourRepository.existsById(tourId);
       if (!exists) {
           throw new IllegalStateException("student with id" + tourId + "does not exists");

       }
       tourRepository.deleteById(tourId);

    }

    @Transactional
    public void updateTour(Long tourId, String description, String country, Integer price, String image) {
        Tour tour = tourRepository.findById(tourId).orElseThrow(() -> new IllegalStateException("Tour with id " + tourId + " does not exist"));

        if (description != null && description.length() > 0 && !Objects.equals(tour.getDescription(), description)) {
            Optional<Tour> tourOptional = tourRepository.findTourByDescription(tour.getDescription());
            if (tourOptional.isPresent()) {
                throw new IllegalStateException("Description taken");
            }
            tour.setDescription(description);
        }
        if (country != null && country.length() > 0 && !Objects.equals(tour.getCountry(), country)) {
            tour.setCountry(country);
        }
        if (price != null && price > 0 && !Objects.equals(tour.getPrice(), price)) {
            tour.setPrice(price);
        }
        if (image != null && image.length() > 0 && !Objects.equals(tour.getImage(), image)) {
            tour.setImage(image);
        }
    }
}
