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

  constructor(private eventService: EventService) { }

  ngOnInit(): void {  }

}
