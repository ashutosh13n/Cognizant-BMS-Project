import { Injectable } from '@angular/core';
import {register} from './register'
import { Http,Headers,Response,RequestOptions } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from 'rxjs/observable';

@Injectable()
export class RegService {
    constructor(private http:Http) { }
    
    private extractData(res:Response) {
        let body=res.json() ;
        return body.data || {};
    }
    private handleError(error:any){
    console.error('post error: ',error);
    return Observable.throw(error.statusText);
  }

  submitRegistration(register:register):Observable<any>{
    console.log("Registering.....");
     


    let body=JSON.stringify(register);
    let headers=new Headers({'Content-type':'application/json'});

    let options =new RequestOptions({headers:headers});
    
    return this.http.post(' http://localhost:8080/BankManagementSystem/registartion_status' ,body,options)// http://localhost:3100/postlogin',body,options
  
    .map(this.extractData)
    .catch(this.handleError);


  }

}