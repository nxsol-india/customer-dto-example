import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ConsultantComponent } from './consultant-details/consultant-details.component';
import { CustomerComponent } from './display-coustomer/display-customer.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { DisplayConsultantComponent } from './display-consultant/display-consultant.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CreateConsultantComponent } from './create-consultant/create-consultant.component';
import { ReactiveFormsModule } from '@angular/forms';
import { PerspectiveComponent } from './perspective/perspective.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { UpdateConsultantComponent } from './update-consultant/update-consultant.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    ConsultantComponent,
    DisplayConsultantComponent,
    CreateCustomerComponent,
    CreateConsultantComponent,
    PerspectiveComponent,
    CustomerDetailsComponent,
    UpdateCustomerComponent,
    UpdateConsultantComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
