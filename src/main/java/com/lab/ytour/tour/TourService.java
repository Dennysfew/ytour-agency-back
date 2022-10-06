package com.lab.ytour.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public void updateTour(Long id, Tour tour) {
        Tour newTour = tourRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        newTour.setDescription(tour.getDescription());
        newTour.setCountry(tour.getCountry());
        newTour.setPrice(tour.getPrice());
        newTour.setImage(tour.getImage());
    }

    public Tour getOne(Long id) {
            return tourRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
