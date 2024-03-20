import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-register-login',
  templateUrl: './register-login.component.html',
  styleUrls: ['./register-login.component.css']
})
export class RegisterLoginComponent implements OnInit {

  registerOrLogin: FormGroup;
  registered: boolean = false;
  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private userService: UserService) {
    this.registerOrLogin = this.formBuilder.group({
      'userName': ['', [Validators.required]],
      'pass': ['', [Validators.required]]
    })
  }

  ngOnInit(): void {
  }

  onRegister() {
    const data = this.registerOrLogin.value
    this.userService.register(data).subscribe({
      next:() => {},
      error: () => this.registered = false,
      complete: () => this.registered = true
    })
  }

  onLogin() {
    this.registered = false
    const data = this.registerOrLogin.value
    this.userService.login(data).subscribe({
      next: value => {
        localStorage.setItem('token', value.token)
      },
      complete: () => {

        if(this.role() == null){
          this.router.navigate(["/register-login"])
        } else if(this.role() === 'ROLE_ADMIN') {
          this.router.navigate(["/admin-dash"])
        } else if(this.role() === 'ROLE_USER') {
          this.router.navigate(["/user-dash"])
        }
      }
    })
  }

  role() {
    let token = localStorage.getItem('token');
    if(token) {
      let dToken = JSON.parse(atob(token.split('.')[1]));
      return dToken.role;
    } else {
      return null;
    }
  }



}
