import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Astronaut } from 'src/app/model/astronaut';
import { Task } from 'src/app/model/task';
import { SchedulingService } from 'src/app/services/scheduling.service';

@Component({
  selector: 'app-scheduling',
  templateUrl: './scheduling.component.html',
  styleUrls: ['./scheduling.component.css']
})
export class SchedulingComponent implements OnInit {

  workTasks: Task[];
  nonWorkTasks: Task[];
  astronaut: Astronaut;
  nonWorkForm: FormGroup;

  constructor(private schedulingService: SchedulingService, private router: Router) {
    this.nonWorkForm = new FormGroup({

    })
  }

  ngOnInit(): void {
    
  }

}
