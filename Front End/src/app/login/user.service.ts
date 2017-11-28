import { Injectable } from '@angular/core';
import {Login} from './login'
import { Http,Headers,Response,RequestOptions } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from 'rxjs/observable';



@Injectable()
export class UserService {
  constructor(private http:Http) { }

  private extractData(res:Response){
    let body=res.json();
    return body.data || {};
  }

  private extractLanguages(res:Response){
    let body=res.json();
    return body.data || {};
  }

  private handleError(error:any){
    console.error('post error: ',error);
    return Observable.throw(error.statusText);
  }

  getLanguages():Observable<any>{
    return this.http.get('http://localhost:3100/get-languages') // //http://10.224.42.38/Article/all-articles
    .map(this.extractLanguages)
    .catch(this.handleError);
  }





  postform(login:Login):Observable<any>{
    console.log("posting.....");


    let body=JSON.stringify(login);
    let headers=new Headers({'Content-type':'application/json'});

    let options =new RequestOptions({headers:headers});
    
    return this.http.post(' http://localhost:8080/BankManagementSystem/user_exists' ,body,options)// http://localhost:3100/postlogin',body,options
  
    .map(this.extractData)
    .catch(this.handleError);


  }
}
