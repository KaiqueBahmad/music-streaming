import { Component, Input } from '@angular/core';
import { Music } from '../../../components/interfaces/Music.interface';
import { DButtonComponent } from "../../../components/d-button/d-button.component";
import { NgIf } from '@angular/common';

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
  <app-d-button *ngIf="mouseIsOver" class="" icon="play"></app-d-button>
</div>
`,
  styleUrl: './card.component.css'
})
export class CardComponent {
  @Input() music!:Music;
  mouseIsOver: boolean = false;
}
