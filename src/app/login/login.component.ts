import { Component, OnInit } from '@angular/core';
import {UserService} from '../Shared/services/user.service';
import{FormBuilder} from '@angular/forms'
import {Validators} from '@angular/forms';
import {Router} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: any;
  errorMsg: string;
 

  constructor(
    private formBuilder:FormBuilder,
    private userService:UserService,
    private router:Router
  ) { }

  ngOnInit() {
    this.loginForm=this.formBuilder.group(
      {
        username:['',[Validators.required]],
        password:['',[Validators.required]]
      }
    );
  }
  login():void{
    debugger;
    this.userService.login(this.loginForm.value).subscribe(res=>{
      if(res.status==200 && res.result==true)
      {
        localStorage.setItem('username',this.loginForm.value.username);
        this.router.navigate([''])
      }else{
        this.errorMsg='invalid Account';
      }

    },error =>{
      this.errorMsg=error;    }
  )
  }
}
