import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from 'src/app/shared-module/services/auth-service.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Iuser } from '../interfaces/iuser';
import { NavigationService } from 'src/app/shared-module/services/navigation.service';
import { ChangePageService } from 'src/app/shared-module/services/change-page.service';

@Component({
  selector: 'app-read-one',
  templateUrl: './read-one.component.html',
  styleUrls: ['./read-one.component.scss']
})
export class ReadOneComponent implements OnInit {

  constructor(private serv: AuthServiceService, private nav: ChangePageService) { }

  ngOnInit() {
  }

  oneUser: Iuser;
  userKeys: string[];
  updateOne: boolean = false;

  loginForm = new FormGroup({
    username: new FormControl('')
  });

  updateForm = new FormGroup({
    fname: new FormControl(''),
    lname: new FormControl(''),
    age: new FormControl('')
  });

  findUser() {
    this.serv.getOneUser(this.loginForm.value).subscribe((x) =>{
      console.log(x);
      this.oneUser = x;
      this.userKeys = Object.keys(x || {});
    });
  }

  findAll() {
    this.serv.getAllUsers().subscribe((x) =>{
      console.log(x);
    });
  }

  deleteCurrent() {
    this.serv.deleteCurrentUser(this.oneUser._id).subscribe(() => {
      console.log("user deleted");
      this.findUser();
    });
  }

  editCurrent() {
    this.updateOne = true;
  }

  updateCurrent() {
    const user: Iuser = this.updateForm.value;
    this.serv.updateCurrentUser(this.oneUser.username, user);
    this.findUser();
  }

  goFalse() {
    this.updateOne = false;
    this.findUser();
  }

  goToCreate () {
    this.nav.goToCreate();
  }
}
