import { Component } from '@angular/core';
import { DButtonComponent } from "../d-button/d-button.component";
import { PlayerProgressComponent } from "./player-progress/player-progress.component";

@Component({
  selector: 'app-player-bar',
  standalone: true,
  imports: [DButtonComponent, PlayerProgressComponent],
  template: `
  <div class="music-info">

  </div>

  <div class="flux-control">
    <div>

    </div>
    <div class="controls">
      <div class="buttons">
        <app-d-button [disabled]="!haveSelectedMusic" icon="previous" ></app-d-button>
        <app-d-button [disabled]="!haveSelectedMusic" icon="play"></app-d-button>
        <app-d-button [disabled]="!haveSelectedMusic" icon="next" ></app-d-button>
      </div>
      <app-player-progress [disabled]="!haveSelectedMusic" [progress]="50"></app-player-progress>
    </div>
    <div>

    </div>
  </div>
  `,
  styleUrl: './player-bar.component.css'
})
export class PlayerBarComponent {
  haveSelectedMusic:boolean = true;
}
