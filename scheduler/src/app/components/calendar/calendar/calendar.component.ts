import { Component, OnInit } from '@angular/core';
import { CalendarOptions, EventInput } from '@fullcalendar/angular';
import { CalendarEvent } from 'src/app/model/calendar-event';
import { Task } from 'src/app/model/task';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})

export class CalendarComponent implements OnInit {

  tasks: Task[];
  
  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.tasks = [];
    this.eventService.getAllTasks().subscribe( data => {
      this.tasks = data;
      this.renderCalendar(this.tasks);
    })
  }
  
  calendarOptions: CalendarOptions;

  renderCalendar(tasks: Task[]) {
    const calEvents = tasks.map( task => {
      var calendarEvent = new CalendarEvent();
      calendarEvent.id = +task.id;
      calendarEvent.title = task.title;
      calendarEvent.start = JSON.stringify(task.startTime);
      calendarEvent.end = JSON.stringify(task.endTime);
      if(task.isWorkTask) {
        calendarEvent.classNames = ['work'];
      } else {
        calendarEvent.classNames = ['non-work'];
      }
      return calendarEvent;
    })
    this.calendarOptions = {
      initialView: 'dayGridMonth',
      weekends: true,
      navLinks: true,
      events: <EventInput>calEvents,
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      }
    }
  }

}
