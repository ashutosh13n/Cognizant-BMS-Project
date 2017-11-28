import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import 'rxjs/add/operator/toPromise';
import {RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';

import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { UserService } from "./login/user.service";
import {RegService} from "./register/register.service";

@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    AboutComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot([
      {path:'login',component:LoginComponent},
      {path:'register',component:RegisterComponent},
      {path:'about',component:AboutComponent},
      {path:'contact',component:ContactComponent},
      {path:'home',component:HomeComponent},
    ])
  ],
  providers: [UserService,RegService],
  bootstrap: [AppComponent]
})
export class AppModule { }
