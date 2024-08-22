import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { DButtonComponent } from "../../components/d-button/d-button.component";
import { FeaturedService } from './featured.service';
import { Music } from "../../components/interfaces/Music.interface";
import { CardComponent } from "./card/card.component";
import { CarouselModule } from 'primeng/carousel';



@Component({
  selector: 'app-featured',
  standalone: true,
  imports: [NgFor, DButtonComponent, CardComponent, CarouselModule],
  template: `
  <div>
    <h2>Featured Songs <button (click)="debug()">
      debug
    </button></h2>
    <p-carousel [value]="featuredMusics" [numVisible]="4" [numScroll]="1" [circular]="false">
      <ng-template let-music pTemplate="item">
        <app-card [music]="music" ></app-card>
      </ng-template>
    </p-carousel>

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
    this.featuredMusics = [];
    this.featuredService.getFeatured().subscribe(
      (musics:Music[]) => {
        this.featuredMusics = musics;
        console.log(this.featuredMusics);
      }
    );
  }

  
  //TO-DO the Featured songs should also be provided by a service
}
