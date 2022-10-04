package com.lab.ytour.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tour")
public class TourController {

    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<Tour> getTours() {
     return tourService.getTours();
    }
    @PostMapping
    public void addNewTour (@RequestBody Tour tour) {
        tourService.addNewTour(tour);
    }
    @DeleteMapping(path = "{tourId}")
    public void deleteTour(@PathVariable("tourId") Long tourId) {
        tourService.deleteTour(tourId);
    }
    @PutMapping (path = "{tourId}")
    public void updateTour(
            @PathVariable("tourId") Long tourId,
            @PathVariable(required = false) String description,
            @PathVariable(required = false) String country,
            @PathVariable(required = false) Integer price,
            @PathVariable(required = false) String image) {
        tourService.updateTour(tourId, description, country, price, image);
    }

}
