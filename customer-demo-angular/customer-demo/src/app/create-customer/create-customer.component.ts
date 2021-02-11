import { HttpClient } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, public http: HttpClient, private router:Router) { }
  submitted = false;
  dropdownData: any;
  baseURL = "http://localhost:8080/customer";
  ngOnInit(): void {

    this.http.get("http://localhost:8080/consultant").subscribe((data: any) => {
      this.dropdownData = data.content;
      console.log("This the dropdown data" + this.dropdownData);

    });
  }
  registerForm = this.formBuilder.group({
    name: ['', Validators.required],
    multiSelect: ['', Validators.required]
  });
  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    const headers = { 'content-type': 'application/json' }
    var body: any = { consultants: [], name: "" };
    this.registerForm.value.multiSelect.map((item: any) => { body.consultants.push({ "id": item }); });
    // body.consultants.push(consultants);
    body.name = this.registerForm.value.name;
    this.http.post(this.baseURL, body, { 'headers': headers }).subscribe((data: any) => {

      console.log("This is response" + data);
      this.router.navigate(['']);
    },
      error => {
        alert("Error in Create");
        console.log("Error in request");
      });
    //console.log(body);

    // console.log(body.multiSelect.map(item => { "id" ,item}));
  }
  get f() { return this.registerForm.controls; }
}
