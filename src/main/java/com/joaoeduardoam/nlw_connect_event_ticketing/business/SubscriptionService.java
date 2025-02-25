package com.joaoeduardoam.nlw_connect_event_ticketing.business;

import com.joaoeduardoam.nlw_connect_event_ticketing.business.mapper.IMapper;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in.UserInDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.EventOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.SubscriptionOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.UserIndicationDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.UserRankingDTO;
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        var designation = String.format("http://%s.com/subscription/indication=%s", event.getPrettyName(), user.getUserId());

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

    public List<UserIndicationDTO> getRankingByPrettyName(String eventName) {

        eventRepository.findByPrettyName(eventName).orElseThrow(() -> new EventNotFoundException(
                "Event not found with prettyName: "+eventName));

        return subscriptionRepository.findIndicationsByPrettyName(eventName)
                .stream()
                .map(projection -> new UserIndicationDTO(
                        projection.getUserId(),
                        projection.getUserName(),
                        projection.getIndicationCount()
                ))
                .collect(Collectors.toList());
    }


    public List<UserIndicationDTO> getTop3RankingByPrettyName(String eventName) {
        List<UserIndicationDTO> ranking = getRankingByPrettyName(eventName);
        int size = ranking.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        return ranking.subList(0, Math.min(size, 3)); //pro caso da lista d ranking ter menos q 3 elementos
    }

    public UserRankingDTO getPositionRankingByUserId(String eventName, Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
                "User not found with ID: "+userId));

        List<UserIndicationDTO> ranking = this.getRankingByPrettyName(eventName);

        return ranking.stream()
                .filter(dto -> dto.userName().equals(user.getName()))
                .findFirst()
                .map(dto -> {
                    int position = ranking.indexOf(dto) + 1;
                    return new UserRankingDTO(dto.userName(), dto.indications(), position);
                })
                .orElseThrow(() -> new UserNotFoundException(
                        "User " + user.getName() + " not found in "+eventName+" ranking"));


    }







}
