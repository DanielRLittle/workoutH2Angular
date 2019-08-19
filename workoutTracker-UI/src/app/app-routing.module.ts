import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateComponent } from './user/create/create.component';
import { ReadOneComponent } from './user/read-one/read-one.component';


const routes: Routes = [
  { path: 'createUser', component: CreateComponent },
  { path: 'userLogin', component: ReadOneComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
