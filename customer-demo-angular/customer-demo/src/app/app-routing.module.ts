import { UpdateConsultantComponent } from './update-consultant/update-consultant.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CreateConsultantComponent } from './create-consultant/create-consultant.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './display-coustomer/display-customer.component';
import { ConsultantComponent } from './consultant-details/consultant-details.component';
import { DisplayConsultantComponent } from './display-consultant/display-consultant.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
const routes: Routes = [
  { path: '', component: CustomerComponent },

  {
    path: 'details/:id',
    component: ConsultantComponent
  },
  {
    path: 'updateCustomer/:id',
    component: UpdateCustomerComponent
  },
  {
    path: 'detailsCustomer/:id',
    component: CustomerDetailsComponent
  },
  {
    path: 'readAllConsultant',
    component: DisplayConsultantComponent
  },
  {
    path: 'createConsultant',
    component: CreateConsultantComponent
  },
  {
    path: 'createCustomer',
    component: CreateCustomerComponent
  },
  {
    path: 'updateConsultant/:id',
    component: UpdateConsultantComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
