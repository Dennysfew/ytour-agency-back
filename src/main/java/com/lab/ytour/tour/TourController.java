package com.lab.ytour.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tour")
public class TourController {

    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @CrossOrigin
    @GetMapping
    public List<Tour> getTours() {
        return tourService.getTours();
    }

    @CrossOrigin
    @PostMapping
    public void addNewTour(@RequestBody Tour tour) {
        tourService.addNewTour(tour);
    }

    @CrossOrigin
    @DeleteMapping(path = "{tourId}")
    public void deleteTour(@PathVariable("tourId") Long tourId) {
        tourService.deleteTour(tourId);
    }


    @CrossOrigin
    @PutMapping("/update/{id}")
    private void updateTour(@PathVariable("id") Long id, @RequestBody Tour tour) {
        tourService.updateTour(id, tour);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private Tour getOne(@PathVariable("id") Long id) {
        return tourService.getOne(id);
    }


}
