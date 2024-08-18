import { Component, Input } from '@angular/core';
import { Music } from '../../../components/interfaces/Music.interface';
import { DButtonComponent } from "../../../components/d-button/d-button.component";
import { NgIf } from '@angular/common';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [DButtonComponent, NgIf],
  template: `
<div class="item" (mouseover)="this.mouseIsOver = true;" (mouseout)="this.mouseIsOver = false;" >
  <div class="music-box-about"  >
      <img src="{{music.CoverPath}}" alt="Imagem não Encontrada">
      <p>{{music.name}}</p>
      <p>{{music.authors}}</p>
  </div>
  <app-d-button @fadeInOut *ngIf="mouseIsOver" class="" icon="play"></app-d-button>
</div>
`,
  styleUrl: './card.component.css',
  animations: [
    trigger('fadeInOut', [
      state('in', style({ opacity: 1 })),
      transition(':enter', [
        style({ opacity: 0 }),
        animate('250ms ease-in')
      ]),
      transition(':leave', [
        animate('250ms ease-out', style({ opacity: 0 }))
      ])
    ])
  ]
})
export class CardComponent {
  @Input() music!:Music;
  mouseIsOver: boolean = false;
}
