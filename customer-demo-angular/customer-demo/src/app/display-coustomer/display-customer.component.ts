import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
import { createOfflineCompileUrlResolver } from '@angular/compiler';


@Component({
  selector: 'app-display',
  templateUrl: './display-customer.component.html',
  styleUrls: ['./display-customer.component.css']
})
export class CustomerComponent implements OnInit {
  baseUrl = "http://localhost:8080/customer";
  customer: any = [];
  config = {
    itemsPerPage: 2,
    currentPage: 0,
    totalItems: 5
  };
  constructor(public http: HttpClient, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    var offset = (this.config.totalItems * this.config.currentPage) - this.config.totalItems;
    this.http.get(this.baseUrl + "?offset=" + 0 + "&page=" + this.config.currentPage +
      "&size=" + this.config.itemsPerPage)
      .subscribe((data: any) => {
        this.customer = data;
        // console.log("this is the response=====" + data.totalElements);
        this.config.totalItems = data.totalElements;
      },
        error => {
          console.log("Error in request");
        }
      );
  }
  deleteRecord(id: any) {
    this.http.delete(this.baseUrl + "/" + id)
      .subscribe(() => {
        console.log("Data deleted sucessfully");
        location.reload();

      },
        error => {
          console.log("Error in request");
        }
      );
  }

  pageChanged(event: any) {
    this.config.currentPage = event;
    var offset = (this.config.totalItems * (this.config.currentPage - 1) - this.config.totalItems);
    this.http.get(this.baseUrl + "?offset=" + offset + "&page=" + (this.config.currentPage - 1) +
      "&size=" + this.config.itemsPerPage).subscribe((data: any) => {
        console.log(data);
        this.customer = data;
      },
        error => {
          console.log("Error in request");
        }
      );
  }

  search(event: any) {
    var offset = (this.config.totalItems * (this.config.currentPage - 1) - this.config.totalItems);
    this.http.get(this.baseUrl + "/search" + "?offset=" + 0 + "&page=0" +
      "&size=" + this.config.itemsPerPage + "&searchText=" + event.target.value).subscribe((data: any) => {
        console.log(data);
        this.customer = data;
      },
        error => {
          console.log("Error in request");
        }
      );
  }


}
