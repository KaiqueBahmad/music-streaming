import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-d-button',
  standalone: true,
  imports: [ButtonModule, RouterModule, CommonModule],
  template: `
  <p-button (onClick)="goTo($event)" [label]="text">
`,
  styleUrl: './d-button.component.css'
})
export class DButtonComponent {
  @Input() text = "";
  @Input() redirect = "";
  @Output() clicked = new EventEmitter<MouseEvent>();
  
  constructor (private router:Router) {

  }

  goTo(event: MouseEvent) {
    if (this.redirect) {
      this.router.navigate([this.redirect])
      return;
    }
    this.clicked.emit(event);
  }
}
