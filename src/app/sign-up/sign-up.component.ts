import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup} from '@angular/forms';
import {Validators} from '@angular/forms';
import {Router} from '@angular/router';
import { UserService } from '../Shared/services/user.service';
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css'],
  providers: [UserService]
})
export class SignUpComponent implements OnInit {
registerForm:FormGroup;
errorMsg:String;
  constructor(
    private formBuilder:FormBuilder,
    private userService:UserService,
    private router:Router


  ) { }

  ngOnInit() {

    this.registerForm=this.formBuilder.group(
      {
        username:['',[Validators.required]],
        password:['',[Validators.required]]
      }
    );
  
  }
  save():void{
    debugger;
    this.userService.create(this.registerForm.value).subscribe(res=>{
      if(res.status==200 && res.result==true)
      {
        localStorage.setItem('username',this.registerForm.value.username);
        this.router.navigate([''])
      }

    },error =>{
      this.errorMsg=error;    }
  )
  }
}
  
   

