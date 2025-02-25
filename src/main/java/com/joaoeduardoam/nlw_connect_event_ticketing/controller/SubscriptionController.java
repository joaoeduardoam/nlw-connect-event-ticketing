package com.joaoeduardoam.nlw_connect_event_ticketing.controller;

import com.joaoeduardoam.nlw_connect_event_ticketing.business.EventService;
import com.joaoeduardoam.nlw_connect_event_ticketing.business.SubscriptionService;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in.EventInDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in.UserInDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.EventOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.SubscriptionOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.UserIndicationDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.UserRankingDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Subscription;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class SubscriptionController {


    private final SubscriptionService subscriptionService;

    @PostMapping({"/subscription/{prettyName}", "/subscription/{prettyName}/{userId}"})
    public ResponseEntity<SubscriptionOutDTO> addNewSubscription(@PathVariable String prettyName,
                                                                 @PathVariable(required = false) Integer userId,
                                                                 @RequestBody @Valid UserInDTO userInDTO){

        return ResponseEntity.ok(subscriptionService.addNewSubscription(prettyName, userInDTO, userId));
    }

    @GetMapping("/subscription/{prettyName}/ranking")
    public ResponseEntity<List<UserIndicationDTO>> getTop3RankingByPrettyName(@PathVariable String prettyName){

        return ResponseEntity.ok(subscriptionService.getTop3RankingByPrettyName(prettyName));
    }

    @GetMapping("/subscription/{prettyName}/ranking/{userId}")
    public ResponseEntity<UserRankingDTO> getPositionRankingByUserId(@PathVariable String prettyName, @PathVariable Integer userId){

        return ResponseEntity.ok(subscriptionService.getPositionRankingByUserId(prettyName, userId));
    }





//    @GetMapping("/events")
//    public ResponseEntity<List<EventOutDTO>> getAllEvents(){
//        return ResponseEntity.ok(service.getAllEvents());
//    }
//
//    @GetMapping("/events/{prettyName}")
//    public ResponseEntity<EventOutDTO> getEventByPrettyName(@PathVariable String prettyName){
//        return ResponseEntity.ok(service.getByPrettyName(prettyName));
//    }
}
