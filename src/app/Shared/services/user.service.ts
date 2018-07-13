import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Response} from '@angular/http';
import {Observable} from 'rxjs';
import { User } from '../../user.model';


@Injectable()

export class UserService {
 private BASE_URL='http://localhost:8080';
  
 
  constructor(private http:Http){}
  create(user:User):Observable<any>
  {
    return this.http.post(this.BASE_URL + 'create', user)
    .map(
      (res:Response)=>
      {
        return {status: res.status,result:res.json()}
      }
    )
    .catch(
      (error:Error) =>{
      return Observable.throw(
        new Error(error.message));
       }
      )
  }
  login(user:User):Observable<any>
  {
    return this.http.post(this.BASE_URL +'create',user)
    .map(
      (res:Response)=>{
        return {status:res.status,result:res.json()}
      }
    )
    .catch(
      (error:Error) =>{
      return Observable.throw(
        new Error(error.message));
       }
      )
  }
  
  }



