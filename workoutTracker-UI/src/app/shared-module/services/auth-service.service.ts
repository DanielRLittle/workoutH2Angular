import { Injectable } from '@angular/core';
import { DataRequestService } from './data-request.service';
import { Observable } from 'rxjs';
import { Iuser } from 'src/app/user/interfaces/Iuser';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private req: DataRequestService) { }

  reqUrl: string = this.req.hostUrl + "/workoutTracker-1.0/api";

  createUser<Iuser>(user: Iuser): Observable<Iuser> {
    return this.req.post<Iuser>(this.reqUrl + '/users', user);
  }

  getAllUsers(): Observable<Iuser> {
    return this.req.get<Iuser>(this.reqUrl + '/users');
  }

  getByUsername(username: Iuser): Observable<Iuser> {
    let urlString = this.reqUrl + '/users/username/' + username.username;
    return this.req.get<Iuser>(urlString);
  }

  deleteCurrentUser(id: number): Observable<Iuser> {
    let urlString = this.reqUrl + '/users/' + id;
    return this.req.delete<Iuser>(urlString);
  }

  updateCurrentUser(id: number, body: Iuser): Observable<Iuser> {
    let urlString = this.reqUrl + '/users/' + id;
    return this.req.put<Iuser>(urlString, body);
  }
}
