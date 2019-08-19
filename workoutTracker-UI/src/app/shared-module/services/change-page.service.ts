import { Injectable } from '@angular/core';
import { NavigationService } from './navigation.service';

@Injectable({
  providedIn: 'root'
})
export class ChangePageService {

  constructor(private req: NavigationService) { }

  goToCreate() {
    this.req.changePage("/createUser");
  }

  goToLogin() {
    this.req.changePage("/userLogin");
  }
}
