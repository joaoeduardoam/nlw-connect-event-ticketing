package com.joaoeduardoam.nlw_connect_event_ticketing.business;

import com.joaoeduardoam.nlw_connect_event_ticketing.business.mapper.IMapper;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in.UserInDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.EventOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.SubscriptionOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions.EventNotFoundException;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions.UserAlreadySubscribedException;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions.UserNotFoundException;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Subscription;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.User;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.repo.EventRepository;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.repo.SubscriptionRepository;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final IMapper mapper;


    public SubscriptionOutDTO addNewSubscription(String eventName, UserInDTO userInDTO, Integer userId){


        Event event = eventRepository.findByPrettyName(eventName).orElseThrow(() -> new EventNotFoundException(
                "Event not found with prettyName: "+eventName));

        User user = userRepository.findByEmail(userInDTO.email())
                .orElseGet(() -> userRepository.save(mapper.toUser(userInDTO)));


        subscriptionRepository.findByEventAndSubscriber(event, user)
                .ifPresent(subscription -> {
                    throw new UserAlreadySubscribedException(
                            String.format("User %s already subscribed in the event %s", user.getName(), event.getTitle())
                    );
                });

        User indication = Optional.ofNullable(userId)
                .map(id -> userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("Indication user not found with id: " + id)))
                .orElse(null);

        var designation = String.format("http:%s.com/subscription/indication=%s", event.getPrettyName(), user.getUserId());

        return mapper.toSubscriptionOutDTO(
                subscriptionRepository.save(new Subscription(event, user, indication, designation)));
    }

    public List<EventOutDTO> getAllEvents(){
        return eventRepository.findAll().stream().map(mapper::toEventOutDTO).toList();
    }

    public EventOutDTO getByPrettyName(String prettyName){

        return mapper.toEventOutDTO(eventRepository.findByPrettyName(prettyName).orElseThrow(() -> new EventNotFoundException(
                "Event not found with name: "+prettyName)));
    }
}
