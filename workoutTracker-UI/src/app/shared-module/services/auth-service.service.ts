import { Injectable } from '@angular/core';
import { DataRequestService } from './data-request.service';
import { Observable } from 'rxjs';
import { Iuser } from 'src/app/user/interfaces/Iuser';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private req: DataRequestService) { }

  createUser<Iuser>(user: Iuser): Observable<Iuser> {
    return this.req.post<Iuser>(this.req.hostUrl+'/user/create', user);
  }

  getAllUsers(): Observable<Iuser> {
    return this.req.get<Iuser>(this.req.hostUrl+'/user/all');
  }

  getOneUser(username: Iuser): Observable<Iuser> {
    let urlString = this.req.hostUrl+'/user/getUsername?username=' + username.username;
    return this.req.get<Iuser>(urlString);
  }

  deleteCurrentUser(id: string): Observable<Iuser> {
    let urlString = this.req.hostUrl+'/user/delete?id='+id;
    return this.req.delete<Iuser>(urlString);
  }

  updateCurrentUser(username: string, body: Iuser): Observable<Iuser> {
    let urlString = this.req.hostUrl+'/user/updateUser' + username;
    return this.req.put<Iuser>(urlString, body);
  }
}
