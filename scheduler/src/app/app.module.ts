import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FullCalendarModule } from '@fullcalendar/angular';
import { HttpClientModule } from '@angular/common/http';

import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import timeGridPlugin from '@fullcalendar/timegrid';


import { AppComponent } from './app.component';
import { CalendarComponent } from './components/calendar/calendar/calendar.component';
import { HeaderComponent } from './components/header/header.component';
import { SchedulingComponent } from './components/scheduling/scheduling.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

FullCalendarModule.registerPlugins([
  dayGridPlugin, interactionPlugin, timeGridPlugin 
]);

@NgModule({
  declarations: [
    AppComponent,
    CalendarComponent,
    HeaderComponent,
    SchedulingComponent
  ],
  imports: [
    ReactiveFormsModule,
    FormsModule,
    BrowserModule,
    FullCalendarModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
