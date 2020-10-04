import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../model/task';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private baseURL: string = "https://localhost:8080/api/"

  constructor(private httpClient: HttpClient) { }

  getAllTasks(): Observable<any> {
    return this.httpClient.get<Task[]>(`${this.baseURL}/tasks`);
  }
}
