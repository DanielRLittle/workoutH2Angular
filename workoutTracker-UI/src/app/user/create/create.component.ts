import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from 'src/app/shared-module/services/auth-service.service';
import { FormControl, FormGroup} from '@angular/forms';
import { User, Iuser } from '../interfaces/iuser';
import { ChangePageService } from 'src/app/shared-module/services/change-page.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {

  createUserForm = new FormGroup({
    username: new FormControl(''),
    fname: new FormControl(''),
    lname: new FormControl(''),
    age: new FormControl('')
  });

  constructor(private serv: AuthServiceService, private nav: ChangePageService) { }

  ngOnInit() {
  }

  addUser() {
    const user: Iuser = this.createUserForm.value;
    this.serv.createUser(user).subscribe((x) =>{
      console.log("user added!");
    });
  }

  goToLogin() {
    this.nav.goToLogin();
  }

}
