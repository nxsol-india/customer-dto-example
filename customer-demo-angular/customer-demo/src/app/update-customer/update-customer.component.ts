import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  constructor(private router: Router, private formBuilder: FormBuilder, public http: HttpClient, private activatedRoute: ActivatedRoute) { }
  id: any | undefined;
  submitted = false;
  dropdownData: any = [];
  registerForm = this.formBuilder.group({
    name: ['', Validators.required],
    multiSelect: ['', Validators.required]
  });
  name: any;
  consultant: any;

  baseURL = "http://localhost:8080/customer";
  customer: any = [];
  ngOnInit(): void {
    this.id = + this.activatedRoute.snapshot.params.id;
    console.log(this.id);
    this.http.get(this.baseURL + "/" + this.id).subscribe((data: any) => {
      this.name = data.name;
      this.customer = data.consultants;
      console.log(this.customer);

      this.http.get("http://localhost:8080/consultant").subscribe((data: any) => {
        this.dropdownData = data.content;
        console.log("This the dropdown data" + this.dropdownData);
        if (this.customer.length != 0) {
          this.dropdownData.filter((x: any) => {
            this.customer.filter((y: any) => { if (x.id == y) { x.selectedTure = y } });
          });
        }
        console.log(this.dropdownData);
      });

    });


  }

  onSubmit() {
    this.submitted = true;
    console.log(this.registerForm.value.multiSele);
    if (this.registerForm.invalid) {
      return;
    }
    const headers = { 'content-type': 'application/json' }
    var body: any = { consultants: [], name: "", id: "" };
    this.registerForm.value.multiSelect.map((item: any) => {
      this.dropdownData.filter((d: any) => {
        if (d.id == item) {
          body.consultants.push({ "id": d.id, "name": d.name });
        }
      });

    });
    body.name = this.registerForm.value.name;
    body.id = this.id;
    console.log(JSON.stringify(body));
    this.http.put(this.baseURL, JSON.stringify(body), { 'headers': headers }).subscribe((data: any) => {
      console.log("This is response" + data);
      this.router.navigate(['']);
    },
      error => {
        alert("Error in Update");
        console.log("Error in Update request");
      });
    //console.log(body);
    // console.log(body.multiSelect.map(item => { "id" ,item}));
  }
  get f() { return this.registerForm.controls; }
}
