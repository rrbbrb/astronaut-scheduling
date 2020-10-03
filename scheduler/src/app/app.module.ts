import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FullCalendarModule } from '@fullcalendar/angular';

import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import timeGridPlugin from '@fullcalendar/timegrid';


import { AppComponent } from './app.component';
import { CalendarComponent } from './components/calendar/calendar/calendar.component';
import { HeaderComponent } from './components/header/header.component';

FullCalendarModule.registerPlugins([
  dayGridPlugin, interactionPlugin, timeGridPlugin 
]);

@NgModule({
  declarations: [
    AppComponent,
    CalendarComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FullCalendarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
