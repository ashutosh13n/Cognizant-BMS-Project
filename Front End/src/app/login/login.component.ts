import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import{Login} from './login';
import {UserService} from './user.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent {

  languages=[];
  public newUser= new Login('','');
    currentUser:Login;

  constructor(private userService: UserService) {
    this.userService.getLanguages()
    .subscribe(
      data=>this.languages=data.languages,
      err=>console.log('get error',err)
    );
   }



  submitForm(form :NgForm){

    console.log(this.newUser);

    //validation before submission can be done here.


    this.userService.postform(this.newUser)
    .subscribe(
      data=>console.log('success',data),
      err=>console.log('error',err)
    )
    }


 loginUser(login: Login): void {
        
        this.userService.postform(login);
    }

}
