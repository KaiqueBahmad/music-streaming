import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class FeaturedService {

  private baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) {
    
  }
}
