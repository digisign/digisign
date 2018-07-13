import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import {HttpModule} from '@angular/http';
import { UserService } from './Shared/services/user.service';
const appRoutes : Routes =[
  {path:'', component:HomeComponent},
  {path:'signup', component:SignUpComponent},
  {path:'signin',component:LoginComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LoginComponent,
    HomeComponent,
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes,{enableTracing:true})

  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
