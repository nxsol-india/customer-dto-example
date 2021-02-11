import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { Router, RouterModule, Routes } from '@angular/router';


@Component({
  selector: 'app-update-consultant',
  templateUrl: './update-consultant.component.html',
  styleUrls: ['./update-consultant.component.css']
})
export class UpdateConsultantComponent implements OnInit {

  constructor(private router: Router, private formBuilder: FormBuilder, public http: HttpClient, private activatedRoute: ActivatedRoute) { }
  id: any | undefined;
  submitted = false;
  registerForm = this.formBuilder.group({
    name: ['', Validators.required]
  });
  name: any;
  consultant: any;

  baseURL = "http://localhost:8080/consultant";


  ngOnInit(): void {
    this.id = + this.activatedRoute.snapshot.params.id;
    console.log(this.id);
    this.http.get(this.baseURL + "/" + this.id).subscribe((data: any) => {
      this.name = data.name;
      console.log(data);
    });
  }
  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    const headers = { 'content-type': 'application/json' }
    var body: any = { name: "", id: "" };
    body.name = this.registerForm.value.name;
    body.id = this.id;
    console.log(JSON.stringify(body));
    this.http.put(this.baseURL, JSON.stringify(body), { 'headers': headers }).subscribe((data: any) => {
      console.log("This is response" + data);
      this.router.navigate(['/readAllConsultant']);
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
