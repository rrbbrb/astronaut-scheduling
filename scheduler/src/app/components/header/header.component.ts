import { Component, OnInit } from '@angular/core';
import { Calendar } from '@fullcalendar/angular';
import { CalendarEvent } from 'src/app/model/calendar-event';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  events: CalendarEvent[] = [
    {
      id: 1,
      groupId: "astronaut-1",
      start: "2020-10-05T12:00:00",
      end: "2020-10-05T19:59:59",
      title: "Pilot ship",
      classNames: ['astronaut-1'],
      overlap: true
    },
    {
      id: 2,
      groupId: "astronaut-2",
      start: "2020-10-05T20:00:00",
      end: "2020-10-06T03:59:59",
      title: "Pilot ship",
      classNames: ['astronaut-1'],
      overlap: true
    },
    {
      id: 3,
      groupId: "astronaut-3",
      start: "2020-10-06T04:00:00",
      end: "2020-10-06T11:59:59",
      title: "Pilot ship",
      classNames: ['astronaut-1'],
      overlap: true
    }
  ]

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.eventService.injectEvents(this.events);
  }

  injectEvents(groupId: string) {
    if(groupId === "all") {
      this.eventService.injectEvents(this.events);
    } else {
      const eventsOfAstronaut = this.events.filter( calendarEvent => calendarEvent.groupId === groupId);
      console.log(eventsOfAstronaut);
      this.eventService.injectEvents(eventsOfAstronaut);
    }
  }

}
