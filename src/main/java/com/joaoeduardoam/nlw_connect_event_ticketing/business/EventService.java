package com.joaoeduardoam.nlw_connect_event_ticketing.business;

import com.joaoeduardoam.nlw_connect_event_ticketing.business.mapper.IEventMapper;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in.EventInDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.EventOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions.EventNotFoundException;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.repo.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final IEventMapper mapper;


    public EventOutDTO addNewEvent(EventInDTO eventInDTO){
        return mapper.toEventOutDTO(
                eventRepository.save(
                        mapper.toEntity(eventInDTO)));
    }

    public List<EventOutDTO> getAllEvents(){
        return eventRepository.findAll().stream().map(mapper::toEventOutDTO).toList();
    }

    public EventOutDTO getByPrettyName(String prettyName){

        return mapper.toEventOutDTO(eventRepository.findByPrettyName(prettyName).orElseThrow(() -> new EventNotFoundException(
                "Event not found with prettyName: "+prettyName)));
    }
}
