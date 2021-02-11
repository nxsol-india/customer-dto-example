import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';

@Component({
  selector: 'app-displayconsultant',
  templateUrl: './consultant-details.component.html',
  styleUrls: ['./consultant-details.component.css']
})
export class ConsultantComponent implements OnInit {
  consulantat: any = [];
  id: any | undefined;
  arrayObj: any = [];


  constructor(public http: HttpClient, private activatedRoute: ActivatedRoute) { }
  baseUrl = "http://localhost:8080/consultant/readByCoustomerId";
  config = {
    itemsPerPage: 2,
    currentPage: 0,
    totalItems: 5
  };
  ngOnInit(): void {
    this.id = + this.activatedRoute.snapshot.params.id;
    console.log(this.id);
    var offset = (this.config.totalItems * this.config.currentPage) - this.config.totalItems;
    this.http.get(this.baseUrl + "/" + this.id + "?offset=" + 0 + "&page=" + this.config.currentPage +
      "&size=" + this.config.itemsPerPage)
      .subscribe((data: any) => {
        this.consulantat = data.content;
        this.config.totalItems = data.totalElements;
        // for (let index = 0; index < (this.consulantat).length; index++) {
        //   this.consulantat.filter((x: any) => {
        //     if (x.id === this.id) {
        //       this.arrayObj = x;
        //     }
        //   });
        //   console.log('Json Object Data by ID ==> ', this.arrayObj);
        // }

      },
        error => {
          console.log("Error in request");
        }
      );


  }
  pageChange(event: any) {
    this.config.currentPage = event;
    var offset = (this.config.totalItems * (this.config.currentPage - 1) - this.config.totalItems);
    this.http.get(this.baseUrl + "/" + this.id + "?offset=" + offset + "&page=" + (this.config.currentPage - 1) +
      "&size=" + this.config.itemsPerPage).subscribe((data: any) => {
        this.consulantat = data.content;
      },
        error => {
          console.log("Error in request");
        }
      );
  }
}
