import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-d-button',
  standalone: true,
  imports: [ButtonModule, RouterModule, CommonModule],
  template: `
  <p-button [disabled]="disabled" (onClick)="goTo($event)" [icon]="iconCode" [label]="text">
`,
  styleUrl: './d-button.component.css'
})
export class DButtonComponent implements OnInit {
  @Input() text = "";
  @Input() redirect = "";
  @Input() icon = "";
  @Output() clicked = new EventEmitter<MouseEvent>();
  @Input() disabled = false;
  iconCode:string = "";
  constructor (private router:Router) {

  }
  ngOnInit(): void {
    this.iconCode = this.iconDicionary[this.icon];
  }

  goTo(event: MouseEvent) {
    if (this.redirect) {
      this.router.navigate([this.redirect])
      return;
    }
    this.clicked.emit(event);
  }

  private iconDicionary: {[key: string]: string} = {
    "": "",
    "play": "pi pi-play",
    "previous": "pi pi-step-backward",
    "next": "pi pi-step-forward"
  }

}
