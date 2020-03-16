import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RiderComponent} from '../users/rider/rider.component';
import {LoginComponent} from '../login/login.component';
import {CustomerComponent} from "../users/customer/customer.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'rider', component: RiderComponent},
  {path: 'customer', component: CustomerComponent},
  {path: '', component: LoginComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule {
}