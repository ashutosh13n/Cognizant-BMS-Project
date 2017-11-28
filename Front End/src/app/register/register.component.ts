import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import {NgForm} from '@angular/forms';
import {RegService} from './register.service';
import {register} from './register';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class RegisterComponent  {

  constructor(private regService:RegService ) {}
  
  public newCustomer= new register(null,'','','','','',undefined,undefined,'',undefined,'','','','','','','','','','',null,'',3197878275421111,undefined,'Saving',4444,'hinjewadi');
  ngOnInit() {
  }


  submitRegistrationForm(form :NgForm){

    console.log(this.newCustomer);
    

    //validation before submission can be done here.


    this.regService.submitRegistration(this.newCustomer)
    .subscribe(
      data=>console.log('success',data),
      err=>console.log('error',err)
    )
    }

}
