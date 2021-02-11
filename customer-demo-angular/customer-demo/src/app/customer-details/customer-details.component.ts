import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  customer: any = [];
  id: any | undefined;

  baseUrl = "http://localhost:8080/customer/readByConsultantId";
  config = {
    itemsPerPage: 2,
    currentPage: 0,
    totalItems: 5
  };
  constructor(private activatedRoute: ActivatedRoute, public http: HttpClient) { }

  ngOnInit(): void {

    this.id = + this.activatedRoute.snapshot.params.id;
    console.log(this.id);
    console.log("this is customer-details");
    var offset = (this.config.totalItems * this.config.currentPage) - this.config.totalItems;
    this.http.get(this.baseUrl + "/" + this.id + "?offset=" + 0 + "&page=" + this.config.currentPage +
      "&size=" + this.config.itemsPerPage)
      .subscribe((data: any) => {
        this.customer = data.content;
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
        this.customer = data.content;
      },
        error => {
          console.log("Error in request");
        }
      );
  }

}
