import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { DButtonComponent } from "../../components/d-button/d-button.component";
import { FeaturedService } from './featured.service';
import { Music } from "../../components/interfaces/Music.interface";
@Component({
  selector: 'app-featured',
  standalone: true,
  imports: [NgFor, DButtonComponent],
  template: `
  <div>
    <h2>Featured Songs</h2>
    <ul class="music-box" *ngFor="let music of featuredMusics">
      <li>
        <img  alt="{{music.name}}">
        <span>{{music.name}}</span>
        <app-d-button icon="play"></app-d-button>
      </li>
    </ul>
    <button (click)="debug()">
      debug
    </button>
  </div>
  `,
  styleUrl: './featured.component.css'
})
export class FeaturedComponent implements OnInit {

  featuredMusics: Music[] = [
  ];

  constructor(private featuredService:FeaturedService) {
    
  }
  ngOnInit(): void {
    this.featuredMusics = [];
    this.featuredService.getFeatured().subscribe(
      (musics:Music[]) => {
        this.featuredMusics = musics;
      }
    );
  }

  debug() {
    console.log(this.featuredMusics);
  }
  
  //TO-DO the Featured songs should also be provided by a service
}
