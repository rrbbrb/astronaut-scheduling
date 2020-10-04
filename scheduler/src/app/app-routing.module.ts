import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalendarComponent } from './components/calendar/calendar/calendar.component';
import { SchedulingComponent } from './components/scheduling/scheduling.component';

const appRoutes: Routes = [
    { path: 'scheduling', component: SchedulingComponent },
    { path: 'calendar', component: CalendarComponent },
    { path: '', redirectTo: '/calendar', pathMatch: 'full'},
    { path: '**', redirectTo: '/calendar', pathMatch: 'full'}
]

@NgModule({
    imports: [
        RouterModule.forRoot(appRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {

}