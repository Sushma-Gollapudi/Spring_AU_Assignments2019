import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { BookService } from 'src/app/providers/book.service';
import { Book } from 'src/app/model/book';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  books:any = [];
  book:any;
  //yourBook:Book;

  id:string;
  title:string;
  description:string;
  author:string;
  price:number;
  constructor(private bookService: BookService) { }

  ngOnInit() {
   
    this.bookService.getAllBooks().subscribe((response)=>{
        if(response && response.length > 0){
          this.books=response;
        }
    });
    //this.yourBook=new Book;
  }

  addToYourBooks(yourBook){
    
    //const yourBook=new Book(this.id,this.title,this.description,this.author,this.price);
    this.bookService.addToYourBook(yourBook).subscribe((response)=>{
      console.log(response);
    });

  }

}
