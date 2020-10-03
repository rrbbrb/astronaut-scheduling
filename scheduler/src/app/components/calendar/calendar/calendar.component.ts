import { Component, OnInit } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/angular';
import { CalendarEvent } from 'src/app/model/calendar-event';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})

export class CalendarComponent implements OnInit {

  events: any;

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.events = [];
    this.renderCalendar();
  }
  
  calendarOptions: CalendarOptions;

  renderCalendar() {
    this.eventService.currentEvents.subscribe( events => {
      this.events = events;
      console.log("from calendar"+JSON.stringify(this.events));
    });
    this.calendarOptions = {
      initialView: 'dayGridMonth',
      weekends: true,
      navLinks: true,
      events: this.events,
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      }
    }
  }

}
