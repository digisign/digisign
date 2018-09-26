import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {UrlPermission} from "./urlPermission/url.permission";
import {HomeComponent} from "./components/home/home.component";
import {FilepdfComponent} from "./components/filepdf/filepdf.component"
import {FileuplodComponent} from "./components/fileuplod/fileuplod.component";
import {MyFileUpload} from "./components/newfileupload/myfileupload.component";
import {CredentialsviewsComponent} from "./components/credentialsviews/credentialsviews.component";
import {FilesComponent} from "./components/files/files.component";
const appRoutes: Routes = [
  { path: 'profile', component: ProfileComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {path:'fileupload' ,component:FileuplodComponent},
  {path:'files', component:FilesComponent},
  {path:'pdf',component:FilepdfComponent},
  {path:'myfileupload', component:MyFileUpload},
  {path:'Credentialsviews' ,component:CredentialsviewsComponent},
{path:'',component:HomeComponent},
  // otherwise redirect to profile
  { path: '**', redirectTo: '/login' }
];

export const routing = RouterModule.forRoot(appRoutes);
