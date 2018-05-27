import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../model/Book";
import {Injectable} from "@angular/core";


@Injectable()
export class BookService {

  private readonly URL="http://localhost:8080/welcome/admin/books/book/all";
  constructor(protected http: HttpClient){
  }

  public getBooks(): Observable<Array<Book>>{
   return this.http.get<Array<Book>>(this.URL);
  }

}
