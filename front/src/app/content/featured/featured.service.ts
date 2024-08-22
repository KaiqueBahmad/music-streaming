import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Music } from '../../components/interfaces/Music.interface';
@Injectable({
  providedIn: 'root'
})
export class FeaturedService {

  private featuredUrl = environment.apiUrl + "/music/featured";

  constructor(private http: HttpClient) {

  }

  getFeatured() {
    return this.http.get<Music[]>(this.featuredUrl);
  }

}
