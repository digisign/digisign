import { Injectable } from '@angular/core';
import { Http,Response,RequestOptions,Headers} from '@angular/http';
import {User} from "../model/model.user";
import 'rxjs/add/operator/map';
import {AppComponent} from "../app.component";
@Injectable()
export class AuthService {
  constructor(public http: Http) { }
  public logIn(user: User){
var base={
  email:user.email,
  password:user.password
}
    let headers = new Headers();
    headers.append('Accept', 'application/json')
   
    let options = new RequestOptions();
    options.headers=headers;
const URL=AppComponent.API_URL+"/login"
    return this.http.post( URL, base,  options);
  }
  
  logOut() {
    // remove user from local storage to log user out
    return this.http.post(AppComponent.API_URL+"logout",{})
      .map((response: Response) => {
        localStorage.removeItem('currentUser');
      });

  }
}
