import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';

@Component({
  selector: 'app-yourbooks',
  templateUrl: './yourbooks.component.html',
  styleUrls: ['./yourbooks.component.scss']
})
export class YourbooksComponent implements OnInit {
  books:any = [];
  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getAllYourBooks().subscribe((response)=>{
      if(response && response.length > 0){
        this.books=response;
      }
  });
  }

}
