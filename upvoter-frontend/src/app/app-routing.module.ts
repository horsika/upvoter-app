import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterLoginComponent} from "./components/register-login/register-login.component";
import {AdminDashComponent} from "./components/admin-dash/admin-dash.component";
import {UserDashComponent} from "./components/user-dash/user-dash.component";

const routes: Routes = [
  {path: "", component: RegisterLoginComponent},
  {path: "register-login", component: RegisterLoginComponent},
  {path: "admin-dash", component: AdminDashComponent},
  {path: "user-dash", component: UserDashComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
