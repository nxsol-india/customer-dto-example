import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
@Component({
  selector: 'app-display-consultant',
  templateUrl: './display-consultant.component.html',
  styleUrls: ['./display-consultant.component.css']
})
export class DisplayConsultantComponent implements OnInit {
  baseUrl = "http://localhost:8080/consultant";
  consultant: any = [];
  config = {
    itemsPerPage: 2,
    currentPage: 0,
    totalItems: 5
  };
  constructor(public http: HttpClient, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

    this.http.get(this.baseUrl)
      .subscribe((data: any) => {
        this.consultant = data;
        // console.log("this is the response=====" + data.totalElements);
        this.config.totalItems = data.totalElements;
      },
      );

  }

  deleteRecord(id: any) {
    //console.log("delete" + id);
    this.http.delete(this.baseUrl + "/" + id)
      .subscribe(() => {
        console.log("record deleted sucessfully");
        location.reload();

      },
        error => {
          console.log("Error in request");
        }
      );
  }
  pageChanged(event: any) {
    this.config.currentPage = event;
    this.http.get(this.baseUrl + "?offset=" + 1 + "&pageNumber=" + this.config.totalItems +
      " & pageSize=" + this.config.itemsPerPage).subscribe((data: any) => {
        console.log(data);
        this.consultant = data;
      }
      );

  }


  search(event: any) {
    var offset = (this.config.totalItems * (this.config.currentPage - 1) - this.config.totalItems);
    this.http.get(this.baseUrl + "/search" + "?searchText=" + event.target.value + "&offset=" + 0 + "&page=0" +
      "&size=" + this.config.itemsPerPage).subscribe((data: any) => {
        console.log(data);
        this.consultant = data;
      },
        error => {
          console.log("Error in request");
        }
      );
  }

}
