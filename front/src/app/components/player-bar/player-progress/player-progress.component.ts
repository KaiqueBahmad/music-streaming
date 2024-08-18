import { Component, Input } from '@angular/core';
import { ProgressBarModule } from 'primeng/progressbar';
@Component({
  selector: 'app-player-progress',
  standalone: true,
  imports: [ProgressBarModule],
  template: `
  <div class="progress-wrap">
    @if (disabled || !progress) {
      <p-progressBar [value]="0" [showValue]="false" [style]="{ height: '6px' }" ></p-progressBar>
    } @else {
      <p-progressBar [value]="progress" [showValue]="false" [style]="{ height: '6px' }" ></p-progressBar>  
    }
  </div>
  `,
  styleUrl: './player-progress.component.css'
})
export class PlayerProgressComponent {
  @Input() disabled = true;
  @Input() progress:number = 1;
}

