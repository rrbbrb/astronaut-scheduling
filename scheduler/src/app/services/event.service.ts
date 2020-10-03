import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CalendarEvent } from '../model/calendar-event';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private events = new BehaviorSubject<CalendarEvent[]>(null);
  currentEvents = this.events.asObservable();

  constructor() { }

  injectEvents(events: CalendarEvent[]) {
    this.events.next(events);
  }
}
