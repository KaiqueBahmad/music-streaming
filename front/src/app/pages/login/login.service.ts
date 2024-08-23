import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../../components/interfaces/User.interface';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
 
  userData: User|null = null;

  constructor(private http: HttpClient) { 
    
  }

  public isLoggedIn() {
    return this.userData != null;
  }

}
