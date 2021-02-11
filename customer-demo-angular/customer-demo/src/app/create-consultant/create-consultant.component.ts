import { Router, RouterModule, Routes } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create-consultant',
  templateUrl: './create-consultant.component.html',
  styleUrls: ['./create-consultant.component.css']
})
export class CreateConsultantComponent implements OnInit {
  constructor(private formBuilder: FormBuilder, public http: HttpClient, private router: Router) { }
  ngOnInit(): void { }
  submitted = false;
  baseURL = "http://localhost:8080/consultant";

  registerForm = this.formBuilder.group({
    name: ['', Validators.required],
  });
  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
    //alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value));
    const headers = { 'content-type': 'application/json' }
    const body = JSON.stringify(this.registerForm.value);
    console.log(body)
    this.http.post(this.baseURL, body, { 'headers': headers }).subscribe((data: any) => {
      console.log("This is response" + data);
      this.router.navigate(['/readAllConsultant']);
    },
      error => {
        console.log("Error in request");
      });
  }
  get f() { return this.registerForm.controls; }
}
