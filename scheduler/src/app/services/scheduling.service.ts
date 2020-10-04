import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Astronaut } from '../model/astronaut';
import { NonWorkTask } from '../model/non-work-task';
import { Task } from '../model/task';
import { WorkTask } from '../model/work-task';

@Injectable({
  providedIn: 'root'
})
export class SchedulingService {

  private baseURL: string = "https://localhost:8080/api/"

  constructor(private httpClient: HttpClient) { }

  getAllWorkTasks(): Observable<any> {
    return this.httpClient.get<WorkTask[]>(`${this.baseURL}/work-task`);
  }

  getAllNonWorkTasks(): Observable<any> {
    return this.httpClient.get<NonWorkTask[]>(`${this.baseURL}/non-work-task`);
  }

  addNewWorkTask(workTask: WorkTask): Observable<any> {
    return this.httpClient.post<boolean>(`${this.baseURL}/work-task/new`, workTask);
  }

  addNewNonWorkTask(nonWorkTask: NonWorkTask): Observable<any> {
    return this.httpClient.post<boolean>(`${this.baseURL}/non-work-task/new`, nonWorkTask);
  }

  deleteWorkTask(id: number) {
    return this.httpClient.delete<boolean>(`${this.baseURL}/work-task/delete/${id}`);
  }

  deleteNonWorkTask(id: number) {
    return this.httpClient.delete<boolean>(`${this.baseURL}/non-work-task/delete/${id}`);
  }

  scheduleAllTasks(): Observable<any> {
    return this.httpClient.get<Task[]>(`${this.baseURL}/tasks/schedule`);
  }

  deleteAllTasks(): Observable<any> {
    return this.httpClient.delete<boolean>(`${this.baseURL}/tasks/delete-all`);
  }

  getAstronaut(): Observable<any> {
    return this.httpClient.get<Astronaut>(`${this.baseURL}/astronaut`);
  }

  addNewAstronaut(astronaut: Astronaut): Observable<any> {
    return this.httpClient.post<boolean>(`${this.baseURL}/astronaut/new`, astronaut);
  }
}
