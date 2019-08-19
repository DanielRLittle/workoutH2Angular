import { Injectable } from '@angular/core';
import { DataRequestService } from './data-request.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NavigationService {

  constructor() { }

  hostUrl: string = "http://localhost:4200";

  changePage(urlAddOn: string): string {
    let newLocation: string = this.hostUrl + urlAddOn;
    return window.location.href = newLocation;
  }
}
